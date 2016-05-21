package heiwa.java.eight;

import heiwa.java.eight.entity.Emp;

import java.util.ArrayList;
import java.util.List;

/**
 * 動作確認用メインクラス。
 */
public class Main {

    public static void main(String[] args) {
//	    TestLambda writer = new TestLambda();
//        writer.printLambda5();
        TestStream testStream = new TestStream();
        testStream.printStudentNameRefMethod();
        List<Emp> emps = new ArrayList<Emp>();
        for (int i = 0; i < 30; i++) {
            emps.add(new Emp());
        }
        testStream.findHighIncomeLambda(emps).stream()
                .forEach(e -> System.out.println(e.getIncome()));
    }
}
