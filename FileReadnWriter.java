import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.jar.Attributes.Name;

public class FileReadnWriter {
    public static void main(String[] args) throws IOException, ParseException {
        FileReadnWriter a=new FileReadnWriter("x.json");
        JSONObject json=a.getJSONObject();
    }

    private String fileName;
    private JSONObject obj;
    JSONParser parser = new JSONParser();

    /**
     * String fileName The file name to read & write
     * @throws IOException
     */ 
    public FileReadnWriter(String fileName) throws IOException {
        this.fileName=fileName;
        obj = new JSONObject();
    }


    public JSONObject getJSONObject() throws IOException, ParseException {
        Reader reader = new FileReader(fileName);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        return jsonObject;
    }

    public void addData(String Field, Object data) {
        obj.put(Field, data);
    }

    public void write() throws IOException{
        FileWriter fileWrite=new FileWriter(fileName);
        fileWrite.write(obj.toJSONString());
        fileWrite.close();
    }
}