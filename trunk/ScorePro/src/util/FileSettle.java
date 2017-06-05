package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class FileSettle {
           private static FileSettle fileSettle=new FileSettle();
           private FileSettle(){}
           public static  FileSettle getInstance()
           {
        		   return  fileSettle;
           }
           public Reader getreader(File f)
           {
        	   try {
				FileInputStream fread=new FileInputStream(f);
				InputStreamReader rd=new InputStreamReader(fread,"GBK");
				BufferedReader read=new BufferedReader(rd);
				return read;
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				return null;
			}
           }
           public BufferedWriter getwriter(File f,boolean flag)
           {
        	   try {
				FileOutputStream fwrite=new FileOutputStream(f, flag);
				OutputStreamWriter ow=new OutputStreamWriter(fwrite, "GBK");
				BufferedWriter write=new BufferedWriter(ow);
				return write;
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				return null;
			}
           }
}
