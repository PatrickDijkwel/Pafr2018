package nl.hu.v2pafr.service;

import java.util.ArrayList;

import nl.hu.v2pafr.service.translator.EnglishTranslator;
import nl.hu.v2pafr.service.translator.GermanTranslator;
import nl.hu.v2pafr.service.translator.Translator;

//In this class you add what languages you can choose in the GUI
public class TranslatorService {
	public final static String ENGLISH = "ENGLISH";
	public final static String DEUTSCH = "DEUTSCH";
	
	public static ArrayList<String> getLanguages() {
		ArrayList<String> languages = new ArrayList<>();
		
		languages.add(ENGLISH);
		languages.add(DEUTSCH);
		
		return languages;
	}
	
	public static Translator getTranslatorForLanguage(String language) {
		if (language.equals(ENGLISH)) {
			return new EnglishTranslator();
		}
		if (language.equals(DEUTSCH)) {
			return new GermanTranslator();
		}
		
		return null;
	}

}
