import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class IO {
    private FileReadnWriter dataBase;
    private SchoolClass schoolClass;

    public IO(String className, SchoolClass schoolClass) throws IOException{
        this.schoolClass=schoolClass;
        this.dataBase=new FileReadnWriter(className+".json"); 
    }

    public void writeToFile() throws IOException{
        dataBase.addData("className", schoolClass.getClassName());
        dataBase.addData("subject", schoolClass.getSubject());
        dataBase.addData("teacherFirstName", schoolClass.getTeacherFirstName());
        dataBase.addData("teacherLastName", schoolClass.getTeacherLastName());
        dataBase.addData("Classdates", schoolClass.classDates);
        JSONObject students = new JSONObject();
        for(int i = 0 ; i < schoolClass.students.size(); i++){
            JSONObject studentInfo = new JSONObject();
            studentInfo.put("FirstName", schoolClass.students.get(i).getFirstName());
            studentInfo.put("LastName", schoolClass.students.get(i).getLastName());
            studentInfo.put("Gender", schoolClass.students.get(i).getGender());
            studentInfo.put("id", schoolClass.students.get(i).getID());
            JSONArray attendance = new JSONArray();
            for(int j = 0 ; j < schoolClass.students.get(i).attendance.size(); j++){
                attendance.add(schoolClass.students.get(i).attendance.get(j));
            }
            studentInfo.put("Attendance", attendance);
            students.put(i,studentInfo);
        }
        dataBase.addData("Students", students);
        
        dataBase.write();
    }

    public void readFromFile(){
        JSONObject rawData;
        try{
            rawData = dataBase.getJSONObject();
        }catch(Exception e){
            e.getMessage();
            return;
        }
        schoolClass.setClassName((String) rawData.get("className"));
        schoolClass.setSubject((String) rawData.get("subject"));
        schoolClass.setTeacherFirstName((String) rawData.get("teacherFirstName"));
        schoolClass.setTeacherLastName((String) rawData.get("teacherLastName"));
        JSONObject StudentsData=(JSONObject) rawData.get("Students");
        schoolClass.classDates=(ArrayList<String>) rawData.get("Classdates");
        try{
            for(int i = 0;;i++){
                JSONObject indivStudent = (JSONObject) StudentsData.get(Integer.toString(i));
                String firstName = (String) indivStudent.get("FirstName");
                String lastName = (String) indivStudent.get("LastName");
                String id = (String) indivStudent.get("id");
                Students student=new Students(firstName, lastName, id);
                student.setGender((String) indivStudent.get("Gender"));
                JSONArray attendance = (JSONArray) indivStudent.get("Attendance");
                for(int j = 0 ; j < attendance.size() ; j++){
                    student.attendance.add((boolean)attendance.get(j));
                }
                schoolClass.addStudent(student);
            }
        }catch(Exception e){
            e.getMessage();
            return;
        }
    }
}
