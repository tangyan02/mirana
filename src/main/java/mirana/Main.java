package mirana;

import com.fasterxml.jackson.databind.ObjectMapper;
import mirana.util.base.FileUtil;
import mirana.util.base.Global;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String config = "";
        for (String arg : args) {
            config += arg;
        }
        Map<String, List<String>> configs = objectMapper.readValue(config, Map.class);
        Config.classPackagePath = convertToArray(configs.get("classPackagePath"));
        Config.interfacePath = convertToArray(configs.get("interfacePath"));
        Config.serviceList = convertToArray(configs.get("serviceList"));
        Config.methodWhiteList = convertToArray(configs.get("methodWhiteList"));

        FileUtil.deleteFiles(new File(Config.mdOutputPath));

        for (String path : Config.interfacePath) {
            executeJavaDoc(InterfaceHandle.class, path);
        }

        Thread.sleep(5000);

        while (true) {
            String set = objectMapper.writeValueAsString(Data.newClassSet);
            for (String path : Config.classPackagePath) {
                File file = new File(path);
                searchFile(file, (s) -> {
                    executeJavaDoc(EntityHandle.class, s);
                });
            }
            for (String path : Config.classPackagePath) {
                File file = new File(path);
                searchFile(file, (s) -> {
                    executeJavaDoc(EnumerationHandle.class, s);
                });
            }
            String newSet = objectMapper.writeValueAsString(Data.newClassSet);
            if (set.equals(newSet)) {
                break;
            }
        }
    }

    private static void searchFile(File file, Executor runnable) {
        if (file == null) {
            return;
        }
        if (file.list() == null) {
            if (file.getPath().endsWith(".java")) {
                runnable.run(file.getPath());
            }
            return;
        }
        if (file.list().length > 0) {
            for (String name : file.list()) {
                String path = file.getPath() + "/" + name;
                File newFile = new File(path);
                searchFile(newFile, runnable);
            }
        }
    }

    @FunctionalInterface
    interface Executor {
        void run(String path);
    }

    private static void executeJavaDoc(Class handle, String javaFilePath) {
        String[] docArgs = new String[]{"-doclet", handle.getName(), "-docletpath", Config.classPath, javaFilePath};
        Global.filePath = javaFilePath;
        com.sun.tools.javadoc.Main.execute(docArgs);
    }

    private static String[] convertToArray(List<String> list) {
        String[] result = new String[list.size()];
        list.forEach(item -> result[list.indexOf(item)] = item);
        return result;
    }
}
