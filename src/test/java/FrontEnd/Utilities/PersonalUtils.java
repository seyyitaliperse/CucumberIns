package FrontEnd.Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PersonalUtils {

    public static int randomNum(int min,int max){
        Random random = new Random();
        return random.nextInt(max)+min;}

    public static void writeProductInfoToTxtFile(String productName, String productPrice){
        String url ="src/test/resources/JobDescription.txt";
        File file=new File(url);
        try {
            file.createNewFile();
            FileWriter myWriter = new FileWriter( file.getAbsolutePath());
            myWriter.write("Product Information: " + productName + "\nProduct Price: "+ productPrice);
            myWriter.close();
        } catch ( IOException e) {
            e.printStackTrace();}}

}
