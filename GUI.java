import java.io.IOException;
import java.util.Scanner;

//package PACKAGE_NAME;

public class GUI {
    static SchoolClass schoolClass;
    static Scanner input;
    public static void main(String [] args) throws IOException{
        /*SchoolClass schoolClass=new SchoolClass("Intro to modern physics", "Physics", "Duncan", "CarlSmith");
        Students student = new Students("Mingcan", "Li");
        student.attendance.add(true);
        student.attendance.add(false);
        student.attendance.add(true);
        student.attendance.add(true);
        schoolClass.addStudent(student);
        IO io=new IO(schoolClass.getClassName(), schoolClass);
        io.writeToFile();*/
        // SchoolClass schoolClass = new SchoolClass();
        input = new Scanner(System.in);
        System.out.println("Welcome to student attendance program");

        // Prints out available classes number 1 - n

        System.out.println("Enter a class you would like to go into or press '+' for creating a new class");
        String option = input.nextLine();

        if(option.equals("+")){
            System.out.println("Enter class name: ");
            String className = input.nextLine();
            System.out.println("Enter subject name: ");
            String subject = input.nextLine();
            System.out.println("Enter teacher's first name: ");
            String teacherFirstName = input.nextLine();
            System.out.println("Enter teacher's last name: ");
            String teacherLastName = input.nextLine();
            SchoolClass newClass = new SchoolClass(className, subject, teacherFirstName, teacherLastName);
            newClass.addDate();
            IO io=new IO(className, newClass);
            io.writeToFile();
            //startAttendance(className);
        } else {
            startAttendance(option);
        }
        new IO(schoolClass.getClassName(),schoolClass).writeToFile();
    }

    public static void startAttendance(String className) throws IOException{
        schoolClass = new SchoolClass();
        IO io=new IO(className, schoolClass);
        io.readFromFile();
        for(int i = 0 ; i < schoolClass.students.size();i++){
           schoolClass.students.get(i).attendance.add(false);
        }
        schoolClass.addDate();
        String id="null";
        System.out.println("Class Name: "+ schoolClass.getClassName());
        System.out.println(schoolClass.getTeacherFirstName() + schoolClass.getTeacherLastName());
        while(!id.equals("x")){
            System.out.println("input Student id (x to exit)");
            id=input.nextLine();
            int indx=-1;
            for(int i = 0 ; i < schoolClass.students.size() ; i++){
                if(schoolClass.students.get(i).getID().equals(id)){
                    indx=i;
                    break;
                }
            }
            if(!id.equals("x")){
                if(indx==-1)
                    System.out.println("Does not exist");
                else
                    schoolClass.students.get(indx).attendance.set(
                                schoolClass.students.get(indx).attendance.size(), true);
            }
        }
    }
}
