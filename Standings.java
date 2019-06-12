package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Standings {
	
	private int id;
	private String team;
	private int gamesplayed;
	private int wins;
	private int losses;
	private int scored;
	private int taken;
	private int points;
	
	
	public Standings(int id, String team, int gamesplayed, int wins, int losses, int scored, int taken, int points) {
		
		this.id = id;
		this.team = team;
		this.gamesplayed = gamesplayed;
		this.wins = wins;
		this.losses = losses;
		this.scored = scored;
		this.taken = taken;
		this.points = points;
	}
	
	public int getId() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public int getGamesplayed() {
		return gamesplayed;
	}
	
	public void setGamesplayed(int games_played) {
		this.gamesplayed = gamesplayed;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setwins(int wins) {
		this.wins = wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public void setlosses(int losses) {
		this.losses = losses;
	}
	
	public int getScored() {
		return scored;
	}
	
	public void setscored(int scored) {
		this.scored = scored;
	}
	public int getTaken() {
		return taken;
	}
	
	public void settaken(int taken) {
		this.taken = taken;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setpoints(int points) {
		this.points = points;
	}

	
	public static boolean addStandings(String team, int gamesplayed, int wins, int losses, int scored, int taken, int points) {
		String query = "INSERT INTO standings(team, gamesplayed, wins, losses, scored, taken, points) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, team);
			preparedStatement.setInt(2, gamesplayed);
			preparedStatement.setInt(3, wins);
			preparedStatement.setInt(4, losses);
			preparedStatement.setInt(5, scored);
			preparedStatement.setInt(6, taken);
			preparedStatement.setInt(7, points);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	
	public static boolean updateStandings(int id, String team, int gamesplayed, int wins, int losses, int scored, int taken, int points) {
		String query = "UPDATE standings SET team=?, gamesplayed=?, wins=?, losses=?, scored=?, taken=?, points=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, team);
			preparedStatement.setInt(2, gamesplayed);
			preparedStatement.setInt(3, wins);
			preparedStatement.setInt(4, losses);
			preparedStatement.setInt(5, scored);
			preparedStatement.setInt(6, taken);
			preparedStatement.setInt(7, points);
			preparedStatement.setInt(8, id);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteStandings(int id) {
		String query = "Delete from standings where id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public static List<Standings> getStandings() {
		List<Standings> StandingsList = new ArrayList();
		
		String query = "Select * from standings";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Standings standings = new Standings(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8));
				StandingsList.add(standings);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return StandingsList;
	}}
