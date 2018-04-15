package nl.hu.v2pafr.service.grammar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import nl.hu.v2pafr.service.GrammarService;

public class DutchGrammar {
	public static boolean addGrammar(String wordType, String newWord) {
		try {
			String newFile = editGrammarFile(wordType, newWord);
			writeGrammarFile(newFile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Adds grammar to the Vertaler.g4 antlr-file
	private static String editGrammarFile(String wordType, String newWord) {
		try { 
			InputStream is = GrammarService.class.getResourceAsStream("/nl/hu/v2pafr/antlr/Vertaler.g4");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String newFile = "";
			String line;
			while ((line = br.readLine()) != null) {
				if(wordType.equals("zelfstandig_naamwoord") & line.startsWith("zelfstandig_naamwoord")) {
					line = line.substring(0, line.length() - 1);
					line += "| ('" + newWord + "') ;";
				}
				else if(wordType.equals("lidwoord") & line.startsWith("lidwoord")) {
					line = line.substring(0, line.length() - 1);
					line += "| ('" + newWord + "') ;";
				}
				else if(wordType.equals("werkwoordelijk_deel") & line.startsWith("werkwoordelijk_deel")) {
					line = line.substring(0, line.length() - 1);
					line += "| ('" + newWord + "') ;";
				}
				newFile += line + "\n";
			}
			br.close();
			is.close();
			
			return newFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Overwrites the old Antlr-file where the Grammar is defined
	private static void writeGrammarFile(String newFile) {
		//There are 2 Vertaler.g4 files, and changing one doesn't update the other, so both are edited
		
		//This one is used during run-time to check the grammar
		File file = new File("target/classes/nl/hu/v2pafr/antlr/Vertaler.g4");
		
		//This one is used to build the grammar from within the IDE 
		File file2 = new File("src/main/java/nl/hu/v2pafr/antlr/Vertaler.g4");
		FileWriter writer;
		try {
			writer = new FileWriter(file, false);
			writer.write(newFile);
			writer.close();
			writer = new FileWriter(file2, false);
			writer.write(newFile);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
