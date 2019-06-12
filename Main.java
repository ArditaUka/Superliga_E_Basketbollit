package application;

import java.sql.*;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {


	private TextField idTxt = new TextField();
	private TextField teamTxt = new TextField();
	private TextField gamesplayedTxt = new TextField();
	private TextField winsTxt = new TextField();
	private TextField lossesTxt = new TextField();
	private TextField scoredTxt = new TextField();
	private TextField takenTxt = new TextField();
	private TextField pointsTxt = new TextField();
	
	
	private Button insertBtn = new Button("Add");
	private Button updateBtn = new Button("Edit");
	private Button deleteBtn = new Button("Delete");
	private Button clearBtn = new Button("Reset");
	
	
	private TableView StandingsTable = new TableView();
	
	
	public void start(Stage primaryStage) {
		
		// Form pane
		GridPane formPane = new GridPane();
		
		formPane.addRow(0, new Label("Id: "), idTxt);
		formPane.addRow(1, new Label("Team: "), teamTxt);
		formPane.addRow(2, new Label("Games played: "), gamesplayedTxt);
		formPane.addRow(3, new Label("Wins: "), winsTxt);
		formPane.addRow(4, new Label("Losses: "), lossesTxt);
		formPane.addRow(5, new Label("Scored: "), scoredTxt);
		formPane.addRow(6, new Label("Taken: "), takenTxt);
		formPane.addRow(7, new Label("Points: "), pointsTxt);
		
		formPane.setHgap(10);
		formPane.setVgap(10);
		
		idTxt.setDisable(true);
		
		// Buttons pane
		HBox buttonsPane = new HBox(10);
		
		buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn);
		
		insertBtn.setOnAction(e -> {
			insertStandings();
		});
		
		clearBtn.setOnAction(e -> {
			clearForm();
		});
		
		deleteBtn.setOnAction( e -> {
			deleteStandings();
		});
		
		updateBtn.setOnAction( e -> {
			updateStandings();
		});
		
		// Left Pane
		
		VBox leftPane = new VBox(15);
		
		leftPane.getChildren().addAll(formPane, buttonsPane);
		
		
		// Books table
		
		TableColumn<String, Standings> column1 = new TableColumn<>("Id");
		column1.setCellValueFactory(new PropertyValueFactory("id"));
		column1.setPrefWidth(50);
		
		TableColumn<String, Standings> column2 = new TableColumn<>("Team");
		column2.setCellValueFactory(new PropertyValueFactory("team"));
		column2.setPrefWidth(200);
		
		TableColumn<String, Standings> column3 = new TableColumn<>("Games Played");
		column3.setCellValueFactory(new PropertyValueFactory("gamesplayed"));
		column3.setPrefWidth(100);
		
		TableColumn<String, Standings> column4 = new TableColumn<>("Wins");
		column4.setCellValueFactory(new PropertyValueFactory("wins"));
		column4.setPrefWidth(60);
		
		TableColumn<String, Standings> column5 = new TableColumn<>("Losses");
		column5.setCellValueFactory(new PropertyValueFactory("losses"));
		column5.setPrefWidth(60);
		
		TableColumn<String, Standings> column6 = new TableColumn<>("Scored");
		column6.setCellValueFactory(new PropertyValueFactory("scored"));
		column6.setPrefWidth(60);
		
		TableColumn<String, Standings> column7 = new TableColumn<>("Taken");
		column7.setCellValueFactory(new PropertyValueFactory("taken"));
		column7.setPrefWidth(60);
		
		TableColumn<String, Standings> column8 = new TableColumn<>("Points");
		column8.setCellValueFactory(new PropertyValueFactory("points"));
		column8.setPrefWidth(60);
		
		StandingsTable.setRowFactory(tv -> {
            TableRow<Standings> row = new TableRow<>();
            
            row.setOnMouseClicked(event -> {
               idTxt.setText( String.valueOf(row.getItem().getId()));
               teamTxt.setText(row.getItem().getTeam());
               gamesplayedTxt.setText(String.valueOf(row.getItem().getGamesplayed()));
               winsTxt.setText(String.valueOf(row.getItem().getWins()));
               lossesTxt.setText( String.valueOf(row.getItem().getLosses()));
               scoredTxt.setText( String.valueOf(row.getItem().getScored()));
               takenTxt.setText( String.valueOf(row.getItem().getTaken()));
               pointsTxt.setText( String.valueOf(row.getItem().getPoints()));
               
            });
            
            return row ;
        });
		
		StandingsTable.getColumns().add(column1);
		StandingsTable.getColumns().add(column2);
		StandingsTable.getColumns().add(column3);
		StandingsTable.getColumns().add(column4);
		StandingsTable.getColumns().add(column5);
		StandingsTable.getColumns().add(column6);
		StandingsTable.getColumns().add(column7);
		StandingsTable.getColumns().add(column8);
		
		StandingsTable.setPrefWidth(650);
		StandingsTable.setPrefHeight(200);
		
		// Main Pane
		HBox mainPane = new HBox(10);
		
		mainPane.getChildren().addAll(leftPane, StandingsTable);
		
		mainPane.setPadding(new Insets(15, 15, 15 ,15));
		
		
		Scene scene = new Scene(mainPane, 1000, 400);
		
		primaryStage.setTitle("Superliga e Basketbollit te Kosoves");
		primaryStage.setScene(scene);
		
		showStandings();
		
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void showStandings() {
		List<Standings> standings = Standings.getStandings();
		
		ObservableList<Standings> StandingsList = FXCollections.observableArrayList();
		
		for(int i = 0; i < standings.size(); i++) {
			StandingsList.add(standings.get(i));
		}
		
		StandingsTable.setItems(StandingsList);
	}
	
	public void insertStandings() {
		
		if(Standings.addStandings(teamTxt.getText(), Integer.parseInt(gamesplayedTxt.getText()), Integer.parseInt(winsTxt.getText()), Integer.parseInt(lossesTxt.getText()), Integer.parseInt(scoredTxt.getText()), Integer.parseInt(takenTxt.getText()), Integer.parseInt(pointsTxt.getText()))) {
			showStandings();
			clearForm();
		}
	}
	
	public void deleteStandings() {
		if(Standings.deleteStandings(Integer.parseInt(idTxt.getText()))) {
			showStandings();
			clearForm();
		}
	}
	
	
	public void updateStandings() {
		if(Standings.updateStandings(Integer.parseInt(idTxt.getText()), teamTxt.getText(), Integer.parseInt(gamesplayedTxt.getText()), Integer.parseInt(winsTxt.getText()), Integer.parseInt(lossesTxt.getText()), Integer.parseInt(scoredTxt.getText()), Integer.parseInt(takenTxt.getText()), Integer.parseInt(pointsTxt.getText())))   {
			showStandings();
			clearForm();
		}
	}
	
	public void clearForm() {
		idTxt.setText("");
		teamTxt.setText("");
		gamesplayedTxt.setText("");
		winsTxt.setText("");
		lossesTxt.setText("");
		scoredTxt.setText("");
		takenTxt.setText("");
		pointsTxt.setText("");
	}
	
}