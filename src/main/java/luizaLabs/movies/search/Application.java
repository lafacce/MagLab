package luizaLabs.movies.search;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) throws Exception 
	{
		if (args.length != 1)
		{
			throw new Exception("Search should have one argument with ths string to be searched.");
		}
		
		String[] words_aux = args[0].toLowerCase().split(" ");
		List<String> words = new ArrayList<String>();
		for (String word : words_aux)
		{
			words.add(word);
		}
		
		List<String> filesMatched = FileUtils.searchStringOnFiles(words);


		for (String fileMatched : filesMatched)
		{
			System.out.println("data/" + fileMatched);
		}
	}

}
