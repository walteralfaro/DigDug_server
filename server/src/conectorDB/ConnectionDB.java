package conectorDB;

import java.sql.*;

public class ConnectionDB {
	private static ConnectionDB conection = new ConnectionDB();
	private static Connection con;
	private ConnectionDB() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String ip = "127.0.0.1";
			String puerto = "3306";
			String database = "preguntados";
			String user = "root";
			String password = "";
			String url = "jdbc:mysql://"+ip+ ':' +puerto+'/'+database;
			con = DriverManager.getConnection(url, user, password);
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	public static ConnectionDB getConection() {
		return conection;
	}
	
	public Connection getCon() {
		return con;
	}

	public static void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
