package SuperLiga;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage; 
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class Main extends Application 
{ 
  
    Stage window;
    
    private TextField idTxt = new TextField();
	private TextField homeTxt = new TextField();
	private TextField awayTxt = new TextField();
	private TextField timeTxt = new TextField();
	private TextField dateTxt = new TextField();
	
	// Buttons
	private Button insertBtn = new Button("Insert");
	private Button updateBtn = new Button("Update");
	private Button deleteBtn = new Button("Delete");
	private Button clearBtn = new Button("Clear");
	
	private TextField idsTxt = new TextField();
	private TextField teamTxt = new TextField();
	private TextField gamesplayedTxt = new TextField();
	private TextField winsTxt = new TextField();
	private TextField lossesTxt = new TextField();
	private TextField scoredTxt = new TextField();
	private TextField takenTxt = new TextField();
	private TextField pointsTxt = new TextField();
	
	private Button insBtn = new Button("Add");
	private Button updBtn = new Button("Edit");
	private Button delBtn = new Button("Delete");
	private Button clrBtn = new Button("Reset");
	
	
	private TableView StandingsTable = new TableView();
	private TableView gamesTable = new TableView();

	
    public void start(Stage primaryStage) 
    { 
        window = primaryStage;
    	window.setTitle("Superliga e Basketbollit te Kosoves"); 
        Menu m = new Menu("File"); 
        MenuItem exitCmd = new MenuItem("Exit"); 
        
        Menu n = new Menu("Languages"); 
        MenuItem Eng = new MenuItem("Eng"); 
        MenuItem Alb = new MenuItem("Alb"); 
        
        Menu o = new Menu("Help"); 
        MenuItem help = new MenuItem("About"); 
        
        Menu p = new Menu("User"); 
        MenuItem logout = new MenuItem("Log Out"); 
  
        // add menu items to menu 
        m.getItems().add(exitCmd); 
        n.getItems().add(Eng); 
        n.getItems().add(Alb); 
        o.getItems().add(help); 
        p.getItems().add(logout); 
        
        exitCmd.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	window.close();
            }
        });
        
        
        /**
         * Setup KeyCombinations.
         */
        exitCmd.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        Eng.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
        Alb.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        help.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN));
        logout.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.ALT_DOWN));
  
        // create a menubar  
        MenuBar mb = new MenuBar(); 
  
        // add menu to menubar 
        mb.getMenus().addAll(m,n,o,p);
        
        FlowPane root1 = new FlowPane();
        
        Button btn1 = new Button("Results");
        Button btn2 = new Button("Standings");
        Button btn3 = new Button("Teams");
        
        root1.getChildren().addAll(btn1,btn2,btn3);
        
                
        root1.setPadding(new Insets(4,5,2,0));
        
        root1.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,
                CornerRadii.EMPTY, new BorderWidths(1), Insets.EMPTY)));   
           
        
        
        
        GridPane formPane = new GridPane();
		
		formPane.addRow(0, new Label("ID: "), idTxt);
		formPane.addRow(1, new Label("Home: "), homeTxt);
		formPane.addRow(2, new Label("Away: "), awayTxt);
		formPane.addRow(3, new Label("Time: "), timeTxt);
		formPane.addRow(4, new Label("Date: "), dateTxt);
		
		formPane.setHgap(30);
		formPane.setVgap(30);
		
		idTxt.setDisable(true);
		
		// Buttons pane
		HBox buttonsPane = new HBox(10);
		
		buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn);
		
		insertBtn.setOnAction(e -> {
			insertGame();
		});
		
		clearBtn.setOnAction(e -> {
			clearForm();
		});
		
		deleteBtn.setOnAction( e -> {
			deleteGame();
		});
		
		updateBtn.setOnAction( e -> {
			updateGame();
		});
		
		// Left Pane
		
		VBox leftPane = new VBox(15);
		
		leftPane.getChildren().addAll(formPane, buttonsPane);
		
		TableColumn<String, UpComings> cl1 = new TableColumn<>("ID");
		cl1.setCellValueFactory(new PropertyValueFactory("id"));
		cl1.setPrefWidth(80);
		
		TableColumn<String, UpComings> cl2 = new TableColumn<>("Home");
		cl2.setCellValueFactory(new PropertyValueFactory("home"));
		cl2.setPrefWidth(150);
		
		TableColumn<String, UpComings> cl3 = new TableColumn<>("Away");
		cl3.setCellValueFactory(new PropertyValueFactory("away"));
		cl3.setPrefWidth(150);
		
		TableColumn<String, UpComings> cl4 = new TableColumn<>("Time");
		cl4.setCellValueFactory(new PropertyValueFactory("time"));
		cl4.setPrefWidth(120);
		
		TableColumn<String, UpComings> cl5 = new TableColumn<>("Date");
		cl5.setCellValueFactory(new PropertyValueFactory("date"));
		cl5.setPrefWidth(120);
		
		gamesTable.setRowFactory(vt -> {
            TableRow<UpComings> row = new TableRow<>();
            
            row.setOnMouseClicked(event -> {
               idTxt.setText( String.valueOf(row.getItem().getId()));
               homeTxt.setText(row.getItem().getHome());
               awayTxt.setText(row.getItem().getAway());
               timeTxt.setText(row.getItem().getTime());
               dateTxt.setText(row.getItem().getDate());
            });
            
            return row ;
        });
		
		gamesTable.getColumns().add(cl1);
		gamesTable.getColumns().add(cl2);
		gamesTable.getColumns().add(cl3);
		gamesTable.getColumns().add(cl4);
		gamesTable.getColumns().add(cl5);
		
		gamesTable.setPrefWidth(650);
		gamesTable.setPrefHeight(500);
		
		// Main Pane
		HBox mainPane = new HBox(20);
		
		mainPane.getChildren().addAll(leftPane, gamesTable);
		
		mainPane.setPadding(new Insets(20, 20, 20 ,20));
		
		
		
		GridPane frmPane = new GridPane();
		
		frmPane.addRow(0, new Label("Id: "), idsTxt);
		frmPane.addRow(1, new Label("Team: "), teamTxt);
		frmPane.addRow(2, new Label("Games played: "), gamesplayedTxt);
		frmPane.addRow(3, new Label("Wins: "), winsTxt);
		frmPane.addRow(4, new Label("Losses: "), lossesTxt);
		frmPane.addRow(5, new Label("Scored: "), scoredTxt);
		frmPane.addRow(6, new Label("Taken: "), takenTxt);
		frmPane.addRow(7, new Label("Points: "), pointsTxt);
		
		frmPane.setHgap(10);
		frmPane.setVgap(10);
		
		idsTxt.setDisable(true);
		
		// Buttons pane
		HBox buttonPane = new HBox(10);
		
		buttonPane.getChildren().addAll(insBtn, updBtn, delBtn, clrBtn);
		
		insBtn.setOnAction(e -> {
			insertStandings();
		});
		
		clrBtn.setOnAction(e -> {
			clearForm();
		});
		
		delBtn.setOnAction( e -> {
			deleteStandings();
		});
		
		updBtn.setOnAction( e -> {
			updateStandings();
		});
		
		// Left Pane
		
		VBox lftPane = new VBox(15);
		
		lftPane.getChildren().addAll(formPane, buttonPane);
		
		
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
               idsTxt.setText( String.valueOf(row.getItem().getId()));
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
		HBox mP = new HBox(10);
		
		mP.getChildren().addAll(lftPane, StandingsTable);
		
		mP.setPadding(new Insets(15, 15, 15 ,15));
		
		
		Scene scene = new Scene(mP, 1500, 700);
		
		
		window.setScene(scene);
		
		showStandings();
		btn2.setOnAction(e->window.setScene(scene));
		
		
        VBox sc1 = new VBox(mb,root1,mainPane);
        Scene results = new Scene(sc1, 1500, 700);
        
                
        btn1.setOnAction(e-> window.setScene(results));
        showGames();
        window.setScene(results); 
        window.show(); 
    } 
    
  
    public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
    
    public void showGames() {
		List<UpComings> up = UpComings.getGames();
		
		ObservableList<UpComings> upList = FXCollections.observableArrayList();
		
		for(int i = 0; i < up.size(); i++) {
			upList.add(up.get(i));
		}
		
		gamesTable.setItems(upList);
	}
	
	public void insertGame() {
		
		if(UpComings.addGame(homeTxt.getText(), awayTxt.getText(), timeTxt.getText(), dateTxt.getText())) {
			showGames();
			clearForm();
		}
	}
	
	public void deleteGame() {
		if(UpComings.deleteGame(Integer.parseInt(idTxt.getText()))) {
			showGames();
			clearForm();
		}
	}
	
	
	public void updateGame() {
		if(UpComings.updateGame(Integer.parseInt(idTxt.getText()), homeTxt.getText(), awayTxt.getText(), timeTxt.getText(), dateTxt.getText() )) {
			showGames();
			clearForm();
		}
	}
	
	public void clearForm() {
		idTxt.setText("");
		homeTxt.setText("");
		awayTxt.setText("");
		timeTxt.setText("");
		dateTxt.setText("");
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
			clrForm();
		}
	}
	
	public void deleteStandings() {
		if(Standings.deleteStandings(Integer.parseInt(idsTxt.getText()))) {
			showStandings();
			clrForm();
		}
	}
	
	
	public void updateStandings() {
		if(Standings.updateStandings(Integer.parseInt(idsTxt.getText()), teamTxt.getText(), Integer.parseInt(gamesplayedTxt.getText()), Integer.parseInt(winsTxt.getText()), Integer.parseInt(lossesTxt.getText()), Integer.parseInt(scoredTxt.getText()), Integer.parseInt(takenTxt.getText()), Integer.parseInt(pointsTxt.getText())))   {
			showStandings();
			clrForm();
		}
	}
	
	public void clrForm() {
		idsTxt.setText("");
		teamTxt.setText("");
		gamesplayedTxt.setText("");
		winsTxt.setText("");
		lossesTxt.setText("");
		scoredTxt.setText("");
		takenTxt.setText("");
		pointsTxt.setText("");
	}
} 
