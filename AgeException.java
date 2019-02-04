package emp.assignment;
import java.util.*;
import java.io.*;
public class AgeException extends Exception
{	public AgeException()
	{
	}
	public AgeException(String msg)
	{	super(msg);
	}
	public int realAge()
	{
		int age=0;
		while(true)
		{
		try
		{
			System.out.println("Enter age");
			age=new Scanner(System.in).nextInt();
			if((age>=20)&&(age<=60))
				return age;
			else
				throw new AgeException();
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nEnter a valid Age\n"+e);
			
		}
		catch(AgeException ae)
		{
			System.out.println("\nEnter a valid Age between 21 and 60\n"+ae);
			
		}	
		}
		
	}
	
}
