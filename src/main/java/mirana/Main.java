package mirana;

import mirana.util.base.FileUtil;
import mirana.util.base.Global;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileUtil.deleteFiles(new File(Config.mdOutputPath));

        for (String path : Config.entityPath) {
            executeJavaDoc(EntityHandle.class, path);
        }

        for (String path : Config.enumerationPath) {
            executeJavaDoc(EnumerationHandle.class, path);
        }

        for (String path : Config.interfacePath) {
            executeJavaDoc(InterfaceHandle.class, path);
        }
    }

    private static void executeJavaDoc(Class handle, String javaFilePath) {
        String[] docArgs = new String[]{"-doclet", handle.getName(), "-docletpath", Config.classPath, javaFilePath};
        Global.filePath = javaFilePath;
        com.sun.tools.javadoc.Main.execute(docArgs);
    }
}
