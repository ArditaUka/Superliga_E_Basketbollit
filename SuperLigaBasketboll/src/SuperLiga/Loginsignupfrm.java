package SuperLiga;






import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;







public class LoginSignup extends Application
{
    
	private Stage window;

	private Connection dbConnection;

	
	/////te login forma//////
	private TextField tfUserName = new TextField();
	private PasswordField tfPass = new PasswordField();


	
	/////te submit forma //////
	private TextField tfFullName1 = new TextField();
	private TextField tfUserName1 = new TextField();
	private TextField tfEmail1 = new TextField();
	private PasswordField tfPass1 = new PasswordField();
	private PasswordField tfCPass1 = new PasswordField();
	
    @Override
    public void start(Stage primaryStage) throws Exception
    {
    	
    	setConnection();
    	
  ////////////////////////////////////////// login ///////////////////////////////////////
    	GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(7); gridPane.setVgap(7);
        gridPane.setAlignment(Pos.CENTER);
        
        
        
        Label headerLabel = new Label("Log In");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
         
         
        
        
        Label lbUserName = new Label("User Name:");
        GridPane.setHalignment(lbUserName, HPos.RIGHT);
         

        
        Label lbPass = new Label("Password:");
        GridPane.setHalignment(lbPass, HPos.RIGHT);
        
        Button lbsignup = new Button("Sign Up");
        gridPane.add(lbsignup, 0, 7,2,1);
        GridPane.setHalignment(lbsignup, HPos.CENTER);
       
         
        

        
        Button submitButton = new Button("LogIn");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        
        
       
        

         
   
         
        gridPane.add(lbUserName, 0, 2); gridPane.add(tfUserName, 1, 2); 
        gridPane.add(lbPass, 0, 4); gridPane.add(tfPass, 1, 4);
        
        

        submitButton.setOnAction(e -> {
			loginUser();
		});
		
		
        
////////////////////////////////////// SIGN UP FORMA ////////////////////////////////////////////////////////

            GridPane gridPane1 = new GridPane();
            gridPane1.setPadding(new Insets(20, 20, 20, 20));
            gridPane1.setHgap(7); gridPane1.setVgap(7);
            gridPane1.setAlignment(Pos.CENTER);
            
            
            
            Label headerLabel1 = new Label("Sign Up");
            headerLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            gridPane1.add(headerLabel1, 0, 0,2,1);
            GridPane.setHalignment(headerLabel1, HPos.CENTER);
            GridPane.setMargin(headerLabel1, new Insets(20, 0,20,0));
             
            
            
            Label lbFullName1 = new Label("Full Name:");
            GridPane.setHalignment(lbFullName1, HPos.RIGHT);
            
            
             
            Label lbUserName1 = new Label("User Name:");
            GridPane.setHalignment(lbUserName1, HPos.RIGHT);
            
            
             
            Label lbEmail1 = new Label("Email:");
            GridPane.setHalignment(lbEmail1, HPos.RIGHT);
            
            
            
            
            Label lbPass1 = new Label("Password:");
            GridPane.setHalignment(lbPass1, HPos.RIGHT);
            
            
            
            
            Label lbCPass1 = new Label("Confirm Password:");
            GridPane.setHalignment(lbCPass1, HPos.RIGHT);

            
            
            Button submitButton1 = new Button("Submit");
            submitButton1.setPrefHeight(40);
            submitButton1.setDefaultButton(true);
            submitButton1.setPrefWidth(100);
            gridPane1.add(submitButton1, 0, 6, 2, 1);
            GridPane.setHalignment(submitButton1, HPos.CENTER);
            GridPane.setMargin(submitButton1, new Insets(20, 0,20,0));
            

             
       
             
            gridPane1.add(lbFullName1, 0, 1); gridPane1.add(tfFullName1, 1, 1);
            gridPane1.add(lbUserName1, 0, 2); gridPane1.add(tfUserName1, 1, 2); 
            gridPane1.add(lbEmail1, 0, 3); gridPane1.add(tfEmail1, 1, 3); 
            gridPane1.add(lbPass1, 0, 4); gridPane1.add(tfPass1, 1, 4);  
            gridPane1.add(lbCPass1, 0, 5); gridPane1.add(tfCPass1, 1, 5); 
            
            
            submitButton1.setOnAction(e -> {
    			signupUser();
    		});
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
      
        ////////////////////////////////////////
    	window = primaryStage;
        Scene scene = new Scene(gridPane, 400, 400 );
        Scene scene1 = new Scene(gridPane1, 400, 400 );
       
        scene.getStylesheets().add("bootstrap3.css");
        lbsignup.setOnAction(e -> window.setScene(scene1));
        scene1.getStylesheets().add("bootstrap3.css");
        
        
        
        

        window.setTitle("Login - User form");
        window.setScene(scene);
        window.show();
        
       
        
    }
 
  

    
    private void setConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/superliga", "root", "");
		} catch (Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText("Can not connect to database");
			alert.showAndWait();
			System.exit(0);
		}
	}
		


    
    private void loginUser() {
		
		try {
			String query = "Select * from users where uname = ? AND password = ?";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			
			preparedStatement.setString(1, tfUserName.getText());
			preparedStatement.setString(2, tfPass.getText());

			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				String sql1="select * from users where uname = '"+tfUserName.getText()+"' and password = '"+tfPass.getText()+"' and userAdmin = 1;";

				PreparedStatement preparedStatement1 = dbConnection.prepareStatement(sql1);
				preparedStatement1.execute();
				ResultSet result1 = preparedStatement1.executeQuery();
				
				

				if(result1.next()) {	
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login result");
				alert.setHeaderText(null);
				alert.setContentText("You are logged in AS ADMINISTRATOR!");
				alert.showAndWait();
				
				window.hide(); // fshef faqen e login
				MainProgram.createMainStage();// shfaq faqen Main Program
				
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login result");
				alert.setHeaderText(null);
				alert.setContentText("You are loged in!");
				alert.showAndWait();	
				
				window.hide(); // fshef faqen e login
				MainProgram.createMainStage();// shfaq faqen Main Program
				}
			}
				
				else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login result");
				alert.setHeaderText(null);
				alert.setContentText("Username or password incorrect!");
				alert.showAndWait();
				
			}
			
		} catch(SQLException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
			System.exit(0);
		}
	}
