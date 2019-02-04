package emp.assignment;
import java.util.*;
import java.io.*;

public class InvalidAgeException extends Exception                                                                                                                                                                               
{
                public InvalidAgeException()
                {
                }

                public InvalidAgeException(String msg)
                {
                                super(msg);
                }

                public int readAge()
                {
                                int Age=0;

                                while(true)
                                {
                                                try
                                                {
                                                                BufferedReader br= new  BufferedReader(new InputStreamReader(System.in));
                                                                System.out.print("enter the employee age");
                                                                 Age=Integer.parseInt(br.readLine());
                                                                if(Age>=21 && Age<=60)
                                                                               return Age;
                                                                else 
                                                                                throw new InvalidAgeException();
                                                }
                                               catch (InputMismatchException |IOException ime)
                                                {
                                                                System.out.println("please enter number only");
                                                }
                                                catch(InvalidAgeException ima)
                                                {
                                                                System.out.println("please enter only numbers");
                                                }
                                }
                }
}