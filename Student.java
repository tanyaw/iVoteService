package iVoteProject;

public class Student {
	private String student_ID;
	private String answer;
	
	public Student(String id) {
		student_ID = id;
	}
	
	public void setID(Student stu, String id) {
		stu.student_ID = id;
	}
	
	public String getID() {
		return this.student_ID;
	}
	
	public void setAnswer(String ans) {
		answer = ans;
	}
	
	public String getAnswer() {
		return answer;
	}
}