package iVoteProject;

import iVoteProject.Question;
import iVoteProject.Student;

public interface Service {
	public void submitAnswer(Student student);
	
	public void displayResults(Question question, int condition);
}
