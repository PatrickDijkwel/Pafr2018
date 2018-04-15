package nl.hu.v2pafr.service;

import java.util.ArrayList;

public class InputService {
	public final static String textfield = "textfield";
	
	public static ArrayList<String> getInputTypes() {
		ArrayList<String> inputTypes = new ArrayList<>();
		
		inputTypes.add(textfield);
		
		return inputTypes;
	}

}
