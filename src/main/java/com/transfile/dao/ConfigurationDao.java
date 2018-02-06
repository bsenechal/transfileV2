package com.transfile.dao;

import com.transfile.model.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe pour communiquer avec la BDD + Gestion des transactions
public class ConfigurationDao {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false";
	private static final String DB_USER = "test";
	private static final String DB_PASSWORD = "test";

	public List<Configuration> findAllConfigurations() throws SQLException {
		List<Configuration> result = new ArrayList<Configuration>();

        Connection dbConnection = null;
		PreparedStatement preparedStatement = null;


		String selectSQL = "SELECT * FROM CONFIGURATION";

		try
		{
			// Ouverture de la connection vers la BDD
			//dbConnection = getDBConnection();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","test", "test");
			Statement stmt = conn.createStatement();

			// execute select SQL statement
			ResultSet rs = stmt.executeQuery(selectSQL);

			while (rs.next()) {

				String configId = rs.getString("CONFIG_ID");
				String nameFile = rs.getString("NAME_FILE");
				String profile = rs.getString("PROFILE");
				String nameDest = rs.getString("NAME_DEST");
				String nameZip = rs.getString("NAME_ZIP");
				Boolean delete = rs.getBoolean("DELETE");
				Integer multiple = rs.getInt("MULTIPLE");
				Integer occurence = rs.getInt("OCCURENCE");
				String comment = rs.getString("COMMENT");
				String listServ = rs.getString("LIST_SERV");
				String release = rs.getString("RELEASE");

				System.out.println("userid : " + configId);
				System.out.println("username : " + nameFile);
				System.out.println("profile : " + profile);
				System.out.println("nameDest : " + nameDest);
				System.out.println("nameZip : " + nameZip);
				System.out.println("delete : " + delete);
				System.out.println("multiple : " + multiple);
				System.out.println("occurence : " + occurence);
				System.out.println("comment : " + comment);
				System.out.println("listServ : " + listServ);
				System.out.println("release : " + release);

			}

		}catch(
		SQLException e)
		{

			System.out.println(e.getMessage());

		}finally
		{

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
		return result;
	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                             DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
	
}
