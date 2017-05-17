package mirana.util.extend;

import mirana.Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeAnalyzeUtil {

    private Map<String, String> entityTypeMap = new HashMap<>();

    private Map<String, Map<String, String>> methodParamTypeMap = new HashMap<>();

    private Map<String, String> methodReturnTypeMap = new HashMap<>();

    public void initEntity(String className) {
        try {
            entityTypeMap.clear();
            BufferedReader reader = new BufferedReader(new FileReader(getFile(className, Config.entityPath)));
            String line;
            while ((line = reader.readLine()) != null) {
                String entityRegex = "(private)? +(?<type>\\w+|\\w+<[<>\\w ,]+>) +(?<name>\\w+);";
                Pattern pattern = Pattern.compile(entityRegex);
                Matcher matcher = pattern.matcher(line);
                boolean result = matcher.find();
                if (result) {
                    String type = matcher.group("type").replace("<", "\\<").replace(">", "\\>");
                    if (type.equals("return")) {
                        continue;
                    }
                    entityTypeMap.put(matcher.group("name"), type);
                }
            }
        } catch (IOException e) {
        }
    }

    public void initMethod(String className) {
        try {
            methodParamTypeMap.clear();
            methodReturnTypeMap.clear();
            BufferedReader reader = new BufferedReader(new FileReader(getFile(className, Config.interfacePath)));
            String line;
            while ((line = reader.readLine()) != null) {
                //去除Annotation
                String annotation;
                while ((annotation = getAnnotation(line)) != null) {
                    line = line.replace(annotation, "");
                }
                //抓取returnType,methodName,params
                String methodRegex = "(?<returnType>\\w+|\\w+<[<>\\w ,]+>) (?<methodName>\\w+)\\((?<params>.*)\\)( +throws +\\w+)?;";
                Pattern pattern = Pattern.compile(methodRegex);
                Matcher matcher = pattern.matcher(line);
                boolean result = matcher.find();
                if (result) {
                    String returnType = matcher.group("returnType");
                    String methodName = matcher.group("methodName");
                    methodReturnTypeMap.put(methodName, returnType);
                    Map<String, String> paramTypes = new HashMap<>();

                    String params = matcher.group("params");
                    String param;
                    //逐步抓取单个paramType
                    while ((param = getParam(params)) != null) {
                        String regexParam = "(?<type>\\w+|\\w+<[<>\\w ,]+>) +(?<name>\\w+)";
                        pattern = Pattern.compile(regexParam);
                        matcher = pattern.matcher(params);
                        result = matcher.find();
                        if (result) {
                            String type = matcher.group("type").replace("<", "\\<").replace(">", "\\>");
                            String name = matcher.group("name");
                            paramTypes.put(name, type);
                        }
                        params = params.replace(param, "");
                    }
                    methodParamTypeMap.put(methodName, paramTypes);
                }
            }
        } catch (IOException e) {
        }
    }

    public String getMethodParamType(String method, String param) {
        if (methodParamTypeMap.containsKey(method)) {
            if (methodParamTypeMap.get(method).containsKey(param)) {
                return methodParamTypeMap.get(method).get(param);
            }
        }
        return "";
    }

    public String getMethodReturnType(String method) {
        if (methodReturnTypeMap.containsKey(method)) {
            return methodReturnTypeMap.get(method);
        }
        return "";
    }

    public String getEntityPropertyType(String name) {
        if (entityTypeMap.containsKey(name)) {
            return entityTypeMap.get(name);
        }
        return "";
    }

    private File getFile(String className, String[] paths) {
        String fileName = className + ".java";
        for (String path : paths) {
            Pattern pattern = Pattern.compile(fileName);
            Matcher matcher = pattern.matcher(path);
            boolean result = matcher.find();
            if (result) {
                return new File(path);
            }
        }
        return null;
    }

    private static String getAnnotation(String line) {
        String annotationRegex = "(?<annotation>@\\w+(\\([,\\w =\"\\u4e00-\\u9fa5]+\\))?)";
        Pattern pattern = Pattern.compile(annotationRegex);
        Matcher matcher = pattern.matcher(line);
        boolean result = matcher.find();
        if (result) {
            return matcher.group("annotation");
        }
        return null;
    }

    private static String getParam(String params) {
        String methodParamRegex = "(?<param>(\\w+|\\w+<[<>\\w ]+>) +\\w+)";
        Pattern pattern = Pattern.compile(methodParamRegex);
        Matcher matcher = pattern.matcher(params);
        boolean result = matcher.find();
        if (result) {
            return matcher.group("param");
        }
        return null;
    }
}
