import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Test{
    public static void main(String args[]){
        try{
            FileInputStream fis = FileInputStream("ManageEmployee.java");
            int i;
            while((i = fis.read()) != -1){
                System.out.println((char)i);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}