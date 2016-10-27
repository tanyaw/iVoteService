package iVoteProject;

public class SingleChoiceQuestion implements Question {
	String question = "";
	String answers;
	
	public SingleChoiceQuestion(String question) {
		this.question = question;
	}
	
	public void setAnswer(String answer) {
		this.answers = answer;
	}
	
	public String getAnswer() {
		return answers;
	}
	
	public String getQuestion() {
		return question;
	}
}
