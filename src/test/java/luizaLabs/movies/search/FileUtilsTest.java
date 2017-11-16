package luizaLabs.movies.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public final class FileUtilsTest 
{
	static List<String> expectedFiles = null;  		

	final static String expected = 
						"a-cowboy-needs-a-horse.txt " +
						"alice-and-the-three-bears.txt " +
						"alice-helps-the-romance.txt " +
						"alice-s-fishy-story.txt " +
						"alpine-climbers.txt " +
						"billposters.txt " +
						"bone-trouble.txt " +
						"bootle-beetle.txt " +
						"canine-caddy.txt " +
						"clown-of-the-jungle.txt " +
						"cock-o-the-walk.txt " +
						"cured-duck.txt " +
						"dog-watch.txt " +
						"donald-s-dream-voice.txt " +
						"donald-s-snow-fight.txt " +
						"dude-duck.txt " +
						"el-gaucho-goofy.txt " +
						"fall-out-fall-in.txt " +
						"father-noah-s-ark.txt " +
						"fathers-are-people.txt " +
						"football-now-and-then.txt " +
						"funny-little-bunnies.txt " +
						"gallopin-gaucho.txt " +
						"good-scouts.txt " +
						"goofy-and-wilbur.txt " +
						"great-guns.txt " +
						"how-to-be-a-sailor.txt " +
						"how-to-have-an-accident-at-work.txt " +
						"jiminy-cricket-s-christmas.txt " +
						"mickey-s-elephant.txt " +
						"moochie-of-pop-warner-football.txt " +
						"on-ice.txt " +
						"pantry-pirate.txt " +
						"perri.txt " +
						"self-control.txt " +
						"sky-scrappers.txt " +
						"society-dog-show.txt " +
						"spare-the-rod.txt " +
						"tall-timber.txt " +
						"the-four-musicians-of-bremen.txt " +
						"the-hockey-champ.txt " +
						"the-jazz-fool.txt " +
						"the-little-house.txt " +
						"the-mail-pilot.txt " +
						"the-merry-dwarfs.txt " +
						"the-nifty-nineties.txt " +
						"the-pet-store.txt " +
						"tommy-tucker-s-tooth.txt " +
						"tugboat-mickey.txt " +
						"two-gun-mickey.txt " +
						"undiscovered-walt-disney-world.txt " +
						"wide-open-spaces.txt " +
						"working-for-peanuts.txt";
					
	@BeforeClass
	public static void setUp()
	{
		expectedFiles = new ArrayList<String>();
		String[] listOfFilesExpected = expected.split(" ");
		for(String file : listOfFilesExpected)
		{
			expectedFiles.add(file);
		}
		Collections.sort(expectedFiles);
	}
	
	@Test
	public void testResultOfMethodSearchStringOnFiles() throws Exception
	{
		// Arrange
		List<String> words = new ArrayList<String>();
		words.add("walt");
		words.add("disney");
		
		// Act 
		List<String> files = FileUtils.searchStringOnFiles(words);
		
		// Assert
		assertEquals("Number of files expected is not the same as files found", expectedFiles.size(), files.size());
		for (String expectedFile : expectedFiles)
		{
			assertTrue("File " + expectedFile + "is not found in search", files.contains(expectedFile));
		}
	}
	
	@Test
	public void testTimeForMethodSearchStringOnFiles() throws Exception
	{
		// Arrange
		long timeExpected = 100;
		List<String> words = new ArrayList<String>();
		words.add("walt");
		words.add("disney");
		
		// Act

		long timestampStart = System.nanoTime();
		FileUtils.searchStringOnFiles(words);
		long timestampEnd = System.nanoTime();
		
		// Assert
		long timeSpent = (timestampEnd - timestampStart) / (1000);
		assertTrue("It took " + timeSpent + "ms to get files matched", timeSpent <= timeExpected);
	}
	
	@Test
	public void testFilesIsSortedForMethodSearchStringOnFiles() throws Exception
	{
		// Arrange
		List<String> words = new ArrayList<String>();
		words.add("walt");
		words.add("disney");
		
		// Act
		List<String> files = FileUtils.searchStringOnFiles(words);
		
		// Assert
		for (int i = 0; i < expectedFiles.size(); i++)
		{
			assertEquals(expectedFiles.get(i), files.get(i));
		}
		
	}
}
