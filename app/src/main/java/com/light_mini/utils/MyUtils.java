package com.light_mini.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class MyUtils {
    private  static String path;
    static {
        path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/log";
        new File(path).mkdirs();

    }
    public static boolean log2file(String log) throws IOException {
        File file=new File(path+"/log.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter fw=new FileWriter(file,true);
        fw.write(log+"\n");
        fw.flush();
        fw.close();
        return true;
    }
    public static String Stream2Striing(InputStream in) throws IOException {
        byte [] bs=new byte[1024];
        int len=-1;
        StringBuffer sb=new StringBuffer();
        while ((len=in.read(bs))!=-1){
            sb.append(sb,0,len);
        }
        return sb.toString();
    }
}
