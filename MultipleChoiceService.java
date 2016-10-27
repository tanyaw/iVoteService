package iVoteProject;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MultipleChoiceService extends iVoteService implements Service {
	private int[] results;
	private Map<String, String> submissions;
	private Set<String> studentIDs;
	
	public MultipleChoiceService(Question question) {
		super(question);
		
		submissions = new Hashtable<String, String>();
		results = new int[5];
		studentIDs = submissions.keySet();
	}

	@Override
	public void submitAnswer(Student student) {
		//Put ID & Answer in HashTable
		submissions.put(student.getID(), student.getAnswer());
		//System.out.println("Submit Student Info");			//Debug
		//System.out.println("ID: " + student.getID());			//Debug
		//System.out.println("Ans: " + student.getAnswer());	//Debug
		
		//Count submitted answers
		if(student.getAnswer().equals("A")) {
			results[0]++;
		} else if(student.getAnswer().equals("B")) {
			results[1]++;
		} else if(student.getAnswer().equals("C")) {
			results[2]++;
		} else if(student.getAnswer().equals("D")) {
			results[3]++;
		} else {
			results[4]++;
		}
	}

	@Override
	public void displayResults(Question question, int studentCount) {
		System.out.println("---------------------------");
		System.out.println("         " + question.getQuestion());
		System.out.println("---------------------------");
		System.out.println("    *** RESULTS ***");
		
		int correct = 0;
		int wrong = 0;
		
		//Print Student submissions
		for (String id: studentIDs) {
			String submitted = submissions.get(id);
			System.out.println("Student " + id + "\t"+ submitted);
			
			if(submitted.equals(question.getAnswer())) {
				correct++;
			} else { 
				wrong++;
			}	
		}
		
		//Print count of submitted answers
		System.out.println("-------- Submission Count ---------");
		for(int i=0; i < results.length; i++) {
			if(i==0) {
				System.out.println("A: " + results[i] + " Submissions");
			} else if(i==1) {
				System.out.println("B: " + results[i] + " Submissions");
			} else if(i==2){
				System.out.println("C: " + results[i] + " Submissions");
			} else if(i==3) {
				System.out.println("D: " + results[i] + " Submissions");
			} else {
				System.out.println("E: " + results[i] + " Submissions");
			}
		}
		
		//Print # of correct & # of incorrect answers
		System.out.println("----------------------------------");
		System.out.println("The correct response is " + question.getAnswer());
		System.out.println("# of Correct Responses: " + correct);
		System.out.println("# of Wrong Responses: " + wrong);
	}

}
