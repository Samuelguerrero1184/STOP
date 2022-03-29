package comm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import events.OnMessageRecieved;
import javafx.application.Platform;

public class Session extends Thread{

   
    private static Session instance;
    private String ip = "192.168.1.19";
    private int port = 6000;
    private Socket socket;
    private BufferedWriter bw;
    private BufferedReader br;
    private OnMessageRecieved messageRecieved;

    public String msg;

    public static Session getInstance() {

        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(ip, port);
            OutputStream os = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os));
            InputStream is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            Platform.runLater(() -> {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String line) {

        new Thread(() -> {

            try {
                bw.write(line + "\n");
                bw.flush();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }).start();
        ;

    }

    public String readMessage() {
        new Thread(() -> {
            try {
                while (msg == null || msg.isEmpty()) {

                    msg = br.readLine();

                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        return msg;

    }


    public void resetSession() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setInstance() {
        instance = null;
    }
    
    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public OnMessageRecieved getMessageRecieved() {
        return this.messageRecieved;
    }

    public void setMessageRecieved(OnMessageRecieved messageRecieved) {
        this.messageRecieved = messageRecieved;
    }
}
