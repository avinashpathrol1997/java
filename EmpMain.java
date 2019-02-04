package emp.assignment;
import java.util.*;
import java.io.*;
import java.sql.*;
import emp.assignment.AgeException;
abstract class Employee
{
	String name;
	int age;
	int salary;
	String designation;
	int amt;
	int id;
	static int count=0;
	


	Employee(int salary,String designation)
	{
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("-------------");
			System.out.println("\nEnter ID..");
			int id = Integer.parseInt(br.readLine());
			System.out.println("\nEnter NAME..");	
			name=br.readLine();
					
		    	System.out.println("----------------");
			System.out.println("Enter age");
			int age = Integer.parseInt(br.readLine());
			System.out.println("----------------------");
			if((age<20)||(age>60))
				throw new AgeException();
		}


			catch(InputMismatchException | AgeException e)
			{
			
			age=new AgeException().realAge();
			System.out.println("----------------------");
			}
				this.salary=salary;
				this.designation=designation;
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password-1");
					PreparedStatement pstmt = con.prepareStatement("insert into EMP values(?,?.?,?,?)");
	
					System.out.println("Enter Name:");
					String name= br.readLine();
	
					System.out.println("Enter Age:");
					int age  = Integer.parseInt(br.readLine());
	
					pstmt.setInt(1,id);		
					pstmt.setString(2,name); 
					pstmt.setInt(3,age);
					pstmt.setInt(4,salary);
					pstmt.setString(5,designation); 

					pstmt.execute();
					pstmt.close();
											count++;		
				}
			
				catch(Exception e)
				{
						System.out.println(e);
				}
		
	}
	
	
	
final public String toString()
	{
	    return "--\n"+name+" --\n"+age+"--\n"+salary+"--\n"+designation+"-\n---------\n";
	}
	
	
public static void display()
	{
				try
				{	
	                                	 Class.forName("oracle.jdbc.driver.OracleDriver");
              					  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password-1");
                                                Statement stmt=con.createStatement();
                                        
                                                ResultSet rs=stmt.executeQuery("select * from EMP");
                                                while(rs.next())
                                                {
								System.out.println("ID : "+rs.getInt(2));
                                                                System.out.println("name : "+rs.getString(1));
                                                                System.out.println("age : "+rs.getInt(2));
								System.out.println("designation : "+rs.getString(1));
                                                                System.out.println("salary : "+rs.getInt(6));
                                                                System.out.println();
                                                }
				
                                                rs.close();
                                                stmt.close();
                                                
				}
				catch(Exception e)
				{
					System.out.println(e);
				}	
}	

public static void raiseSalary()
{
			try
			{	
	                                 Class.forName("oracle.jdbc.driver.OracleDriver");
                			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password-1");
                                         Statement stmt=con.createStatement();
                                        
                                               
                                                stmt.executeUpdate("update EMP set SALARY=SALARY+2000 where DESIGNATION='clerk'");
 						stmt.executeUpdate("update EMP set SALARY=SALARY+8000 where DESIGNATION='Programmer'");
                                                stmt.executeUpdate("update EMP set SALARY=SALARY+10000 where DESIGNATION='Manager'");
                                               

						 
                                                stmt.close();
                                                
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	
}


public static void remove()
{
		try
		{
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	                                 Class.forName("oracle.jdbc.driver.OracleDriver");
                			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password-1");
                                        Statement stmt=con.createStatement();
                                        	
					System.out.println("\nEnter ID..");
					int id = Integer.parseInt(br.readLine());
					ResultSet rs = stmt.executeQuery("select  * from EMP where EID='+id'");
					if(rs.next())
					{

						System.out.println("Name :" +rs.getString(1));	
						System.out.println("name :" +rs.getString(2));
						System.out.println("age :" +rs.getString(3));
						System.out.println("salary :" +rs.getString(4));
						System.out.println("desig :" +rs.getString(5));	
						
					System.out.println("\n do you want to dekete this recored:(yes/mno)");
						String str=br.readLine();
					 if(str.equalsIgnoreCase("yes"))
						{
							stmt.executeUpdate("delete from EMP where EID=" +id);
							System.out.println("deleteed");	                                               
						}
		
					}
					else
					{
							System.out.println("inalid id");
					}
 						
                                                stmt.close();
                                                
		}		
			catch(Exception e)
						{
							System.out.println(e);
						}
	
}



final class Clerk extends Employee
{
	public Clerk()
	{
	super(8000,"Clerk");
	}
 	
}



final class Programmer extends Employee
{
	public Programmer()
	{
	super(30000,"Programmer");	
	}
	
}


final class Manager extends Employee
{
	public Manager()
	{	
	super(70000,"Manager");	
	}
	
}

public class EmpMain
	{
			public static void main(String args[]) 
		{
			try
			{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int ch=0,ch1=0;
		do
		{
			System.out.println("--------------------------------");
			System.out.println("1.Create\n2.Display\n3.Raise Salary\n4.Exit");
			System.out.println("--------------------------------");
		try
			{
				System.out.println("---------------------------------");
				System.out.println("Enter Your Choice: ");
				System.out.println("--------------------------------");
				ch=Integer.parseInt(br.readLine());
				if(ch==1)
				{
			do
				{
					System.out.println("----------------------------------");
					System.out.println("1.clerk\n2.Programmer\n3.Manager\n4.Exit");
					System.out.println("----------------------------------");
				
				try
					{
						System.out.println("---------------------------------");
						System.out.println("Enter Your Choice: ");
						System.out.println("---------------------------------");
						ch1=Integer.parseInt(br.readLine());
					
					switch(ch1)
						{
						case 1: new Clerk();
						break;
						case 2: new Programmer();
						break;
						case 3: new Manager();
						break;
						}
					}
				catch(InputMismatchException me)
					{
						System.out.println("\nEnter a valid choice\n"+me);
					}
				}while(ch1!=4);
		}
			if(ch==2)
				{
					Employee.display();
				}
			if(ch==3)
				{
					Employee.raiseSalary();
				}
			if(ch==4)
				{
					Employee.remove();
				}
		}
			catch(InputMismatchException er)
				{
					System.out.println("\nEnter a valid choice\n"+er);
				}
		}while(ch!=5);
						 System.out.println("-----------------------------");	
						 System.out.println("No.of employees : "+Employee.count);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
}	

}

