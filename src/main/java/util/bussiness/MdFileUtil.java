package util.bussiness;

import util.base.FileUtil;

import java.io.IOException;

public class MdFileUtil {
    static public void writeEntity(String content) {
        try {
            FileUtil.write(MdFileUtil.class.getResource("/").getFile(), "../mdFiles/entity.md", content);
        } catch (IOException e) {
            throw new RuntimeException("Entity写入失败");
        }
        System.out.println("实体Md写入成功");
    }

    static public void writeInterface(String content) {
        try {
            FileUtil.write(MdFileUtil.class.getResource("/").getFile(), "../mdFiles/interface.md", content);
        } catch (IOException e) {
            throw new RuntimeException("Interface写入失败");
        }
        System.out.println("接口Md写入成功");
    }

    static public void writeEnumeration(String content) {
        try {
            FileUtil.write(MdFileUtil.class.getResource("/").getFile(), "../mdFiles/enumeration.md", content);
        } catch (IOException e) {
            throw new RuntimeException("Enumeration写入失败");
        }
        System.out.println("枚举Md写入成功");
    }
}
