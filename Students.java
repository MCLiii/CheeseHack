import java.util.ArrayList;

public class Students {
    private String firstName; // first name of student
    private String lastName; // last name of student
    private String studentID; // id of Student
    private static int nextUniqueID;
    private String gender; // gender of student
    public ArrayList<Boolean> attendance;

    private byte[] studentProfile; // Profile picture for students
    protected static int studentClassCount; // Total number of students in the class

    public Students(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        studentClassCount++;
        studentID = id;
        attendance=new ArrayList<>();
    }

    // Generate Student ID
    public void genStudent() {
        this.studentID = Integer.toString(nextUniqueID);
        nextUniqueID++;
    }

    // Student's first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Student's last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    // Student's ID
    public String getID() {
        return studentID;
    }

    public void setID(String studentID) {
        this.studentID = studentID;
    }

    // Student's gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Student's profile picture
    public byte[] getProfile() {
        return studentProfile;
    }

    public void setProfile(byte[] studentProfile) {
        this.studentProfile = studentProfile;
    }

}