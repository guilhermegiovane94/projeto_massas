package functions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class FileHandler {

    public static void createFile(){
        String filePath = getFilePath();
        String fileName = getFileName();

        try {
            File myObj = new File(String.format("%s%s",filePath,fileName));
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void writeFile(List<String> data){
        try
        {
            String filename= String.format("%s%s",getFilePath(),getFileName());
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            for(String line : data){
                fw.write(line);//appends the string to the file
                fw.write("\n");//appends the string to the file
            }
            fw.write("\n");//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static String getFilePath(){
        return "C:/Users/guilherme.oliveira/OneDrive - Link/massas/";
    }

    public static String getSystemDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HH");
        return formatter.format(date);
    }
    public static String getFileName(){
        return String.format("%s.txt",getSystemDate());
    }
}
