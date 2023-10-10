package org.exa.logs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Loger implements LogerImpl{
    private static final String LOG_PATH = "src/main/java/org/exa/logs/log.txt";
    File loger;
    public Loger(){
        loger = new File(LOG_PATH);
        try {
            loger.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loadLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(loger);){
            int a;
            while ((a = reader.read()) != -1){
                stringBuilder.append((char) a);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveLog(String text) {
        try (FileWriter writer = new FileWriter(loger, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        };
    }
}
