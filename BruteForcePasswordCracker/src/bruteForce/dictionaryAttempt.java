package bruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class dictionaryAttempt
{
	static BufferedReader br;
	static String correctPW = "", guess;
	static ArrayList<String> speChar, nums;
	
	public dictionaryAttempt(String origPW)
	{
		boolean breaker = false;
		String path = System.getProperty("user.dir") + "\\Resources\\dictionary.txt";
		String[] words = new String[58109];
		try
		{
			br = new BufferedReader(new FileReader(path));
			for (int i = 0; i < words.length; i++)
			    words[i] = br.readLine();
			br.close();
		}
		catch (Exception e)
		{
			System.out.print("e");
		}
		buildLists();
		for(int i = 0; i < words.length; i++)
		{
			for(int j = 0; j < nums.size(); j++)
			{
				for(int h = 0; h < speChar.size(); h++)
				{
					if(check(words[i], nums.get(j), speChar.get(h), origPW))
						breaker = true;
					if(breaker)
						break;
				}
				if(breaker)
					break;
			}
			if(breaker)
				break;
		}
	}
	
	public void buildLists()
	{
		speChar = new ArrayList<String>();
		nums = new ArrayList<String>();
		String added = "";
		for(int i = 32; i < 48; i++)
		{
			added += (char)i;
			speChar.add(added);
			added = "";
		}
		for(int i = 58; i < 65; i++)
		{
			added += (char)i;
			speChar.add(added);
			added = "";
		}
		for(int i = 91; i < 97; i++)
		{
			added += (char)i;
			speChar.add(added);
			added = "";
		}
		for(int i = 123; i < 127; i++)
		{
			added += (char)i;
			speChar.add(added);
			added = "";
		}
		for(int i = 0; i < 10; i++)
			nums.add(Integer.toString(i));
	}
	
	public ArrayList<String> generateOptions(String word, String num, String theSpeChar)
	{
		ArrayList<String> possibles = new ArrayList<String>();
		int length = word.length();
		for(int i = 0; i < length; i++)
		{
			for(int j = 0; j < length; j++)
			{
				if(i == 0)
				{
					if(j == 0)
					{
						possibles.add(num + theSpeChar + word);
						possibles.add(theSpeChar + num + word);
					}
					else
					{
						possibles.add(num + word.substring(0,j) + speChar + word.substring(j));
						possibles.add(speChar + word.substring(0,j) + num + word.substring(j));
						if(j == length - 1)
						{
							possibles.add(num + word + speChar);
							possibles.add(speChar + word + num);
						}
					}
				}
				else if(i == length - 1)
				{
					possibles.add(word + num + speChar);
					possibles.add(word + speChar + num);
				}
				else
				{
					if(j >= i)
					{
						if(i == j)
						{
							possibles.add(word.substring(0,i) + num + speChar + word.substring(j));
							possibles.add(word.substring(0,i) + speChar + num + word.substring(j));
						}
						else
						{
							possibles.add(word.substring(0,i) + num + word.substring(i,j) + speChar + word.substring(j));
							possibles.add(word.substring(0,i) + speChar + word.substring(i,j) + num + word.substring(j));
							if(j == length - 1)
							{
								possibles.add(word.substring(0,i) + num + word.substring(i) + speChar);
								possibles.add(word.substring(0,i) + speChar + word.substring(i) + num);
							}
						}
					}
				}
			}
		}
		return possibles;
	}
	
	public  boolean check(String word, String num, String theSpeChar, String Orig)
	{
		ArrayList<String> possibles = generateOptions(word, num, theSpeChar);
		for(int i = 0; i < possibles.size(); i++)
		{
			if(possibles.get(i).equals(Orig))
			{
				setCorrect(possibles.get(i));
				return true;
			}
		}
		for(int i = 0; i < possibles.size(); i++)
			possibles.remove(i);
		return false;
	}
	
	public void setCorrect(String pw)
	{
		correctPW = pw;
	}
	
	public String toString()
	{
		return correctPW;
	}
}