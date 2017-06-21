import dao.StudentScoreDao;
import dao.impl.StudentScore;

public class test {
    public static void main(String[] args) {
		 StudentScoreDao dao=new StudentScore();
		 System.out.println(dao.findAllStudents().get(0).getName());
	}
}
