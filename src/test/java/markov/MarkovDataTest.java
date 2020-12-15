package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	MarkovData data = new MarkovData();
	@Test
	/**
	 * Given read
	 * When two words and Empty list of words
	 * Then list with 2 added words
	 */
	public void read_twoWordsEmptyList_listWithTwoWords() {
		String[] words = {"two", "words"};
		String text = words[0]+" "+words[1];
		data.read(text);
		assertEquals(data.keyWordSize(),words.length);
		assertEquals(data.getKeyWord(0),words[0]);
		assertEquals(data.getKeyWord(1),words[1]);
	}
	
	@Test
	/**
	 * Given read
	 * When one word + two already in the list
	 * Then list with 2 + 1 added words
	 */
	public void read_oneWordsTwoInList_listWithThreeWords() {
		String[] words = {"two", "words", "one"};
		String text = words[0]+" "+words[1];
		data.read(text);
		data.read(words[2]);
		assertEquals(data.keyWordSize(),words.length);
		assertEquals(data.getKeyWord(2),words[2]);
	}
	
	@Test
	/**
	 * Given renforceWord
	 * When EmptyList
	 * Then false
	 */
	public void renforceWord_EmptyList_false() {
		String keyString = "a", wordToLearn = "b";
		boolean actual = data.renforceWord(keyString, wordToLearn);
		assertFalse(actual);
	}

	@Test
	/**
	 * Given renforceWord
	 * When alreadyExistingWord
	 * Then true
	 */
	public void renforceWord_alreadyExistingWord_true() {
		String keyString = "a", learnWord = "b", wordToLearn = "c";
		data.learnWord(keyString, learnWord);
		
		boolean actual = data.renforceWord(keyString, wordToLearn);
		assertTrue(actual);
	}
	
	

}
