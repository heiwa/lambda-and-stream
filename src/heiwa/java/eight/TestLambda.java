package heiwa.java.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * ラムダ式での記述いろいろ
 */
public class TestLambda {
    private List<String> strings;

    public TestLambda() {
        strings = new ArrayList<String>();
        for (int i = 1; i < 10; i++) {
            strings.add("string" + i);
        }
    }

    public void printExItr() {
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public void printInItr() {
        strings.forEach(
                new Consumer<String>() {
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });
    }

    public void printLambda() {
        strings.forEach(
                (String s) -> {
                    System.out.println(s);
                });
    }

    public void printLambda2() {
        strings.forEach(
                (s) -> {
                    System.out.println(s);
                });
    }

    public void printLambda3() {
        strings.forEach(
                s -> {
                    System.out.println(s);
                });
    }

    public void printLambda4() {
        strings.forEach(s -> System.out.println(s));
    }

    public void printLambda5() {
        strings.forEach(System.out::println);
    }
}
