package luizaLabs.movies.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileUtils 
{
	public static List<String> searchStringOnFiles(List<String> words) throws Exception
	{
		LinkedList<String> filesMatched = new LinkedList<String>();
		File execFile = new File(Application.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
		File folder = new File(execFile.getParent() + File.separator + "data");

		// Code bellow is slow!! = 1.3 seconds
		BufferedReader br = null;
		String line;
		int i;
		for (File file : folder.listFiles())
		{
    		br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) 
			{
				i = 0;
				for(String word : words)
    			{
    				if (!line.contains(word))
        			{
    					break;
        	        }
    				i++;
    			}

				if (i == words.size())
				{
					filesMatched.addFirst(file.getName());
					break;
				}
			}
   			br.close();
		}

		Collections.sort(filesMatched);
		return filesMatched;
	}
}
