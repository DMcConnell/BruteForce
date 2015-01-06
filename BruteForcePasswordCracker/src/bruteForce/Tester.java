package bruteForce;

public class Tester
{
	public static void main(String [] args)
	{
		String attempt = "";
		char[] jerks;
		for(int i = 96; i < 97; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				jerks = Character.toChars(i);
				attempt += Character.toString(jerks[0]);
			}
		}
		System.out.print(attempt);
	}
}
