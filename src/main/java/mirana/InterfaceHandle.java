package mirana;

import com.sun.javadoc.*;
import mirana.util.extend.CodeAnalyzeUtil;
import mirana.util.extend.DocContentUtil;
import mirana.util.extend.MdFileUtil;
import mirana.util.extend.NoteUtil;

public class InterfaceHandle extends Doclet {

    public static boolean start(RootDoc root) {
        for (ClassDoc classDoc : root.classes()) {
            CodeAnalyzeUtil codeAnalyzeUtil = new CodeAnalyzeUtil();
            codeAnalyzeUtil.initMethod(classDoc.name());
            String content = "";
            content += DocContentUtil.getLine();
            content += DocContentUtil.getClassTitle(classDoc.name(), classDoc.commentText());
            for (MethodDoc methodDoc : classDoc.methods(false)) {
                if (!codeAnalyzeUtil.methodNeed(classDoc.name(), methodDoc.name())) {
                    continue;
                }

                String[] parameterNames = new String[methodDoc.parameters().length];

                String contentParamTable = "";
                if (methodDoc.parameters().length > 0) {
                    contentParamTable += DocContentUtil.getMethodTableTitle();
                    for (int i = 0; i < methodDoc.parameters().length; i++) {
                        Parameter parameter = methodDoc.parameters()[i];
                        parameterNames[i] = parameter.name();
                        String paramComment = getParameterCommentByName(methodDoc.paramTags(), parameter.name());
                        String type = codeAnalyzeUtil.getMethodParamType(methodDoc.name(), parameter.name());
                        contentParamTable += DocContentUtil.getTableRow(parameter.name(), type, paramComment);
                    }
                }

                String returnTypeName = codeAnalyzeUtil.getMethodReturnType(methodDoc.name());
                content += DocContentUtil.getMethodTitle(returnTypeName, methodDoc.name(), parameterNames, methodDoc.commentText());

                String methodRemark = NoteUtil.getRemark(methodDoc);
                if (!methodRemark.isEmpty()) {
                    content += methodRemark + "\n";
                }

                content += contentParamTable;
            }
            MdFileUtil.writeInterface(content, classDoc.typeName());
        }
        return true;
    }

    private static String getParameterCommentByName(ParamTag[] paramTags, String paramName) {
        for (ParamTag paramTag : paramTags) {
            if (paramTag.parameterName().equals(paramName)) {
                return paramTag.parameterComment();
            }
        }
        return "";
    }
}
