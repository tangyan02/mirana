import com.sun.javadoc.*;
import util.bussiness.DocContentUtil;
import util.bussiness.MdFileUtil;

public class InterfaceHandle extends Doclet {

    public static boolean start(RootDoc root) {
        String content = "";
        for (ClassDoc classDoc : root.classes()) {
            content += DocContentUtil.getLine();
            content += DocContentUtil.getClassTitle(classDoc.name(), classDoc.getRawCommentText());
            for (MethodDoc methodDoc : classDoc.methods(false)) {
                String[] parameterNames = new String[methodDoc.paramTags().length];

                String contentParamTable = "";
                if (methodDoc.paramTags().length > 0) {
                    contentParamTable += DocContentUtil.getMethodTableTitle();
                    for (int i = 0; i < methodDoc.paramTags().length; i++) {

                        Parameter parameter = methodDoc.parameters()[i];
                        parameterNames[i] = parameter.name();
                        ParamTag paramTag = methodDoc.paramTags()[i];
                        contentParamTable += DocContentUtil.getTableRow(paramTag.parameterName(), parameter.type().typeName(), paramTag.parameterComment());
                    }
                }

                String returnTypeName = methodDoc.returnType().typeName();
                content += DocContentUtil.getMethodTitle(returnTypeName, methodDoc.name(), parameterNames, methodDoc.commentText());
                content += contentParamTable;
            }
        }
        MdFileUtil.writeInterface(content);
        return true;
    }
}
