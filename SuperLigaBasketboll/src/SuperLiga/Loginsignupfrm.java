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