/*
Eiti Parruca Adama - 2232472
Leandro Martins Tosta - 2232510


*/




import java.io.IOException;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

	public static void main(String[] args) throws IOException {
		// Analise Sintatica
		
		CharStream cs = CharStreams.fromFileName("programa1.gyh");
		GyhLangLexer lexer = new GyhLangLexer(cs);
		CommonTokenStream token = new CommonTokenStream(lexer);
		GyhLangParser parser = new GyhLangParser(token);
		
		parser.programa();
		parser.generateCommand();
		
		/* Analise Lexica
		CharStream cs = CharStreams.fromFileName("programa1.gyh");
		GyhLangLexer lexer = new GyhLangLexer(cs);
		Token t;
		
		while((t=lexer.nextToken()).getType() !=Token.EOF) {
			System.out.println("< " + lexer.VOCABULARY.getSymbolicName(t.getType()) + " , " + t.getText() + " >");
		}*/
	}

}
