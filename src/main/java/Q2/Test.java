package Q2;

import java.io.*;

public class Test {
    public static void main(String[] args) throws NeedFiveArguments {
        if(args.length != 5){
            throw new NeedFiveArguments("The argument should be 5");
        }
        String url = "/Users/oliverzheng/Desktop/IdeaProjects/Project2/src/main/java/Q2/NumberFile.txt";
        File file = new File(url);
        //if file exist append to the end
        if(file.exists()){
            try {
                FileWriter fw = new FileWriter(file, true);
                for(String arg : args){
                    fw.write(arg + "\n");
                }
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
         //else if the file doesn't exist create a file and write
        }else{
            try{
                FileOutputStream fos = new FileOutputStream(file);
                for(int i = 0; i < 5; i++){
                    byte[] byteContent = args[i].getBytes();
                    fos.write(byteContent);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //read the file
        try{
            FileInputStream fis = new FileInputStream(file);
            int data;
            while((data = fis.read()) != -1){
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
