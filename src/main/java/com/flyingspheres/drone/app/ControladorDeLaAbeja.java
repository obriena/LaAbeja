package com.flyingspheres.drone.app;

import com.flyingspheres.drone.CommandInterface;
import com.flyingspheres.drone.ControladorDeTrello;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ControladorDeLaAbeja {

    private static final String direccion = "localhost";
    private static final int puerta = 4445;

    public static void main(String[] args){
        ControladorDeTrello controladorDeTrello = null;
        try {
            controladorDeTrello = ControladorDeTrello.createController(direccion, puerta);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            String response = controladorDeTrello.sendCommand(CommandInterface.Orden);
            if(CommandInterface.BIEN  != response ){
                System.err.println("Error entering command mode: " +response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
