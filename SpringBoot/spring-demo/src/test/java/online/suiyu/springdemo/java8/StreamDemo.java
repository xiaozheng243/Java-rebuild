package online.suiyu.springdemo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Tom", "man", 60.5D, "first grade"),
                new Student("Lisa", "woman", 80.3D, "second grade"),
                new Student("Jack", "man", 99.0D, "first grade"),
                new Student("Yuluo", "man", 55.0D, "second grade"),
                new Student("Tony", "man", 90.0D, "first grade"),
                new Student("Hasaki", "man", 100D, "first grade")
        );
        // TODO 获取一班所有学生的成绩列表
        Stream<Double> firstGradeScoreStream = students.stream()
                .filter(s -> s.getGrade().equals("first grade"))
                .map(Student::getScore)
                .sorted()
                .limit(2);
        List<Double> firstGradeScore = firstGradeScoreStream.collect(Collectors.toList());
        firstGradeScore.forEach(System.out::println);
//        Long count = firstGradeScoreStream.count();
        firstGradeScore.forEach(System.out::println);
        // TODO 获取每个学生的名字长度
        students.stream().map(e -> e.getName())
                .map(String::length).forEach(System.out::println);
        if (students.stream().map(Student::getScore).anyMatch(e -> e > 90D)) {
            System.out.println("存在大于90分的同学");
        }
        if (students.stream().map(Student::getScore).noneMatch(e -> e < 90D)) {
            System.out.println("不存在小于90分的同学");
        }
        if (students.stream().map(Student::getScore).allMatch(e -> e > 20D)) {
            System.out.println("所有学生的分数都大于20");
        }
    }
}

class Student {
    private String name;
    private String sex;
    private Double score;
    private String grade;

    public Student() {
    }

    public Student(String name, String sex, Double score, String grade) {
        this.name = name;
        this.sex = sex;
        this.score = score;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", score=" + score +
                ", grade='" + grade + '\'' +
                '}';
    }
}
