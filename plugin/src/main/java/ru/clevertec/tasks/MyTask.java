package ru.clevertec.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyTask extends DefaultTask {
    @TaskAction
    void download(){
        try {
            String strURL = "https://github.com/stebadmitriy/files/raw/main/Clevertec_Template.pdf";
            String strPath = "src/main/resources/templates/Clevertec_Template.pdf";
            int buffSize = 100000000;
            URL connection = new URL(strURL);
            HttpURLConnection urlconn;
            urlconn = (HttpURLConnection) connection.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.connect();
            InputStream in = null;
            in = urlconn.getInputStream();
            OutputStream writer = new FileOutputStream(strPath);
            byte buffer[] = new byte[buffSize];
            int c = in.read(buffer);
            while (c > 0) {
                writer.write(buffer, 0, c);
                c = in.read(buffer);
            }
            writer.flush();
            writer.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}