package emp.assignment;
import java.util.*;
import java.io.*;


public class InvalidChoiceException extends Exception                                                                                                                                                                               
{
                public InvalidChoiceException()
                {
                }

                public InvalidChoiceException(String msg)
                {
                                super(msg);
                }
                public int readChoice()
                {
                               int ch=0;
                                while(true)
                                {
                                                try
                                                {        BufferedReader br= new  BufferedReader(new InputStreamReader(System.in));
                                                                System.out.println("enter the choice");
                                                                ch=Integer.parseInt(br.readLine());
                                                                if(ch<=4)
                                                                return ch;
                                                                else
                                                                throw new InvalidChoiceException();

                                                }
                                               catch (InputMismatchException |IOException ime )
                                                {
                                                                System.out.println("please enter number only");
                                                }
                                                catch(InvalidChoiceException ice)
                                                {
                                                                System.out.println("please change the choice");
                                                }
                                }
                }
}
