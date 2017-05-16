package mirana.util.extend;

import mirana.Config;
import mirana.util.base.FileUtil;

import java.io.IOException;

public class MdFileUtil {
    static public void writeEntity(String content) {
        try {
            FileUtil.write(Config.mdOutputPath, "Entity.md", content);
        } catch (IOException e) {
            throw new RuntimeException("Entity写入失败");
        }
        System.out.println("实体Md写入成功");
    }

    static public void writeInterface(String content, String serviceName) {
        try {
            FileUtil.write(Config.mdOutputPath + "/interface/", serviceName + ".md", content);
        } catch (IOException e) {
            throw new RuntimeException("Interface写入失败");
        }
        System.out.println(serviceName + "写入成功");
    }

    static public void writeEnumeration(String content) {
        try {
            FileUtil.write(Config.mdOutputPath, "Enumeration.md", content);
        } catch (IOException e) {
            throw new RuntimeException("Enumeration写入失败");
        }
        System.out.println("枚举Md写入成功");
    }
}
