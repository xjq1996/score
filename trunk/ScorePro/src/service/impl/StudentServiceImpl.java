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
	public File ServiceInsertData(String dir) {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.InsertData(dir);
	}

	@Override
	public List<Student> ServicefindAllStudents() {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.findAllStudents();
	}

	@Override
	public List<Student> ServiceOrderByscore(List<Student> students) {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.OrderByscore(students);
	}

	@Override
	public Student ServiceindById(String Id) {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.findById(Id);
	}

	@Override
	public List<Student> ServicefindByscore(double score1, double score2) {
		StudentScoreDao studentdao=new StudentScore();
		return studentdao.findByscore(score1, score2);
	}

	@Override
	public void ServiceupdateStudent(String Id) {
		StudentScoreDao studentdao=new StudentScore();
		studentdao.updateStudent(Id);
		
	}

	

}
