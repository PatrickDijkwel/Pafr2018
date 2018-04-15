package nl.hu.v2pafr.service.translator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GermanTranslator implements Translator{
	
	public String translate(String sentence) {
		String file = readFile();
		String[] split = file.split(":|\\n");
		List<String> split2 = Arrays.asList(split);
		ArrayList<String> dutch = new ArrayList<String>();
		ArrayList<String> translations = new ArrayList<String>();
		
		for(int i = 0; i < split2.size(); i++) {
			String s = split2.get(i);
			s = split2.get(i).replaceAll("\\s+", "");
			if(i % 2 == 0) {
				dutch.add(s);
			} else {
				translations.add(s);
			}
		}
		
		List<String> wordList = getWordsFromSentence(sentence);
		String newSentence = "";
		for(String s : wordList) {
			if(dutch.contains(s)) {
				int index = dutch.indexOf(s);
				newSentence += translations.get(index) + " ";
			} else {
				newSentence += "<UNKNOWN WORD> ";
			}
		}
		return newSentence;
	}
	
	private String readFile() {
		try {
			URL url = getClass().getClassLoader().getResource("./translations/german.txt");
			File file = new File(url.getPath());
			byte[] bytes = Files.readAllBytes(file.toPath());
	
			return new String(bytes, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<String> getWordsFromSentence(String s) {
		String[] words = s.split("\\s");
		List<String> wordList = Arrays.asList(words);
		
		return wordList;
	}

}
