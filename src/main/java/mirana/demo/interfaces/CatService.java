package mirana.demo.interfaces;

import mirana.demo.entity.Cat;
import mirana.demo.enumeration.Color;

import java.util.List;

public interface CatService {

    /**
     * 获取猫咪的颜色
     *
     * @param cats 猫咪列表
     * @return
     */
    List<Color> getCatColor(List<Cat> cats);

}
