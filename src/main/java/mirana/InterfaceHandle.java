package mirana;

import com.sun.javadoc.*;
import mirana.util.extend.CodeAnalyzeUtil;
import mirana.util.extend.DocContentUtil;
import mirana.util.extend.MdFileUtil;

public class InterfaceHandle extends Doclet {

    public static boolean start(RootDoc root) {
        for (ClassDoc classDoc : root.classes()) {
            CodeAnalyzeUtil codeAnalyzeUtil = new CodeAnalyzeUtil();
            codeAnalyzeUtil.initMethod(classDoc.name());
            String content = "";
            content += DocContentUtil.getLine();
            content += DocContentUtil.getClassTitle(classDoc.name(), classDoc.getRawCommentText());
            for (MethodDoc methodDoc : classDoc.methods(false)) {
                if (!methodNeed(classDoc, methodDoc)) {
                    continue;
                }

                String[] parameterNames = new String[methodDoc.paramTags().length];

                String contentParamTable = "";
                if (methodDoc.paramTags().length > 0) {
                    contentParamTable += DocContentUtil.getMethodTableTitle();
                    for (int i = 0; i < methodDoc.paramTags().length; i++) {
                        Parameter parameter = methodDoc.parameters()[i];
                        parameterNames[i] = parameter.name();
                        ParamTag paramTag = methodDoc.paramTags()[i];
                        String type = codeAnalyzeUtil.getMethodParamType(methodDoc.name(),parameter.name());
                        contentParamTable += DocContentUtil.getTableRow(paramTag.parameterName(), type, paramTag.parameterComment(), "");
                    }
                }

                String returnTypeName = codeAnalyzeUtil.getMethodReturnType(methodDoc.name());
                content += DocContentUtil.getMethodTitle(returnTypeName, methodDoc.name(), parameterNames, methodDoc.commentText());
                content += contentParamTable;
            }
            MdFileUtil.writeInterface(content, classDoc.typeName());
        }
        return true;
    }

    private static boolean methodNeed(ClassDoc classDoc, MethodDoc methodDoc) {
        for (String service : Config.serviceList) {
            if (service.equals(classDoc.name())) {
                boolean contains = false;
                for (String method : Config.methodWhiteList) {
                    if (method.equals(methodDoc.name())) {
                        contains = true;
                    }
                }
                return contains;
            }
        }
        return true;
    }
}
