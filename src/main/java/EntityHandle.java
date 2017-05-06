import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.RootDoc;
import util.extend.DocContentUtil;
import util.extend.MdFileUtil;
import util.extend.NoteUtil;

public class EntityHandle extends Doclet {

    public static boolean start(RootDoc root) {
        String content = "";
        content += DocContentUtil.getLine();
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
