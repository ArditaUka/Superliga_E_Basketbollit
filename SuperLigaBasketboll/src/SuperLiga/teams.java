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
        teamsList.setPrefWidth(100);
        
        Button Prishtina = new Button("Prishtina");
        Button Peja = new Button("Peja");
        Button Bashkimi = new Button("Bashkimi");
        Button Rahoveci = new Button("Rahoveci");
        Button Ylli = new Button("Ylli");
        Button Trepca = new Button("Trepca");
        
        
        Prishtina.setMinWidth(teamsList.getPrefWidth());
        Peja.setMinWidth(teamsList.getPrefWidth());
        Bashkimi.setMinWidth(teamsList.getPrefWidth());
        Rahoveci.setMinWidth(teamsList.getPrefWidth());
        Ylli.setMinWidth(teamsList.getPrefWidth());
        Trepca.setMinWidth(teamsList.getPrefWidth());
        
        
        
        teamsList.getChildren().addAll(Prishtina, Peja, Bashkimi, Rahoveci, Ylli,Trepca);
        
        
        
        
        
        StackPane Content = new StackPane();
        Content.setPadding(new Insets(60, 30, 30, 50));
        
        
        
        Label RandomText = new Label("Superliga e basketbollit: Teams (Ju lutem zgjidhni nje ekip per tu informuar)");
        Content.getChildren().add(RandomText);
        
        
        
        
        
        Prishtina.setOnAction((event) -> {
        	VBox PrishtinaContent = new VBox();
            Content.getChildren().clear();
            
            HBox PrishtinaStartingRoster = new HBox();
            
            Label StartingTeam = new Label("Starting team :");
            Label Anderson 	= new Label("[ Kyan Anderson, ");
            Label Azemi		= new Label(" Edmond Azemi, ");
            Label Berisha	= new Label(" Dardan Berisha, ");
            Label Boukichou	= new Label(" Khalid Boukichou, ");
            Label Rugova	= new Label(" Fisnik Rugova ]");
            
            PrishtinaStartingRoster.getChildren().addAll(StartingTeam, Anderson, Azemi, Berisha, Boukichou, Rugova);
            

            
            Label Balance = new Label("Balance this Year: 70:10");
            
            Label PrishtinaCoach = new Label("Coach: Damir Mulaomerovic");
            Label PrishtinaColors = new Label("Colors: Bardhe, Kalter");
            PrishtinaContent.getChildren().add(PrishtinaStartingRoster);
            PrishtinaContent.getChildren().add(Balance);
            PrishtinaContent.getChildren().add(PrishtinaColors);
            PrishtinaContent.getChildren().add(PrishtinaColors);
            Content.getChildren().add(PrishtinaContent);
        	});
        
        
        Peja.setOnAction((event) -> {
        	VBox PejaContent = new VBox();
            Content.getChildren().clear();
            
            HBox PejaStartingRoster = new HBox();
            Label StartingTeam = new Label("Starting team :");
            Label Albin 	= new Label("[ Albin Berisha, ");
            Label Ermal		= new Label(" Ermal Bojku, ");
            Label Arditi	= new Label(" Ardit Demaj, ");
            Label Edonisi	= new Label(" Edonis Devolli, ");
            Label Taulanti	= new Label(" Taulant Dupa ]");
            
            PejaStartingRoster.getChildren().addAll(StartingTeam, Albin, Ermal, Arditi, Edonisi, Taulanti);
            
            Label PejaCoach = new Label("Coach: Aleksandar Todorov");
            Label PejaBalance = new Label("Balance this Year: 40:40");
            Label PejaColors = new Label("Colors: Verdhe, Zi");
            
            
            PejaContent.getChildren().addAll(PejaStartingRoster,PejaBalance,PejaCoach,PejaColors);
            Content.getChildren().add(PejaContent);
        	});
        
        
        
        Bashkimi.setOnAction((event) -> {
        	VBox BashkimiContent = new VBox();
            Content.getChildren().clear();
            
            HBox BashkimiStartingRoster = new HBox();
            Label StartingTeam = new Label("Starting team :");
            Label qbiraj 	= new Label("[ Qendrim Biraj, ");
            Label ygashi		= new Label(" Ylli Gashi, ");
            Label jcapps	= new Label(" Jordan Capps, ");
            Label dhajrizi	= new Label(" Drilon Hajrizi, ");
            Label agorski	= new Label(" Alexander Gorski ]");
            
            BashkimiStartingRoster.getChildren().addAll(StartingTeam, qbiraj, ygashi, jcapps, dhajrizi, agorski);
            
            Label BashkimiCoach = new Label("Coach: Jeremino Sarin");
            Label BashkimiColors = new Label("Colors: Portokalli, Zi");

            Label BashkkimiBalance = new Label("Balance this Year: 50:30");
            BashkimiContent.getChildren().addAll(BashkimiStartingRoster,BashkkimiBalance,BashkimiCoach,BashkimiColors);
            Content.getChildren().add(BashkimiContent);
        	});
        
        
        
        Ylli.setOnAction((event) -> {
        	VBox YlliContent = new VBox();
            Content.getChildren().clear();
            
            HBox YlliStartingRoster = new HBox();
            Label StartingTeam = new Label("Starting team :");
            Label garifaj 	= new Label("[ Getoar Arifaj, ");
            Label rbanks		= new Label(" Romelo Banks, ");
            Label eelshani	= new Label(" Endrit Elshani, ");
            Label teverett	= new Label(" Terrell Everett, ");
            Label agashi	= new Label(" Artin Gashi ]");
            
            YlliStartingRoster.getChildren().addAll(StartingTeam, garifaj, rbanks, eelshani, teverett, agashi);
            
            Label YlliCoach = new Label("Coach: Agron Berisha");
            Label YlliColors = new Label("Colors: Portokalli, Verdhe");
            Label YlliBalance = new Label("Balance this Year: 64:16");
            
            YlliContent.getChildren().addAll(YlliStartingRoster,YlliBalance,YlliCoach,YlliColors);
            Content.getChildren().add(YlliContent);
        	});
        
        
        
        
        Trepca.setOnAction((event) -> {
        	VBox TrepcaContent = new VBox();
            Content.getChildren().clear();
            
            HBox TrepcaStartingRoster = new HBox();
            Label StartingTeam = new Label("Starting team :");
            Label aanderson 	= new Label("[ Aaron Anderson, ");
            Label bazemi		= new Label(" Besnik Azemi, ");
            Label kbaker	= new Label(" Kevin Baker, ");
            Label shchurch	= new Label(" Shawn Church, ");
            Label ddeliqi	= new Label(" Deart Deliqi ]");
            
            TrepcaStartingRoster.getChildren().addAll(StartingTeam, aanderson, bazemi, kbaker, shchurch, ddeliqi);
            
            Label TrepcaCoach = new Label("Coach: Ilir Selmani");
            Label TrepcaColors = new Label("Colors: Gjelber, Zi, Bardh");
            
            Label TrepcaBalance = new Label("Balance this Year: 20:60");
            TrepcaContent.getChildren().addAll(TrepcaStartingRoster,TrepcaBalance,TrepcaCoach,TrepcaColors);
            Content.getChildren().add(TrepcaContent);
        	});
        
        
        
        Rahoveci.setOnAction((event) -> {
        	VBox RahoveciContent = new VBox();
            Content.getChildren().clear();
            
            HBox RahoveciStartingRoster = new HBox();
            Label StartingTeam = new Label("Starting team :");
            Label aballuku 	= new Label("[ Arion Balluku	, ");
            Label vejupi		= new Label(" Visar Ejupi, ");
            Label fgoldstein	= new Label(" Freddie Goldstein, ");
            Label rgrapci	= new Label(" Rron Grapci, ");
            Label fjuniku	= new Label(" Fisnik Juniku ]");
            
            RahoveciStartingRoster.getChildren().addAll(StartingTeam, aballuku, vejupi, fgoldstein, rgrapci, fjuniku);
            
            Label RahoveciCoach = new Label("Coach: Bujar Loci");
            Label RahoveciColors = new Label("Colors: Bardhe, Kalter");
            Label RahoveciBalance = new Label("Balance this Year: 55:25");
            RahoveciContent.getChildren().addAll(RahoveciStartingRoster,RahoveciBalance,RahoveciCoach,RahoveciColors);
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