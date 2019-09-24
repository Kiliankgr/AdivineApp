package dad.javafx.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application{
	
	private TextField numeroText;
	private Button comprobarButton;
	private Label mensajeLabel;
	private int aleatorio=(int)(Math.random()*100)+1;
	private int contador=0;
	public void start(Stage primaryStage) throws Exception {
		
		numeroText = new TextField();
		numeroText.setPromptText("Escribe el numero aquí" );
		numeroText.setMaxWidth(150);
		
		mensajeLabel=new Label("Introduce un número del 1 al 100");
		comprobarButton =new Button("comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> onResultadoButtonAction(e));
		
		VBox root =new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(mensajeLabel,numeroText,comprobarButton);
		
		Scene scene=new Scene(root,320,200);
		primaryStage.setTitle("AdivineApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
			
	}
	private void onResultadoButtonAction(ActionEvent e) {
		int resultado=0;
		Alert mensaje;
		try {
			resultado = Integer.parseInt(numeroText.getText());
			
			if(resultado==aleatorio) {
				mensaje=new Alert(AlertType.INFORMATION);
				mensaje.setTitle(null);
				mensaje.setHeaderText("¡Has ganado!");
				mensaje.setContentText(String.format("Solo has necesitado "+contador+" intentos"+'\n'+'\n'+"Vuelve a jugar y hazlo mejor"));
				contador=0;
				mensaje.showAndWait();

			}else {
				mensaje=new Alert(AlertType.WARNING);
				mensaje.setTitle(null);
				mensaje.setHeaderText("¡Has fallado!");
				if(resultado<aleatorio) {
				mensaje.setContentText(String.format("El número es mayor"+'\n'+'\n'+"Vuelve a intentarlo"));
				
				}else {
					mensaje.setContentText(String.format("El número es menor"+'\n'+'\n'+"Vuelve a intentarlo"));
				}
				mensaje.showAndWait();

			}
		} catch (NumberFormatException e1) {
			mensaje=new Alert(AlertType.ERROR);
			mensaje.setTitle(null);
			mensaje.setHeaderText("Error");
			mensaje.setContentText("El número introducido no es válido");
			mensaje.showAndWait();
			
		}
		contador++;
		
	
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
