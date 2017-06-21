package dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

import dao.StudentScoreDao;
import entity.Student;
import ui.jwindow;
import util.FileSettle;

public class StudentScore implements StudentScoreDao{

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		FileSettle fs=FileSettle.getInstance();
		File f;
			f = new File(jwindow.jfc.getSelectedFile().getAbsolutePath());
		List<Student> students=new ArrayList<Student>();
		if(f.exists()&&jwindow.jfc.getSelectedFile().getAbsolutePath()!=null)
		{
			String s;
			BufferedReader reader=(BufferedReader) fs.getreader(f);
			try {
				while((s=reader.readLine())!=null)
				{   
					 Student student=new Student();
					 student.setName(s.replaceAll("\\s",""));
					 student.setId(reader.readLine().replaceAll("\\s",""));
					 student.setScore_name(reader.readLine().replaceAll("\\s",""));
					 String ch=reader.readLine();
					 ch=ch.replaceAll("\\s","");
					 student.setScore(Integer.parseInt(ch.substring(0, ch.length())));
					 students.add(student);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}

	@Override
	public List<Student> OrderByscore(List<Student> students,String pk,String rule) {
		// TODO Auto-generated method stub
		if(pk.equals("按成绩排序")&&rule.equals("升序排序"))
	    {
			students.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getScore()-o2.getScore();
			}
		});
	    }
		if(pk.equals("按成绩排序")&&rule.equals("降序排序"))
	    {
			students.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.getScore()-o1.getScore();
			}
		});
	    }
		if(pk.equals("按学号排序")&&rule.equals("降序排序"))
	    {
			students.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				String s1=o1.getId().replaceAll("\\s","");
				String s2=o2.getId().replaceAll("\\s","");
				return Integer.parseInt(s2)-Integer.parseInt(s1);
			}
		});
	    }
		if(pk.equals("按学号排序")&&rule.equals("升序排序"))
	    {
			students.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				String s1=o1.getId().replaceAll("\\s","");
				String s2=o2.getId().replaceAll("\\s","");
				return Integer.parseInt(s1)-Integer.parseInt(s2);
			}
		});
	    }
	    return students;
	}

	@Override
	public Student findById(String Id) {
		// TODO Auto-generated method stub
		List<Student> students=findAllStudents();
		Student student=null;
		for(Student s:students)
		{
			String ch=s.getId();
			ch=ch.replaceAll("\\s","");
			Id=Id.replaceAll("\\s","");
			if(ch.equals(Id))
			{
				student=new Student();
				student=s;
				break;
			}
		}
		students.clear();
		return student;
	}

	@Override
	public List<Student> findByscore(int score1,int score2) {
		// TODO Auto-generated method stub
		List<Student> students=findAllStudents();
		List<Student> datas=new ArrayList<Student>();
		for(Student s:students)
		{
			if(s.getScore()>=score1 && s.getScore()<score2){
				datas.add(s);
			}
		}
		students.clear();
		return datas;
	}

	@Override
	public void updateStudent(Student stu) {
		// TODO Auto-generated method stub
		ArrayList<Student> stus=new ArrayList<Student>();
		stus=(ArrayList<Student>) findAllStudents();
		for(int i=0;i<stus.size();i++)
		{
			if(stus.get(i).getId().equals(stu.getId().replaceAll("\\s",""))){
				stus.get(i).setScore(stu.getScore());
				stus.get(i).setScore_name(stu.getScore_name());
				break;
			}
		}
		FileSettle.getInstance().write(stus);
		JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.YES_NO_CANCEL_OPTION);
	}

	@Override
	public void InsertData(String dir,Student stu) {
		// TODO Auto-generated method stub
		 File f=new File(dir);
		 if(f.exists())
		 {
			 try {
				FileOutputStream output=new FileOutputStream(f,true);
				OutputStreamWriter write=new OutputStreamWriter(output, "GBK");
				BufferedWriter out=new BufferedWriter(write);
				out.write(stu.getName()+"\r\n");
				out.write(stu.getId()+"\r\n");
				out.write(stu.getScore_name()+"\r\n");
				out.write(stu.getScore()+"\r\n");
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	}

	@Override
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		ArrayList<Student> stus=new ArrayList<Student>();
		stus=(ArrayList<Student>) findAllStudents();
		for(int i=0;i<stus.size();i++)
		{
			id=id.replaceAll("\\s","");
			if(stus.get(i).getId().equals(id)){
				stus.remove(i);
				break;
			}
		}
		FileSettle.getInstance().write(stus);
	}

}
