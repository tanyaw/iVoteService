package iVoteProject;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class SingleChoiceService extends iVoteService implements Service {
	private int[] results;
	private Map<String, String> submissions;
	private Set<String> studentIDs;
	
	public SingleChoiceService(Question question) {
		super(question);
		
		submissions = new Hashtable<String, String>();
		results = new int[5];
		studentIDs = submissions.keySet();
	}

	@Override
	public void submitAnswer(Student student) {
		//Put ID & Answer in HashTable
		submissions.put(student.getID(), student.getAnswer());
		
		//Count submitted answers
		if(student.getAnswer().equals("T")) {
			results[0]++;
		} else {
			results[1]++;
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
		System.out.println("T: " + results[0] + " Submissions");
		System.out.println("F: " + results[1] + " Submissions");
	
		//Print # of correct & # of incorrect answers
		System.out.println("----------------------------------");
		System.out.println("The correct response is " + question.getAnswer());
		System.out.println("# of Correct Responses: " + correct);
		System.out.println("# of Wrong Responses: " + wrong);
	}

}
