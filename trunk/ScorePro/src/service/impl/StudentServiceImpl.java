package service.impl;

import java.io.File;
import java.util.List;
import java.util.Set;

import dao.StudentScoreDao;
import dao.impl.StudentScore;
import entity.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public void ServiceInsertData(String dir,Student stu) {
		StudentScoreDao studentdao=new StudentScore();
		studentdao.InsertData(dir,stu);
	}

	@Override
	public List<Student> ServicefindAllStudents() {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.findAllStudents();
	}

	@Override
	public List<Student> ServiceOrderByscore(List<Student> students,String pk,String rule) {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.OrderByscore(students,pk,rule);
	}

	@Override
	public Student ServiceindById(String Id) {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.findById(Id);
	}

	@Override
	public List<Student> ServicefindByscore(int score1,int score2) {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.findByscore(score1, score2);
	}

	@Override
	public void ServiceupdateStudent(Student stu) {
		StudentScoreDao studentdao=new StudentScore();
		studentdao.updateStudent(stu);
		
	}

	@Override
	public void Servicedelete(String id) {
		// TODO Auto-generated method stub
		StudentScoreDao studentdao=new StudentScore();
		studentdao.deleteStudent(id);
	}

	

}
