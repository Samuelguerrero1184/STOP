package cont;

import java.io.IOException;

import com.google.gson.Gson;

import comm.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;
import model.Game;
import model.Message;

public class VentanaB {

	private Stage stage;

	private Game game;

	public Session session;

	@FXML
	private Label ownNameResult;

	@FXML
	private Label opponentNameResult;

	@FXML
	private Label myAnimalResult;

	@FXML
	private Label opponentAnimalResult;

	@FXML
	private Label ownLocationResult;

	@FXML
	private Label opponentLocationResult;

	@FXML
	private Label ownObjectResult;

	@FXML
	private Label opponentObjectResult;

	@FXML
	private TextField txtMyPoints;

	@FXML
	private TextField txtYourPoints;

	@FXML
	private Button finishBtn;

	public VentanaB(Game game, Stage stage, Session session) {

		this.game = game;
		this.stage = stage;
		this.session = session;

	}

	@FXML
	public void finishGame(MouseEvent event) {

		Message m = new Message("Finish");
		Gson gson = new Gson();
		String msg = gson.toJson(m);

	}

	public void updateScreen() {

		FXMLLoader fxmlA = new FXMLLoader(getClass().getResource("Ventana2.fxml"));

		Parent loadingPane;
		try {
			fxmlA.setController(this);
			loadingPane = (Parent) fxmlA.load();
			Scene scene = new Scene(loadingPane);

			stage.setScene(scene);
			stage.show();
			game.calculatePoints();

			ownNameResult.setText(game.getMyAnswer().getName() + " (" + game.getMyNamePoints() + ")");
			myAnimalResult.setText(game.getMyAnswer().getAnimal() + " (" + game.getMyAnimalPoints() + ")");
			ownLocationResult.setText(game.getMyAnswer().getLocation() + " (" + game.getMyLocationPoints() + ")");
			ownObjectResult.setText(game.getMyAnswer().getObject() + " (" + game.getMyObjectPoint() + ")");

			opponentAnimalResult.setText(game.getYourAnswer().getAnimal() + " (" + game.getYourAnimalPoints() + ")");
			opponentNameResult.setText(game.getYourAnswer().getName() + " (" + game.getYourNamePoints() + ")");
			opponentLocationResult
					.setText(game.getYourAnswer().getLocation() + " (" + game.getYourLocationPoints() + ")");
			opponentObjectResult.setText(game.getYourAnswer().getObject() + " (" + game.getYourObjectPoints() + ")");

			txtMyPoints.setText(String.valueOf(game.getMyPoints()));
			txtYourPoints.setText(String.valueOf(game.getYourPoints()));

			if (game.getMyPoints() > game.getYourPoints()) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("WINNER");

				alert.setContentText("Felicidades, Ganaste!");
				alert.showAndWait();
			} else if (game.getMyPoints() < game.getYourPoints()) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("LOSER");
				alert.setContentText("Lo siento, Perdiste :(");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("NOT WINNER. BUT NOT LOSER");
				alert.setContentText("Empate!");
				alert.showAndWait();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}