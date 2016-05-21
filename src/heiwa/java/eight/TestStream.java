package heiwa.java.eight;

import heiwa.java.eight.entity.Emp;
import heiwa.java.eight.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ストリームAPIを使ってみるクラス。
 */
public class TestStream {
    private List<Student> students;

    public TestStream() {
        students = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student());
        }
    }

    public void printStudentNameExItr() {
        for(Student student : students) {
            String name = student.getName();
            System.out.println(name);
        }
    }
    public void printStudentNameLambda() {
        students.stream()
                .map(s -> s.getName())
                .forEach(n -> System.out.println(n));
    }
    public void printStudentNameRefMethod() {
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }

    public List<Emp> findHighIncomeLambda(List<Emp> emps) {
        return emps.stream()
                .filter(emp -> emp.getIncome() >= 800)
                .collect(Collectors.toList());
    }


    public List<Emp> findOfHighIncomeExItr(List<Emp> emps) {
        List<Emp> highIncomeEmps = new ArrayList<Emp>();
        for(Emp emp : emps) {
            if(emp.getIncome() >= 800) {
                highIncomeEmps.add(emp);
            }
        }
        return highIncomeEmps;
    }


}
