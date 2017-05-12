package util.extend;

import util.base.FileUtil;

import java.io.IOException;

public class MdFileUtil {
    static public void writeEntity(String content) {
        try {
            FileUtil.write(MdFileUtil.class.getResource("/").getFile() + "../mdFiles/", "Entity.md", content);
        } catch (IOException e) {
            throw new RuntimeException("Entity写入失败");
        }
        System.out.println("实体Md写入成功");
    }

    static public void writeInterface(String content, String serviceName) {
        try {
            FileUtil.write(MdFileUtil.class.getResource("/").getFile() + "../mdFiles/interface/", serviceName + ".md", content);
        } catch (IOException e) {
            throw new RuntimeException("Interface写入失败");
        }
        System.out.println(serviceName + "写入成功");
    }

    static public void writeEnumeration(String content) {
        try {
            FileUtil.write(MdFileUtil.class.getResource("/").getFile() + "../mdFiles/", "Enumeration.md", content);
        } catch (IOException e) {
            throw new RuntimeException("Enumeration写入失败");
        }
        System.out.println("枚举Md写入成功");
    }
}
