package nl.hu.v2pafr.service;

import java.util.ArrayList;

//This class can be used for different input types for translation.
//At this moment the you can only use the textfield in the translator, so this class isn't used
public class InputService {
	public final static String textfield = "textfield";
	
	public static ArrayList<String> getInputTypes() {
		ArrayList<String> inputTypes = new ArrayList<>();
		
		inputTypes.add(textfield);
		
		return inputTypes;
	}

}
