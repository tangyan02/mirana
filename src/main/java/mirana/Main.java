package mirana;

import com.fasterxml.jackson.databind.ObjectMapper;
import mirana.util.base.Global;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String config = "";
        for (String arg : args) {
            config += arg;
        }
        Map<String, Object> configs = objectMapper.readValue(config, Map.class);

//        FileUtil.deleteFiles(new File(Config.mdOutputPath));
//
//        for (String path : Config.entityPath) {
//            executeJavaDoc(EntityHandle.class, path);
//        }
//
//        for (String path : Config.enumerationPath) {
//            executeJavaDoc(EnumerationHandle.class, path);
//        }
//
//        for (String path : Config.interfacePath) {
//            executeJavaDoc(InterfaceHandle.class, path);
//        }

    }

    private static void executeJavaDoc(Class handle, String javaFilePath) {
        String[] docArgs = new String[]{"-doclet", handle.getName(), "-docletpath", Config.classPath, javaFilePath};
        Global.filePath = javaFilePath;
        com.sun.tools.javadoc.Main.execute(docArgs);
    }
}
