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
		if(numTimes == 0)
		{
			
		}
		else
		{
			attempt += loops(numTimes - 1, solution);
		}
	}
	
	public String toString()
	{
		return finalized;
	}
}
