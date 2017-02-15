import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class NameFinderSentences {

	public static void main(String[] args) throws Exception{
		String sentence = "Mike is senior programming manager. We live in Lucknow";
		
		InputStream inputStreamTokenizer=new FileInputStream("/Users/shashankgupta/Desktop/Dataval/OpenNLP_models/en-token.bin");
		TokenizerModel modelToken=new TokenizerModel(inputStreamTokenizer);
		
		TokenizerME tokenizer=new TokenizerME(modelToken);
		String[] sentences=tokenizer.tokenize(sentence);
		
		//InputStream inputStreamName=new FileInputStream("/Users/shashankgupta/Desktop/Dataval/OpenNLP_custom_models/en-ner-indian-names.bin");
		InputStream inputStreamName=new FileInputStream("/Users/shashankgupta/Desktop/Dataval/OpenNLP_models/en-ner-person.bin");
		TokenNameFinderModel model =new TokenNameFinderModel(inputStreamName);
		
		NameFinderME nameFinder=new NameFinderME(model);
		Span[] names=nameFinder.find(sentences);
		for(Span s:names){
			System.out.println(s.toString()+" "+sentences[s.getStart()]);
		}
		
		InputStream inputStreamLocation=new FileInputStream("/Users/shashankgupta/Desktop/Dataval/OpenNLP_models/en-ner-location.bin");
		TokenNameFinderModel model_location =new TokenNameFinderModel(inputStreamLocation);
		
		NameFinderME locationFinder=new NameFinderME(model_location);
		Span[] locations=locationFinder.find(sentences);
		for(Span s:locations){
			System.out.println(s.toString()+" "+sentences[s.getStart()]);
		}
		
	}
}
