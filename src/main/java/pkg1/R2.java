package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class R2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionName = "jdbc:mysql://localhost:3306/db1";
		String userName = "root";
		String password = "rootroot";
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			Scanner sc1 = new Scanner(System.in);
			String s1 = sc1.nextLine();
			String s2  = sc1.nextLine();
			String s3 = sc1.nextLine();
			String s4 = sc1.nextLine();
			String query = "Insert into user (first_name, last_name,email,pin_code) values (?,?,?,?)";
			con = DriverManager.getConnection(connectionName, userName, password);
			pStmt = con.prepareStatement(query);
			pStmt.setString(1, s1);
			pStmt.setString(2, s2);
			pStmt.setString(3, s3);
			pStmt.setString(4, s4);
			int rows = pStmt.executeUpdate();
			if(rows > 0 ) {
					System.out.println("Inserted Successfully!!!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(pStmt != null) {
					pStmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
