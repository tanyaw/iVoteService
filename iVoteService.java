package iVoteProject;

import java.util.Hashtable;
import java.util.Map;

public class iVoteService {
	private Map<String, String> submissions;
	private int count;
	
	public iVoteService(Question question) {
		submissions = new Hashtable<String, String>();
		count = 0;
	}
	
	public Map<String, String> getSubmissions(){
		return submissions;
	}
	
	public int getCount(){
		return count;
	}
	
	public void setCount(int c){
		count = c;
	}
}
