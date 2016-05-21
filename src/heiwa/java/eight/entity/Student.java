package heiwa.java.eight.entity;

import java.util.Random;

/**
 * 学生クラス。
 * 名前だけ持ってる。
 */
public class Student {
    static final String[] NAME_LIST = {"James","John","Robert","Michael","William",
            "David","Richard","Charles","Joseph","Thomas","Mary","Patricia","Linda",
            "Barbara","Elizabeth","Jennipher","Maria","Margaret","Dorothy","Lisa"};
    private String name;

    public Student() {
        name = NAME_LIST[new Random().nextInt(NAME_LIST.length)];
    }

    public String getName() {
        return name;
    }
}
