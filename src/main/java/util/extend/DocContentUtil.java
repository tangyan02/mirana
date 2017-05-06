package util.extend;

import util.base.MdContentUtil;

public class DocContentUtil extends MdContentUtil {

    public static String getMethodTableTitle() {
        return String.format("%s\n%s%s",
                getTitleRow(5, "参数列表"),
                getTableRow("名称", "类型", "描述", "备注"),
                getTableLineRow(4));
    }

    public static String getEntityTableTitle() {
        return String.format("%s\n%s%s",
                getTitleRow(5, "属性列表"),
                getTableRow("名称", "类型", "描述", "备注"),
                getTableLineRow(4));
    }

    public static String getEnumerationTableTitle() {
        return String.format("%s\n%s%s",
                getTitleRow(5, "枚举详情"),
                getTableRow("名称", "描述"),
                getTableLineRow(2));
    }

    public static String getClassTitle(String name, String comment) {
        return String.format("\n%s\n",
                getTitleRow(3, String.format("%s %s", name.trim(), comment.trim())));
    }

    public static String getMethodTitle(String returnType, String name, CharSequence[] parameters, String comment) {
        return String.format("\n%s%s\n",
                getTitleRow(4, comment.trim()),
                getJavaCode(String.format("%s %s(%s)",
                        returnType,
                        name.trim(),
                        String.join(",", parameters))));
    }
}
