import java.io.File;  
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter; 
import java.util.*;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
public class FileOperations{

    // create a file
    static void CreateFile(String fname)
    {
        try {    
            File f0 = new File(fname);   
            if (f0.createNewFile()) {  
                System.out.println("File " + f0.getName() + " is created successfully.");  
            } else {  
                System.out.println("File is already exist in the directory.");
                System.out.println("The absolute path of the file is: " + f0.getAbsolutePath()); 
            }  
        } catch (IOException exception) {  
            System.out.println("An unexpected error is occurred.");  
            exception.printStackTrace();  
        }
    }

    // write text to a file
    static void WriteToFile(String fname)
    {
        try {  
            FileWriter fwrite = new FileWriter(fname,true);   
            fwrite.write("Sample text written in file\n");   
            fwrite.close();   
            System.out.println("Content is successfully wrote to the file.");  
        } catch (IOException e) {  
            System.out.println("Unexpected error occurred");  
            e.printStackTrace();  
        }  
    }  

    // read lines from a file
    static void ReadFile(String fname)
    {
        try {   
            File f1 = new File(fname);  
            Scanner dataReader = new Scanner(f1);  
            while (dataReader.hasNextLine()) {  
                String fileData = dataReader.nextLine();  
                System.out.println(fileData);  
            }  
            dataReader.close();  
        } catch (FileNotFoundException exception) {  
            System.out.println("Unexcpected error occurred!");  
            exception.printStackTrace();  
        } 
    }

    // delete a file
    static void DeleteFile(String fname)
    {
        File f0 = new File(fname);   
        if (f0.delete()) {   
            System.out.println(f0.getName()+ " deleted successfully.");  
        } else {  
            System.out.println("Unexpected error found in deletion of the file.");  
        } 
    }

    // update a line in a file
    static void UpdateLineInFile(String fname, int lineNo, String updateText) throws IOException
    {
        try{
        
            try {
                Path path = FileSystems.getDefault().getPath( fname);
                List<String> lines = Files.readAllLines(path,StandardCharsets.UTF_8);
                lines.set(lineNo, updateText);    
                StringBuilder str=new StringBuilder();

                for(String i:lines)
                {
                    str.append(i+"\n");
                }
                System.out.println(str);
          
                try {  
                    FileWriter fwrite = new FileWriter(fname);   
                    fwrite.write(String.valueOf(str));   
                    fwrite.close();   
                    System.out.println("Content is successfully wrote to the file.");  
                } catch (IOException e) {  
                    System.out.println("Unexpected error occurred");  
                    e.printStackTrace();  
                }  

            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Unexpected error occurred");
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a file name: ");
        String fname = sc.nextLine();
        CreateFile(fname);
        WriteToFile(fname);
        WriteToFile(fname);
        WriteToFile(fname);
        ReadFile(fname);
        try {
            UpdateLineInFile(fname, 1, "tstasdasds");
        } catch (Exception e) {
            System.out.println("Unexpected error occurred");
        }
        sc.close();
    }
    
}
