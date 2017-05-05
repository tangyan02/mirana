import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.RootDoc;
import util.bussiness.DocContentUtil;
import util.bussiness.MdFileUtil;

public class EntityHandle extends Doclet {

    public static boolean start(RootDoc root) {
        String content = "";
        content += DocContentUtil.getLine();
        for (ClassDoc classDoc : root.classes()) {
            content += DocContentUtil.getClassTitle(classDoc.name(), classDoc.getRawCommentText());
            content += DocContentUtil.getEntityTableTitle();
            for (FieldDoc fieldDoc : classDoc.fields(false)) {
                content += DocContentUtil.getTableRow(fieldDoc.name(), fieldDoc.type().typeName(), fieldDoc.getRawCommentText(), "");
            }
        }
        MdFileUtil.writeEntity(content);
        return true;
    }
}
