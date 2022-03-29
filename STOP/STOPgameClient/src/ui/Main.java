package ui;

import java.io.IOException;

import com.google.gson.Gson;

import comm.Session;
import cont.VentanaA;
import events.OnMessageRecieved;
import events.OnSendMessage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import model.*;
import javafx.scene.*;

public class Main extends Application implements OnMessageRecieved, OnSendMessage {

    public static Stage stage;
    public static Session session;

    public Main() {
        session = Session.getInstance();
        session.setMessageRecieved(this);

    }

    public static void main(String[] args) {
        new Main();
        session.start();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        onConnection();
    }

    public void readMessage() {
        session.readMessage();

    }

    public void onConnection() {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
        Parent root;
        try {
            root = fxmlloader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            readMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onMessageRecieved(String msg) {
        msg = session.getMsg();
        System.out.println(msg);
        Gson gson = new Gson();
        Generic g = gson.fromJson(msg, Generic.class);
        if (g != null) {
            switch (g.getType()) {
                case "Message":
                    Message m = gson.fromJson(msg, Message.class);
                    String j = m.getMessage();
                    Platform.runLater(() -> {
                        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("VentanaA.fxml"));
                        Parent root;
                        try {
                            VentanaA ventanaA = new VentanaA();
                            ventanaA.setOsm(this);
                            fxmlloader.setController(ventanaA);
                            root = (Parent) fxmlloader.load();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            ventanaA.letraLabel.setText(j);
                            stage.show();
                            readMessage();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            }

        } else {
            System.out.println("nulo");
        }
    }

    @Override
    public void onSendMessage(String msg) {
        session.sendMessage(msg);
    }

}