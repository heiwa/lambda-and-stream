package heiwa.java.eight.entity;

import java.util.Random;

/**
 * 人クラス。
 * 苗字と名前を持ってる。
 */
public class Person {
    static final String[] FIRST_NAME_LIST = {"James","John","Robert","Michael","William",
            "David","Richard","Charles","Joseph","Thomas","Mary","Patricia","Linda",
            "Barbara","Elizabeth","Jennipher","Maria","Margaret","Dorothy","Lisa"};
    static final String[] FAMILY_NAME_LIST = {"Smith","Johnson","William","Jones",
            "Brown","Davis","Miller","Willson","Moore","Taylor"};

    private String firstName;
    private String familyName;

    public Person() {
        Random rand = new Random();
        firstName = FIRST_NAME_LIST[rand.nextInt(FIRST_NAME_LIST.length)];
        familyName = FAMILY_NAME_LIST[rand.nextInt(FAMILY_NAME_LIST.length)];
    }

    /**
     * Stream.iterate用に作ったコンストラクタ。
     * デフォルトコンストラクタと同じ。引数は使用しない。
     *
     * @param p 使用しない引数
     */
    public Person(Person p) {
        this();
    }

    public String getFirstName() {
        return firstName;
    }
    public String getFamilyName() {
        return familyName;
    }
}
