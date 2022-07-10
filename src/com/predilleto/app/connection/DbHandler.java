package com.predilleto.app.connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DbHandler {
	private String url, user, password;
	private Connection connection;

	public DbHandler() {

		url = "jdbc:postgresql://localhost:5432/postgres";
		user = "postgres";
		password = "32659345";

		try {

			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Succeed");

		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public String getTitle(String filepath) {
		try {
			String sql = "Select title " + "From songs " + "Where filepath=" + "'" + filepath + "'";
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			String title = rs.getString("title");
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}

	public String getArtist(String filepath) {
		try {
			String sql = "Select artist " + "From songs " + "Where filepath=" + "'" + filepath + "'";
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			String title = rs.getString("artist");
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}

	public String getGenre(String filepath) {
		try {
			String sql = "Select genre " + "From songs " + "Where filepath=" + "'" + filepath + "'";
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			String genre = rs.getString("genre");
			return genre;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}

}
