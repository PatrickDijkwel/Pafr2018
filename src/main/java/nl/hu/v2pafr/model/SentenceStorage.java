package nl.hu.v2pafr.model;

//A class for storing the "to-be translated" sentence
//This class is used to show the translated sentence in a new window in the GUI
public class SentenceStorage {
	private static SentenceStorage instance;
	private String sentence;
	
	public static SentenceStorage getInstance() {
		if (instance == null) {
			instance = new SentenceStorage();
		}
		return instance;
	}
	
	public SentenceStorage() {
	}
	
	public String getSentence() {
		return this.sentence;
	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
}
