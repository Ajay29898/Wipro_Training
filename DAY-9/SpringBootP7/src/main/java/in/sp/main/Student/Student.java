package in.sp.main.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private Integer id;
    private String name;
    private String major;
    private Integer age;

    public Student(Integer id, String name, String major, Integer age) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", major=" + major + ", age=" + age + "]";
    }
}

