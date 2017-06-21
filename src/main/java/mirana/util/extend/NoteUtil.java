package mirana.util.extend;

import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Parameter;
import mirana.util.base.TagUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteUtil extends TagUtil {

    public static String getType(FieldDoc fieldDoc) {
        List<String> type = getTagText(fieldDoc, "type");
        if (type.isEmpty()) {
            return fieldDoc.type().typeName();
        }
        String result = type.get(0);
        result = result.replace("<", "\\<");
        result = result.replace(">", "\\>");
        return result;
    }

    public static String getRemark(FieldDoc fieldDoc) {
        List<String> remarks = getTagText(fieldDoc, "remark");
        if (remarks.isEmpty()) {
            return "";
        }
        return remarks.get(0);
    }

    public static String getRemark(MethodDoc methodDoc) {
        List<String> remarks = getTagText(methodDoc, "remark");
        if (remarks.isEmpty()) {
            return "";
        }
        return remarks.get(0);
    }

    public static String getParamType(MethodDoc methodDoc, Parameter parameter) {
        List<String> paramTypes = getTagText(methodDoc, "paramType");
        for (String paramType : paramTypes) {
            String regular = "(?<name>[\\w\\d]+):(?<value>.+)";
            Pattern pattern = Pattern.compile(regular);
            Matcher matcher = pattern.matcher(paramType);
            boolean result = matcher.find();
            if (result) {
                String name = matcher.group("name");
                String value = matcher.group("value");
                if (name.equals(parameter.name())) {
                    value = value.replace("<", "\\<");
                    value = value.replace(">", "\\>");
                    return value;
                }
            }
        }
        return parameter.type().typeName();
    }

    public static String getReturnType(MethodDoc methodDoc) {
        List<String> text = getTagText(methodDoc, "returnType");
        if (text.isEmpty()) {
            return methodDoc.returnType().typeName();
        }
        return text.get(0);
    }
}
