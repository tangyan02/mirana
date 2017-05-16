package mirana.util.base;

public class MdContentUtil {


    public static String getLine(){
        return "***\n";
    }

    public static String getTableRow(String... strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
        }
        return String.format("|%s|\n", String.join("|", strings));
    }

    public static String getTableLineRow(int size) {
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = ":--";
        }
        return getTableRow(strings);
    }

    public static String getTitleRow(int size, String text) {
        String signal = "";
        for (int i = 0; i < size; i++) {
            signal += "#";
        }
        signal = String.format("%s %s\n", signal, text);
        return signal;
    }

    public static String getJavaCode(String code){
        return String.format("```java\n%s\n```\n",code);
    }
}
