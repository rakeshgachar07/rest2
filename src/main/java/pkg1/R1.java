package pkg1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class R1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionName = "jdbc:mysql://localhost:3306/db1";
		String userName = "root";
		String password = "rootroot";
		try {
			Scanner sc1 = new Scanner(System.in);
			String s1 = sc1.nextLine();
			
			String query = "SELECT * FROM user where first_name='"+s1+"'";
			Connection con = DriverManager.getConnection(connectionName, userName, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) +
						"  " + rs.getString(5) + "  " +  rs.getString(6) + "  " + rs.getString(7) + "  " +  rs.getString(8) + "  " +  rs.getString(9) );
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
