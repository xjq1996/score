package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import entity.Student;
import ui.jwindow;

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
           /**
            *回写操作
            * @param list
            */
           public void write(List<Student> list)
           {
        	   File f=new File(jwindow.jfc.getSelectedFile().getAbsolutePath());
        	   try {
				FileOutputStream out=new FileOutputStream(f);
				   OutputStreamWriter write=new OutputStreamWriter(out, "GBK");
				   BufferedWriter w=new BufferedWriter(write);
				   for(int i=0;i<list.size();i++)
				   {
					   Student stu=list.get(i);
					   w.write(stu.getName()+"\r\n");
					   w.write(stu.getId()+"\r\n");
					   w.write(stu.getScore_name()+"\r\n");
					   w.write(stu.getScore()+"\r\n");
				   }
				   w.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }
}
