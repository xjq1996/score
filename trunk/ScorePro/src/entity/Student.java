package entity;

public class Student {
       private String Id;
       private String name;
       private String score_name;
       private double score;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScore_name() {
		return score_name;
	}
	public void setScore_name(String score_name) {
		this.score_name = score_name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Student(String id, String name, String score_name, double score) {
		super();
		Id = id;
		this.name = name;
		this.score_name = score_name;
		this.score = score;
	}
	public Student() {
		super();
	}
	
       
}
