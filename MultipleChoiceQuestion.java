package iVoteProject;

public class MultipleChoiceQuestion implements Question {
		private String answers;
		private String question = "";
		
		public MultipleChoiceQuestion(String question) {
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
