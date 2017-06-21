package dao;

import java.io.File;
import java.util.List;
import java.util.Set;

import entity.Student;

/**
 * 学生数据操作接口，声明了查询所有数据、排序、按学号查找数据、按成绩分段查找数据、修改数据、删除数据的方法
 * @author jiaqing
 *
 */
public interface StudentScoreDao {
	/**
	 * 该方法用于导入数据形成一个副本，保存在工程当中
	 * @param dir 参数为数据源路径
	 * @return
	 */
	  public void InsertData(String dir,Student st);
	/**
	 * 该方法用于查找所有学生信息
	 * @return List<Student>为返回的一个结果集
	 */
       public List<Student> findAllStudents();
       /**
        * 该方法用于进行按成绩排序：升序或降序
        * @param students 传入参数是待排序的所有学生
        * @return 返回值为已排好序的学生集
        */
  
       public List<Student> OrderByscore(List<Student> students,String pk,String rule);
       /**
        * 该方法用于按学号查找某一条学生数据
        * @param Id为传入的学号信息
        * @return 返回值为一个具体的学生对象，找到返回，找不到返回空
        */
       public Student findById(String Id);
       /**
        * 该方法用于查询不同成绩段的学生人数
        * @param score1 成绩下限
        * @param score2 成绩上限
        * @return 返回查找的结果集
        */
       public List<Student> findByscore(int score1,int score2);
       /**
        * 该方法用于修改某个学生的信息
        * @param stu
        */
       public void updateStudent(Student stu);
       /**
        * 该方法用于删除特定的某个学生记录
        * @param id
        * @return
        */
       public void deleteStudent(String id);
}
