package util.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static void write(String path, String name, String text) throws IOException {
        System.out.println(path + " " + name);
        File file = new File(path, name);
        if (!file.exists()) {
            createPath(file.getParentFile());
            file.createNewFile();
        }

        byte bt[];
        bt = text.getBytes();
        FileOutputStream in = new FileOutputStream(file, true);
        in.write(bt);
        in.close();
    }

    private static void createPath(File file) {
        if (file.getParentFile() == null) {
            return;
        }
        if (!file.getParentFile().exists()) {
            createPath(file.getParentFile());
        }
        file.mkdir();
    }
}
