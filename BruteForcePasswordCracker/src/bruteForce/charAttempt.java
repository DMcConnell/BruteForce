package bruteForce;

public class charAttempt
{
	String finalized = "";
	
	public charAttempt(String solution)
	{
		String whatWeGot;
		for(int i = 6; i < 1000; i++)
		{
			whatWeGot = loops(i, solution);
			if(whatWeGot.equals(solution))
			{
				finalized = whatWeGot;
				break;
			}
		}
	}
	
	public String loops(int numTimes, String solution)
	{
		String attempt = "";
		char[] jerks;
		for(int j = 0; j < 6; j++)
		{
			jerks = Character.toChars(0);
			attempt += Character.toString(jerks[0]);
		}
		
	}
	
	public String toString()
	{
		return finalized;
	}
}
