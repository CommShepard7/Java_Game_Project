package MiniJeux.application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Race extends Application{
	
	public static void main(String[] args) 
    {
        launch(args);
    }

	@Override
	public void start(Stage s) throws Exception {
		s.setTitle("Go to the finish line!");
		
		Group root = new Group();
		Scene scene  = new Scene(root);
		s.setScene(scene);
		
		Image background = new Image("underwater2.jpg");
		Image radeau = new Image("radeau2.png");
		Image fin = new Image("drapeau.png");
		
		Canvas canvas = new Canvas(background.getWidth(), background.getHeight());
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D(); 
		IntValue avance = new IntValue(20);
		final int arrivee = 550;
		
		scene.setOnKeyReleased(
			new EventHandler<KeyEvent>() {
				public void handle(KeyEvent e) {
					if(e.getCode() == KeyCode.RIGHT ) {
						if( avance.value < arrivee) {
							avance.value += 10;
						}else {
							Alert alert  = new Alert(AlertType.NONE, "Vous avez gagn�!", ButtonType.CLOSE);
							alert.showAndWait();
							s.close();
						}
					}
				}
			}	
		);
		
		new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				gc.drawImage(background, 0,0);
				gc.drawImage(radeau, avance.value, 230);
				gc.drawImage(fin, arrivee, 200);
				
			}
		}.start();
		
		s.show();
		
	}


}
