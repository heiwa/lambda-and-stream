package heiwa.java.eight;

import heiwa.java.eight.entity.Emp;
import heiwa.java.eight.entity.Person;
import heiwa.java.eight.util.Bench;
import heiwa.java.eight.util.FiboStream;
import heiwa.java.eight.util.Timer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 動作確認用メインクラス。
 */
public class Main {

    public static void main(String[] args) {
        Bench<Integer> bench = new Bench<Integer>();
        RandomInt sut = new RandomInt();
        System.out.println("sequential int : " + bench.bench(sut::sumFuncInt));
        System.out.println("sequential Integer : " + bench.bench(sut::sumFuncInteger));
        System.out.println("parallel int : " + bench.bench(sut::sumFuncParallelInt));
        System.out.println("parallel Integer : " + bench.bench(sut::sumFuncParallelInteger));


//        useFibo();

//	    TestLambda writer = new TestLambda();
//        writer.printLambda5();

//        TestStream testStream = new TestStream();
//        testStream.printStudentNameRefMethod();
//        List<Emp> emps = new ArrayList<Emp>();
//        for (int i = 0; i < 30; i++) {
//            emps.add(new Emp());
//        }
//        testStream.findHighIncomeLambda(emps).stream()
//                .forEach(e -> System.out.println(e.getIncome()));

    }
    private static void useFibo() {
        //BigInteger[] fibo = FiboStream.fiboNotStream(500000);
        Timer.start();
        long count = FiboStream.fibo()
                .limit(500000)
                .count();
        long time = Timer.stop();
        System.out.println("time = " + time);

    }

    private static void countSameName() {
        // ConcurrentHashMapにしなくてもええの？
        // 並列化の良さが出てないのでいまいち。
        // きっと (Map, Map) -> Map の集約のコストが大きいのと、
        // そもそもの計算量が並列化するほど大きくないと思われる。
        long limit = 1000000;
        Stream<Person> stream = Stream.iterate(new Person(), Person::new);
        stream.parallel();
        System.out.println("parallel ? " + stream.isParallel());
        Timer.start();
        Map<String, Integer> counter = stream
                .limit(limit)
                .map(p -> p.getFirstName() + " " + p.getFamilyName())
                .collect(HashMap<String, Integer>::new,
                        (m, n) -> m.put(n, m.getOrDefault(n, 0) + 1),
                        (m1, m2) -> {
                            m2.forEach((k, v) -> m1.put(k, m1.getOrDefault(k, 0) + v));
                        });
        long time = Timer.stop();
        final List<Integer> sumList = new ArrayList<>();
        counter.forEach((k, v) -> {System.out.println(k + " : " + v);
            sumList.add(v);});
        System.out.println("sum = " + sumList.stream().reduce((v1, v2) -> v1 + v2));
        System.out.println("time = " + time);
    }

    public static class RandomInt {
        List<Integer> list = new ArrayList<>();
        public RandomInt() {
            list = IntStream.range(0, 100_000).boxed().collect(Collectors.toList());
        }
        public Integer sumFuncInt() {
            return list.stream().mapToInt(i -> i).sum();
        }
        public Integer sumFuncParallelInt() {
            return list.parallelStream().mapToInt(i -> i).sum();
        }
        public Integer sumFuncInteger() {
            return list.stream().reduce((i, j) -> i + j).orElse(0);
        }
        public Integer sumFuncParallelInteger() {
            return list.parallelStream().reduce((i, j) -> i + j).orElse(0);
        }
    }
}
