package emp.assignment;
import emp.assignment.InvalidChoiceException; 
import emp.assignment.InvalidAgeException; 
import java.io.*;
import java.util.*;
import java.sql.*;

abstract class Employee
{              int ID;
               String Name;
                int Age;
                String designation;
               int salary;
               static int count=0;    
                static Connection con=null;
                static
{                              
                                try
                                {
                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
                                }
                                catch(Exception pe)
                                {
                                                System.out.println(pe);
                                }              
}
                public Employee(int salary,String designation )
                {       
                                try
                                {  
                                                 BufferedReader br= new  BufferedReader(new InputStreamReader(System.in));
                                                System.out.println("Enter ID:");  
                                
                                                   ID=Integer.parseInt(br.readLine());                                       
                                                                
                                                System.out.println("Enter name:");
                                                            Name=br.readLine();   
                                                System.out.println("Enter age:");  
                                
                                                   Age=Integer.parseInt(br.readLine());
                                                if(Age<=21 || Age >=60)
                                                throw new InvalidAgeException();
                                }
                catch(InputMismatchException | InvalidAgeException |IOException ue)
                                {
                                                  Age=new InvalidAgeException().readAge();
                                }
                                this.salary=salary;
                                this.designation=designation;
                try
                                {
                                                
                                                PreparedStatement pstmt=con.prepareStatement("insert into EMP values(?,?,?,?,?)");
                                                pstmt.setInt(1,ID);
                                                pstmt.setString(2,Name);
    
                                                pstmt.setInt(3,Age);
                                               pstmt.setInt(4,salary);
                                                pstmt.setString(5,designation);
                                                pstmt.execute();
                                                pstmt.close();
                                                
                                                     count++;
                                }
               catch(Exception pe)        
                                {
                                                System.out.println(pe);
                                }
                
                }                                                              
                public static void display()
                {              try
                                {
                                                
                                             Statement stmt=con.createStatement();
                                
                                                ResultSet rs=stmt.executeQuery("select * from EMP");
                                                              while(rs.next())
                                                {              System.out.println("ID : "+rs.getInt(1));
                                                                System.out.println("Name : "+rs.getString(2));
                                                                System.out.println("Age : "+rs.getInt(3));
                                                                System.out.println("salary : "+rs.getInt(4));
                                                                System.out.println("designation : "+rs.getString(5));
                                                                System.out.println();
                                                }
                                                rs.close();
                                                stmt.close();
                                                
                                }

                                catch(Exception pe)        
                                {
                                                System.out.println(pe);
                                }
}
public static void raiseSal()
                                {              try
                                                {
                                                                
                                                                Statement stmt=con.createStatement();
                                                                stmt.executeUpdate("update EMP set salary=salary+5000 where designation='programmer' ");
                                                                stmt.executeUpdate("update EMP set salary=salary+2000 where designation='clerk' ");
                                                                stmt.executeUpdate("update EMP set salary=salary+5000 where designation='manager' ");
                                                                stmt.close();
                                                                con.close();
                                                }
                                catch(Exception pe)        
                                {
                                                System.out.println(pe);
                                }
                                
                }
public static void remove()
                                {              try
                                                {
                                                                  
                                                                Statement stmt=con.createStatement();
                                                                BufferedReader br= new  BufferedReader(new InputStreamReader(System.in));
                                                                System.out.println("Enter ID:");  
                                
                                                                int ID=Integer.parseInt(br.readLine());
                                                                ResultSet rs=stmt.executeQuery("select *from EMP where ID="+ID);
                                                                if(rs.next())
                                                                {
                                                                System.out.println("ID : "+rs.getInt(1));
                                                                System.out.println("Name : "+rs.getString(2));
                                                                System.out.println("Age : "+rs.getInt(3));
                                                                System.out.println("salary : "+rs.getInt(4));
                                                                System.out.println("designation : "+rs.getString(5));
                                                                System.out.println("\n do you want to remove this employee(yes/no)");
                                                                String  str=br.readLine();
                                                                if(str.equalsIgnoreCase("yes"))
                                                                {
                                                                                stmt.executeUpdate( "delete from EMP where ID="+ID);
                                                                                System.out.println("remove success");
                                                                }
                                                                }
                                                                else
                                                                { 
                                                                                System.out.println("invalid");
                                                                }              
                                                                stmt.close();
                                                                
                                                }
                                catch(Exception pe)        
                                {
                                                System.out.println(pe);
                                }
                                
                }

 
        
                                                                                
}
final  class Clerk extends Employee
{
                               public Clerk()
                                {
                                super(8000,"clerk");         
                                                
                                               }
                
} 
                                                                
final class Programmer extends Employee
{ 
              public Programmer()
                                {
                                                super(10000,"programmer");
                                }
               
} 
                                                                
final class Manager extends Employee

{ 
                 public Manager()
                {
                super(30000,"manager");            
                }
      
                                                        
} 
 


 

public class Emp 
{ 
                 
                  public static void main(String args[]) throws Exception
                {       BufferedReader br= new  BufferedReader(new InputStreamReader(System.in));        
                   //  ArrayList<Employee>e= new ArrayList<Employee>();
                     int ch=0,ch1=0;
                 do
{ 
               System.out.println("1.Create");
                System.out.println("2.display");
               System.out.println("3.Raise salary");
                System.out.println("4.Remove");
               System.out.println("5.exit");
               System.out.println("enter your choice");
                 
try
{
ch=Integer.parseInt(br.readLine());
  if(ch>5)
throw  new InvalidChoiceException();
}
catch(InputMismatchException | InvalidChoiceException |IOException ae)
{
   ch = new InvalidChoiceException().readChoice();
}
                if(ch==1)
                {
                                do
                                {
                       System.out.println("1.clerk");
                 System.out.println("2.programmer");
                System.out.println("3.manager");
               System.out.println("4.exit");
               System.out.println("enter your choice");
                 
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
                                }while(ch1!=4);

                }
if(ch==2)
                {
                  Employee.display();   
                                
                }

if(ch==3)
                {
                     Employee.raiseSal();
                }
if(ch==4)
                {
                     Employee.remove();
                }

}while(ch!=5);
System.out.println(Employee.count);

}

}



