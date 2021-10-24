import java.util.*;
import java.util.ArrayList;

public class SchoolClass {
    private String className;
    private String subject;
    private String teacherFirstName;
    private String teacherLastName;
    public ArrayList<Students> students;
    public ArrayList<String> classDates;

    public SchoolClass(){
        students=new ArrayList<>();
        classDates=new ArrayList<>();
    }
    public SchoolClass(String className, String subject, String teacherFirstName, String teacherLastName) {
        students = new ArrayList<Students>();
        this.className = className;
        this.subject = subject;
        this.teacherFirstName = teacherFirstName;;
        this.teacherLastName = teacherLastName;
        this.classDates = new ArrayList<>();
    }

    public void addStudent(Students student) {
        students.add(student);
    }

    public void setClassName(String className) {
        this.className = className;
    }

    // class name
    public String getClassName() {
        return className;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String firstName){
        this.teacherFirstName = firstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String lastName){
        this.teacherLastName = lastName;
    }

    public void addDate(){
        classDates.add(new Date().toString());
    }

    
}