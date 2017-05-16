package mirana;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.RootDoc;
import mirana.util.extend.CodeAnalyzeUtil;
import mirana.util.extend.DocContentUtil;
import mirana.util.extend.MdFileUtil;
import mirana.util.extend.NoteUtil;

public class EntityHandle extends Doclet {

    public static boolean start(RootDoc root) {
        String content = "";
        for (ClassDoc classDoc : root.classes()) {
            CodeAnalyzeUtil codeAnalyzeUtil = new CodeAnalyzeUtil();
            codeAnalyzeUtil.initEntity(classDoc.name());
            content += DocContentUtil.getClassTitle(classDoc.name(), classDoc.getRawCommentText());
            content += DocContentUtil.getEntityTableTitle();
            for (FieldDoc fieldDoc : classDoc.fields(false)) {
                String type = codeAnalyzeUtil.getEntityPropertyType(fieldDoc.name());
                String remark = NoteUtil.getRemark(fieldDoc);
                content += DocContentUtil.getTableRow(fieldDoc.name(), type, fieldDoc.commentText(), remark);
            }
        }
        MdFileUtil.writeEntity(content);
        return true;
    }
}
