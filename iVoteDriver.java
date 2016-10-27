package iVoteProject;

import java.util.Random;

public class iVoteDriver {

	public static void main(String[] args) {
		Random rand = new Random();
		
		// ----- Part I: Multiple Choice Question -----
		//Generate random number of students
		int studentCount = rand.nextInt(50) + 1;
		System.out.println("Number of Students - " + studentCount);	//Debug
		
		//List of students
		Student[] students1 = new Student[studentCount];
		
		//Set Student IDs
		for(int i=0; i < studentCount; i++) {
			String id = Integer.toString(i);
			students1[i] = new Student(id);
		}
		
		//Question, Choices, Answer
		Question mc = new MultipleChoiceQuestion("Question 1");
		String choices = "ABCDE";
		mc.setAnswer("A");
		
		//Generate random choices - Each student may only select 1 choice
		int randomAnswer = rand.nextInt(choices.length());
		for(int i=0; i < studentCount; i++) {
			randomAnswer = rand.nextInt(choices.length());
	    	students1[i].setAnswer(Character.toString(choices.charAt(randomAnswer)));
	    	//System.out.println("Student " + i + "\t" + randomAnswer);	//Debug
		}
		
		//Generate random number of re-submission
		//System.out.println("\n---Resubmissions---");	//Debug
		int resubmitCount = rand.nextInt(studentCount) + 1;
		
		System.out.println("Number of Resubmissions - " + resubmitCount);	//Debug
		
		//Resubmit choices - Service must go with last selected choice
		int randomStudent;
		for(int i=0; i < resubmitCount; i++){
			randomAnswer = rand.nextInt(choices.length());
			randomStudent = rand.nextInt(studentCount);
	    	students1[randomStudent].setAnswer(Character.toString(choices.charAt(randomAnswer)));
	    	//System.out.println("Student " + randomStudent + "\t" + randomAnswer);	//Debug
		}
		
		//Debug
		//for(int i=0; i <studentCount; i++) {
		//	System.out.println("Student Final " + i + ": "+ students1[i].getAnswer());
		//}
		
		//Submit Answers
		Service service1 = new MultipleChoiceService(mc);
		
		for(int i = 0; i < studentCount; i++){
		    service1.submitAnswer(students1[i]);
	    }
		
		//Display Student Submissions + 
		service1.displayResults(mc, studentCount);
		
		// ----- Part II: Single Choice Question ------
		//Generate random number of students
				int studentCount2 = rand.nextInt(50) + 1;
				System.out.println("\n\nNumber of Students - " + studentCount2);	//Debug
				
				//List of students
				Student[] students2 = new Student[studentCount2];
				
				//Set Student IDs
				for(int i=0; i < studentCount2; i++) {
					String id = Integer.toString(i);
					students2[i] = new Student(id);
				}
				
				//Question, Choices, Answer
				Question sc = new SingleChoiceQuestion("Question 2");
				String choices2 = "TF";
				sc.setAnswer("F");
				
				//Generate random choices - Each student may only select 1 choice
				int randomAnswer2 = rand.nextInt(choices2.length());
				for(int i=0; i < studentCount2; i++) {
					randomAnswer2 = rand.nextInt(choices2.length());
			    	students2[i].setAnswer(Character.toString(choices2.charAt(randomAnswer2)));
			    	//System.out.println("Student " + i + "\t" + randomAnswer);	//Debug
				}
				
				//Generate random number of re-submission
				//System.out.println("\n---Resubmissions---");	//Debug
				int resubmitCount2 = rand.nextInt(studentCount2) + 1;
				
				System.out.println("Number of Resubmissions - " + resubmitCount2);	//Debug
				
				//Resubmit choices - Service must go with last selected choice
				int randomStudent2;
				for(int i=0; i < resubmitCount2; i++){
					randomAnswer2 = rand.nextInt(choices2.length());
					randomStudent2 = rand.nextInt(studentCount2);
			    	students2[randomStudent2].setAnswer(Character.toString(choices2.charAt(randomAnswer2)));
			    	//System.out.println("Student " + randomStudent + "\t" + randomAnswer);	//Debug
				}
				
				//Debug
				//for(int i=0; i <studentCount; i++) {
				//	System.out.println("Student Final " + i + ": "+ students1[i].getAnswer());
				//}
				
				//Submit Answers
				Service service2 = new SingleChoiceService(sc);
				
				for(int i = 0; i < studentCount2; i++){
				    service2.submitAnswer(students2[i]);
			    }
				
				//Display Student Submissions + 
				service2.displayResults(sc, studentCount2);
	}
}
