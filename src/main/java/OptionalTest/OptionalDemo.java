package OptionalTest;

import java.util.Date;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String string = null;
        String str = Optional.ofNullable(string).orElse("default");
        System.out.println(str);
        Student stu = new Student("ayang", 1123);
        Optional<Student> ayang818 = Optional.ofNullable(stu);
        String hello = ayang818.map(student -> student.getName()).orElse("hello");
        System.out.println(hello);
        Student stu1 = null;
        Optional<Student> stu11 = Optional.ofNullable(stu1);
        System.out.println(stu11.isPresent());
    }
}

class Student {
    private String name;
    private Integer number;

    public Student(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
