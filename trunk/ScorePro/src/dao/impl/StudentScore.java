package dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.StudentScoreDao;
import entity.Student;
import ui.jwindow;
import util.FileSettle;

public class StudentScore implements StudentScoreDao{

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		FileSettle fs=FileSettle.getInstance();
		File f=new File(jwindow.jfc.getSelectedFile().getAbsolutePath());
		List<Student> students=new ArrayList<Student>();
		if(f.exists())
		{
			String s;
			BufferedReader reader=(BufferedReader) fs.getreader(f);
			try {
				while((s=reader.readLine())!=null)
				{   
					 Student student=new Student();
					 student.setName(s);
					 student.setId(reader.readLine());
					 student.setScore_name(reader.readLine());
					 student.setScore(reader.readLine());
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
	public Set<Student> OrderByscore(List<Student> students) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByscore(double score1, double score2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(String Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File InsertData(String dir) {
		// TODO Auto-generated method stub
		return null;
	}

}
