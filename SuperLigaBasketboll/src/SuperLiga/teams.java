package SuperLiga;
import java.io.FileInputStream;

import javax.imageio.stream.FileCacheImageOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class teams extends Application
{
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
     
    @Override
    public void start(Stage stage) 
    {   
        // Create the Text Nodes
        Text topText = new Text("");
        Text rightText = new Text("");
        Text bottomText = new Text("");
        Text leftText = new Text("");
        
        VBox teamsList = new VBox();
        
        Button Prishtina = new Button("Prishtina");
        Button Peja = new Button("Peja");
        Button Bashkimi = new Button("Bashkimi");
        Button Rahoveci = new Button("Rahoveci");
        Button Ylli = new Button("Ylli");
        Button Trepca = new Button("Trepca");
        
    
        
        teamsList.getChildren().addAll(Prishtina, Peja, Bashkimi, Rahoveci, Ylli,Trepca);
        
        
        
        
        
        StackPane Content = new StackPane();
        Content.setPadding(new Insets(60, 30, 30, 50));
        
        
        
        Label RandomText = new Label("Superliga e basketbollit: Teams (Ju lutem zgjidhni nje ekip per tu informuar)");
        Content.getChildren().add(RandomText);
        
        
        
        
        
        Prishtina.setOnAction((event) -> {
        	VBox PrishtinaContent = new VBox();
            Content.getChildren().clear();
            Content.getChildren().add(PrishtinaContent);
        	});
        
        
        Peja.setOnAction((event) -> {
        	VBox PejaContent = new VBox();
            Content.getChildren().clear();
            Content.getChildren().add(PejaContent);
        	});
        
        
        
        Bashkimi.setOnAction((event) -> {
        	VBox BashkimiContent = new VBox();
            Content.getChildren().clear();

            Content.getChildren().add(BashkimiContent);
        	});
        
        
        
        Ylli.setOnAction((event) -> {
        	VBox YlliContent = new VBox();
            Content.getChildren().clear();

            Content.getChildren().add(YlliContent);
        	});
        
        
        
        
        Trepca.setOnAction((event) -> {
        	VBox TrepcaContent = new VBox();
            Content.getChildren().clear();

            Content.getChildren().add(TrepcaContent);
        	});
        
        
        
        Rahoveci.setOnAction((event) -> {
        	VBox RahoveciContent = new VBox();
            Content.getChildren().clear();

            Content.getChildren().add(RahoveciContent);
        	});
        
        
        
        
    
        
        
        
        BorderPane.setAlignment(Content,Pos.CENTER);
        
        BorderPane.setAlignment(teamsList,Pos.TOP_LEFT);
        
         
        BorderPane root = new BorderPane(Content, topText, rightText, bottomText, teamsList);
        
        root.setPrefSize(850, 425);     

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();       
    }
}