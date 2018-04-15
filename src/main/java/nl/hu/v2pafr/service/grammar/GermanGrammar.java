package nl.hu.v2pafr.service.grammar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GermanGrammar {
	public static boolean addGrammar(String newWord, String dutchWord) {
		try {
			editGrammarFile(newWord, dutchWord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static void editGrammarFile(String newWord, String dutchWord) {
		File file = new File("target/classes/translations/german.txt");
		FileWriter writer;
		try {
			writer = new FileWriter(file, true);
			writer.write(dutchWord + ":" + newWord + "\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}