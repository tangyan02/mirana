package mirana;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.RootDoc;
import mirana.util.extend.DocContentUtil;
import mirana.util.extend.MdFileUtil;

public class EnumerationHandle extends Doclet {

    public static boolean start(RootDoc root) {
        String content = "";
        for (ClassDoc classDoc : root.classes()) {
            if (Data.newClassSet.contains(classDoc.name())) {
                Data.newClassSet.remove(classDoc.name());
                content += DocContentUtil.getClassTitle(classDoc.name(), "");
                content += DocContentUtil.getEnumerationTableTitle();
                for (FieldDoc fieldDoc : classDoc.fields(false)) {
                    if (fieldDoc.type().typeName().equals(classDoc.typeName())) {
                        content += DocContentUtil.getTableRow(fieldDoc.name(), fieldDoc.getRawCommentText());
                    }
                }
            }
        }
        MdFileUtil.writeEnumeration(content);
        return true;
    }
}
