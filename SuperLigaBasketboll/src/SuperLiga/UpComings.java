package SuperLiga;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpComings {
	
	private int id;
	private String home;
	private String away;
	private String time;
	private String date;
	
	
	public UpComings(int id,String home, String away, String time, String date) 
	{
		this.id = id;
		this.home = home;
		this.away = away;
		this.time = time;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHome() {
		return home;
	}
	
	public void setHome(String home) {
		this.home = home;
	}
	
	public String getAway() {
		return away;
	}
	
	public void setAway(String away) {
		this.away = away;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public static boolean addGame(String home, String away, String time, String date) {
		String query = "INSERT INTO upcoming(home, away, time, date) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, home);
			preparedStatement.setString(2, away);
			preparedStatement.setString(3, time);
			preparedStatement.setString(4, date);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	
	public static boolean updateGame(int id,String home, String away, String time, String date) {
		String query = "UPDATE upcoming SET home=?, away=?, time=?, date=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, home);
			preparedStatement.setString(2, away);
			preparedStatement.setString(3, time);
			preparedStatement.setString(4, date);
			preparedStatement.setInt(5, id);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteGame(int id) {
		String query = "Delete from upcoming where id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static List<UpComings> getGames() {
		List<UpComings> upList = new ArrayList();
		
		String query = "Select * from upcoming";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				UpComings up = new UpComings(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				upList.add(up);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return upList;
	}
	
	

}
