package Classes;
import com.opencsv.*;
import java.io.*;


public class Spreadsheet {
    String filePath;
    CSVWriter file;
    public Spreadsheet(){
        this.filePath = "C:\\Users\\hp\\Desktop\\OOP LAB PROJECT\\Records"; }
    // writing csv file function
    public void writingCSVFile(String name ,String age , String gender ,  String weight , String height , String BMI){
        try {
            file = new CSVWriter(new FileWriter(filePath  , true));
            String[] data =  {name , age , gender ,weight ,height , BMI };
            file.writeNext(data);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
