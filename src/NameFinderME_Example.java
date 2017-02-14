import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class NameFinderME_Example {

	public static void main(String[] args) throws Exception{
		String [] sentence = new String[]{ 
		         "Mike", 
		         "and", 
		         "Smith", 
		         "are", 
		         "good", 
		         "friends" 
		      }; 
		
		InputStream inputStream=new FileInputStream("/Users/shashankgupta/Desktop/Dataval/OpenNLP_models/en-ner-person.bin");
		TokenNameFinderModel model =new TokenNameFinderModel(inputStream);
		
		NameFinderME nameFinder=new NameFinderME(model);
		Span[] names=nameFinder.find(sentence);
		for(Span s:names){
			System.out.println(s);
		}
	}
}
