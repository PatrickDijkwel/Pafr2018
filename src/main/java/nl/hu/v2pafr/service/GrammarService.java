package nl.hu.v2pafr.service;

import java.util.ArrayList;

import nl.hu.v2pafr.service.grammar.DutchGrammar;
import nl.hu.v2pafr.service.grammar.EnglishGrammar;
import nl.hu.v2pafr.service.grammar.GermanGrammar;

public class GrammarService {
	public final static String ZELFSTANDIGNAAMWOORD = "zelfstandig_naamwoord";
	public final static String LIDWOORD = "lidwoord";
	public final static String WERKWOORD = "werkwoordelijk_deel";
	
	public static ArrayList<String> getWordTypes() {
		ArrayList<String> wordTypes = new ArrayList<>();
		
		wordTypes.add(ZELFSTANDIGNAAMWOORD);
		wordTypes.add(LIDWOORD);
		wordTypes.add(WERKWOORD);
		
		return wordTypes;
	}
	
	//Passes the new translation to it's language
	public static boolean writeGrammarForLanguage(String language, String newWord, String dutchWord) {
		if (language.equals("English")) {
			return EnglishGrammar.addGrammar(newWord, dutchWord);
		}
		if (language.equals("German")) {
			return GermanGrammar.addGrammar(newWord, dutchWord);
		}
		return false;
	}
	
	//For the Dutch grammar we also need to specify the word type of the new word
	//The attributes of this class are all the possible word types.
	public static boolean writeGrammarForDutch(String wordType, String newWord) {
		return DutchGrammar.addGrammar(wordType, newWord);
	}

}
