import com.sun.javadoc.*;
import util.extend.DocContentUtil;
import util.extend.MdFileUtil;
import util.extend.NoteUtil;

public class InterfaceHandle extends Doclet {

    public static boolean start(RootDoc root) {
        for (ClassDoc classDoc : root.classes()) {
            String content = "";
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
                        String type = NoteUtil.getParamType(methodDoc, parameter);
                        contentParamTable += DocContentUtil.getTableRow(paramTag.parameterName(), type, paramTag.parameterComment());
                    }
                }

                String returnTypeName = NoteUtil.getReturnType(methodDoc);
                content += DocContentUtil.getMethodTitle(returnTypeName, methodDoc.name(), parameterNames, methodDoc.commentText());
                content += contentParamTable;
            }
            MdFileUtil.writeInterface(content,classDoc.typeName());
        }
        return true;
    }
}
