import java.io.*;
public class KeyInput
{
	public static void main(String args[]) throws Exception
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("Ente name: ");
	String name=br.readLine();
	
		System.out.println("Ente Addresss: ");
		String address=br.readLine();
	
		System.out.println("Ente Age: ");
		int age=Integer.parseInt(br.readLine());
		


		System.out.println("--------------- ");

		System.out.println("Name :" +name);

		System.out.println("Age: " +age);

		System.out.println("Address: " +address);
}
}