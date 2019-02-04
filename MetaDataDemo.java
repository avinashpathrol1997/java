	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password-1");
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select *from" +args[0]);
	
	ResultSetMetaData rsmd = rs.getMetaData();
	
	int columns  =rsmd.getColumnCount();
	
	while(rs.next())
	{
		for(int i=1;i<=columns;i++)
		{
			System.out.println(rsmd.getColumnName(i)+":"+rss.getString(i));
		}
		System.out.println();
	}

		System.out.println("---------");
	
	rs.absolute(3);
			System.out.println("Name :" +rs.getString(1));
	rs.absolute(2);
			System.out.println("Name :" +rs.getString(2));
	
	rs.close();
	stmt.close();
	con.close();
}
catch(Exception e)
{
		System.out.println(e);
}
}


	