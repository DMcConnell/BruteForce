package bruteForce;

import java.util.*;

public class Tester
{
	static ArrayList<Character> letters = new ArrayList<Character>();
	static int place;
	
	public static void main(String [] args)
	{
		for(int i = 0; i < 6; i++)
			letters.add('a');
		place = letters.size()-1;
		char[] temp2;
		int temp = (int)letters.get(place);
		temp++;
		temp2 = Character.toChars(temp);
		letters.set(place,temp2[0]);
		for(int i = 0; i < 6; i++)
		{
			System.out.print(letters.get(i));
		}
	}
}
