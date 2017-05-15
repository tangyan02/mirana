package cn.tangyancode.mirana;

import cn.tangyancode.mirana.util.extend.DocContentUtil;
import cn.tangyancode.mirana.util.extend.MdFileUtil;
import cn.tangyancode.mirana.util.extend.NoteUtil;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.RootDoc;

public class EntityHandle extends Doclet {

    public static boolean start(RootDoc root) {
        String content = "";
        for (ClassDoc classDoc : root.classes()) {
            content += DocContentUtil.getClassTitle(classDoc.name(), classDoc.getRawCommentText());
            content += DocContentUtil.getEntityTableTitle();
            for (FieldDoc fieldDoc : classDoc.fields(false)) {
                String type = NoteUtil.getType(fieldDoc);
                String remark = NoteUtil.getRemark(fieldDoc);
                content += DocContentUtil.getTableRow(fieldDoc.name(), type, fieldDoc.commentText(), remark);
            }
        }
        MdFileUtil.writeEntity(content);
        return true;
    }
}
