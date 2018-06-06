package passwordgenerator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PasswordGenerator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Button btn = new Button();
        btn.setText("Generate");
        btn.setMaxSize(90, 30);
        
        TextArea text = new TextArea();
        text.setMaxSize(110, 10);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                text.clear();
                Generator gntr = new Generator();
                text.appendText(gntr.getPassword().toString());
            }
        });
        
        
        FlowPane root = new FlowPane();
        root.getChildren().add(btn);
        root.setAlignment(Pos.CENTER);
        root.setVgap(5);
        root.setHgap(5);
        
        root.getChildren().add(text);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 570, 285);
        primaryStage.setResizable(false);
        scene.getStylesheets().add(passwordgenerator.PasswordGenerator.class.getResource("CascadeSS.css").toExternalForm());
        
        primaryStage.setTitle("Password Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
