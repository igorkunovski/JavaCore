package gb.lesson5.part1;

import java.io.*;

public class Backup {

    private static final String backupDirectory = "src/gb/lesson5/part1/backup";
    private static final String sourceDirectory = "src/gb/lesson5/part1";


    public static void main(String[] args) {

        createBackup();
    }

    private static void createBackup() {

        File sourceDir = new File(Backup.sourceDirectory);
        File backDir = new File(Backup.backupDirectory);

        if (!sourceDir.isDirectory()) throw new IllegalArgumentException("Source is not a directory");
        if (!backDir.exists()) backDir.mkdirs();

        File [] files = sourceDir.listFiles();
        if (files != null){
            for (File file: files) {
                if (file.isFile()){
                    File backupFile = new File(backDir + "/" + file.getName());
                    copyFile(file, backupFile);
                }
            }
        }
    }

    private static void copyFile(File source, File backup) {
       try( BufferedReader fr = new BufferedReader(new FileReader(source));
            BufferedWriter fw = new BufferedWriter(new FileWriter(backup))) {

           int ch;

           while ((ch=fr.read()) !=-1){
               fw.write(ch);
           }

           System.out.println("BackUp of " + sourceDirectory + " successfully generated  at directory: " + backupDirectory);
       } catch (FileNotFoundException e) {
           System.out.println("File not found!");
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
