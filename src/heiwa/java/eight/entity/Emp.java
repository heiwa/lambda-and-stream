package heiwa.java.eight.entity;

import java.util.Random;

/**
 * 社員クラス。
 * 年収だけ持ってる。
 */
public class Emp {
    private Integer income;

    public Emp() {
        income = Integer.valueOf((int)(new Random().nextGaussian()*100+800));
    }

    public Integer getIncome() {
        return income;
    }
}
