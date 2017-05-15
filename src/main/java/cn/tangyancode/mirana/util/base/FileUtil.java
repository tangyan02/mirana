package cn.tangyancode.mirana.util.base;

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

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     * If a deletion fails, the method stops attempting to
     * delete and returns "false".
     */
    public static boolean deleteFiles(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteFiles(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
