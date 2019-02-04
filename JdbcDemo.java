import java.sql.*;

public class JdbcDemo
{
                public static void main(String args[])
                {
                               try
                                {
                                                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password-1");
                                                Statement stmt=con.createStatement();
                                                //stmt.executeUpdate("insert into EMP values('mahesh',45)");
                                                //stmt.executeUpdate("delete from EMP where age>30");
                                                //stmt.executeUpdate("update EMP set AGE=AGE+1");
                                                ResultSet rs=stmt.executeQuery("select * from Employee1");
                                                while(rs.next())
                                                {
                                                                System.out.println("name : "+rs.getString(1));
                                                                System.out.println("age : "+rs.getInt(2));
                                                                System.out.println();
                                                }
                                                rs.close();
                                                stmt.close();
                                                con.close();
                                }
                                catch(Exception e)
                                {
                                                System.out.println(e);
                                }
                }
}
