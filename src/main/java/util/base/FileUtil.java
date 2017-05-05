package util.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static void write(String path, String name, String text) throws IOException {
        File file = new File(path, name);
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }

        byte bt[];
        bt = text.getBytes();
        FileOutputStream in = new FileOutputStream(file);
        in.write(bt, 0, bt.length);
        in.close();
    }
}
