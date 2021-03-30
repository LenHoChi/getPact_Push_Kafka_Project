package com.example.demoProject.server;

import com.example.demoProject.controller.Handler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created for http://stackoverflow.com/q/16351413/1266906.
 */
public class Server extends Thread {

    public static void main(String[] args) {
        (new Server()).run();
    }

    public Server() {
        super("Server Thread");
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            Socket socket;
            try {
                while ((socket = serverSocket.accept()) != null) {
                    (new Handler(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();  // TODO: implement catch
            }
        } catch (IOException e) {
            e.printStackTrace();  // TODO: implement catch
            return;
        }
    }
}
