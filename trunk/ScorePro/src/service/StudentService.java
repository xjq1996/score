package service;

import java.io.File;
import java.util.List;
import java.util.Set;

import entity.Student;

public interface StudentService {
	   public void ServiceInsertData(String dir,Student stu);
	/**
	 * 该方法用于查找所有学生信息
	 * @return List<Student>为返回的一个结果集
	 */
       public List<Student> ServicefindAllStudents();
       /**
        * 该方法用于进行按成绩排序：升序或降序
        * @param students 传入参数是待排序的所有学生
        * @return 返回值为已排好序的学生集
        */
  
       public List<Student> ServiceOrderByscore(List<Student> students,String pk,String rule);
       /**
        * 该方法用于按学号查找某一条学生数据
        * @param Id为传入的学号信息
        * @return 返回值为一个具体的学生对象，找到返回，找不到返回空
        */
       public Student ServiceindById(String Id);
       /**
        * 该方法用于查询不同成绩段的学生人数
        * @param score1 成绩下限
        * @param score2 成绩上限
        * @return 返回查找的结果集
        */
       public List<Student> ServicefindByscore(int score1,int score2);
       /**
        * 该方法用于修改某个学生的信息
        * @param Id
        */
       public void ServiceupdateStudent(Student stu);
       /**
        * 根据id学号删除学生记录
        * @param id
        * @return
        */
       public void Servicedelete(String id);
}
