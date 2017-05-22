package mirana.demo.interfaces;

import mirana.demo.enumeration.Color;

public interface DogService {

    /**
     * 获取狗狗名称(根据默认配置，该方法不会被生成到文档中)
     *
     * @param dogId 狗狗Id
     */
    void getName(int dogId);

    /**
     * 获取狗狗颜色
     *
     * @param dogId 狗狗Id
     */
    Color getColor(int dogId);
}
