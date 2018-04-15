package nl.hu.v2pafr.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

public class SentenceParser {
	//This method returns true or false if the sentence was correct or not according to the syntax
	public static boolean parseSentence(String zin) {
		ANTLRInputStream input = new ANTLRInputStream(zin.toLowerCase());
		
		VertalerLexer lexer = new VertalerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		VertalerParser parser = new VertalerParser(tokens);
		
		//Here the syntax of an "eenvoudigezin" is being checked
		parser.eenvoudigezin();
		//If there are syntaxerrors the method: .getNumberOfSyntaxErrors will return the amount of errors
		if(parser.getNumberOfSyntaxErrors() == 0) {
			System.out.println("Deze zin klopt");
			return true;
		}
		else {
			System.out.println("Deze zin klopt niet");
			return false;
		}
		
	}

}
