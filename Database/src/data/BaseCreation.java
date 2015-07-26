package data;

import java.sql.*;

public class BaseCreation {
	public static void main(String[] args) throws ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/";
		String name = "root";
		String password = "root";
		String dbname = "test1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Драйвер подключен");
			Connection con = null;
			System.out.println("Connecting");
			con = DriverManager.getConnection(url, name, password);

			Statement statement = null;
			statement = con.createStatement();
			String sql = "CREATE DATABASE IF NOT EXISTS " + dbname;
			statement.executeUpdate(sql);
			statement = con.createStatement();
			System.out.println("Reconnecting");
			con = DriverManager.getConnection(url + dbname, name, password);
			statement = con.createStatement();
			System.out.println("Creating table 'School' ");
			sql = "CREATE TABLE IF NOT EXISTS School "
					+ "(id_sch INTEGER NOT NULL AUTO_INCREMENT, "
					+ " number INTEGER, " + " adress VARCHAR(255), "
					+ " PRIMARY KEY ( id_sch ))";
			statement.executeUpdate(sql);

			statement = con.createStatement();
			System.out.println("Creating table 'Pupil' ");
			sql = "CREATE TABLE IF NOT EXISTS Pupil "
					+ "(id_pupil INTEGER NOT NULL AUTO_INCREMENT, "
					+ " name VARCHAR(255), " + " age INTEGER, "
					+ " clas VARCHAR(255), " + " PRIMARY KEY ( id_pupil ))";
			statement.executeUpdate(sql);
			System.out.println("Inserting data to School");
			statement = con.createStatement();
			sql = "INSERT INTO School(number,adress) "
					+ "VALUES (3, 'Kirova 19')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO School(number,adress) "
					+ "VALUES (4, 'Kleckova 129')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO School(number,adress) "
					+ "VALUES (5, 'pr.Kupaly 11')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO School(number,adress) "
					+ "VALUES (2, 'Gogolia 41')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO School(number,adress) "
					+ "VALUES (1, 'Dubko 34')";
			statement.executeUpdate(sql);

			System.out.println("Inserting data to Pupil");
			sql = "INSERT INTO Pupil(name,age,clas) "
					+ "VALUES ('Petrov', 11, 'Third')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Pupil(name,age,clas) "
					+ "VALUES ('Ivanov', 10, 'Second')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Pupil(name,age,clas) "
					+ "VALUES ('Martiniyk', 14, 'Fourth')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Pupil(name,age,clas) "
					+ "VALUES ('Tcimbalo', 14, 'Fifth')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Pupil(name,age,clas) "
					+ "VALUES ('Bobrov', 11, 'Third')";
			statement.executeUpdate(sql);

			System.out.println("..From first table...");
			sql = "SELECT * FROM School";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				System.out.print("ID: " + rs.getInt("id_sch")+"/n");
				System.out.print(", Age: " + rs.getInt("number"));
				System.out.print(", Adress: " + rs.getString("adress"));
			}
			System.out.println("..From second table...");

			sql = "SELECT * FROM Pupil";

			while (rs.next()) {
				while (rs.next()) {
					System.out.print("ID: " + rs.getInt("id_pupil")+"/n");
					System.out.print(", Age: " + rs.getInt("age"));
					System.out.print(", Name: " + rs.getInt("name"));
					System.out.print(", First: " + rs.getString("clas"));
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
