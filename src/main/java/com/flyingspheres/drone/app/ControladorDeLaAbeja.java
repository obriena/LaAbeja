package com.flyingspheres.drone.app;

import com.flyingspheres.drone.CommandInterface;
import com.flyingspheres.drone.ControladorDeTrello;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ControladorDeLaAbeja {

    private static final String direccion = "192.168.10.1";
    private static final int puerta = 8889;

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
            if(CommandInterface.BIEN.equals(response)){
                System.err.println("Error entering command mode: " + response);
            }
            else {
                String empezarCargado = controladorDeTrello.sendCommand(CommandInterface.QuéBateriaCargda);
                String respuesta = despegara(controladorDeTrello);


                //avanzar
                String alvanzarComando = CommandInterface.Adelante;
                alvanzarComando = alvanzarComando.replace("XX", "60cm");

                respuesta = controladorDeTrello.sendCommand(alvanzarComando);
                Thread.sleep(10000);

                //Giro de vuelta
                String agujasComando = CommandInterface.AgujasDelReloj.replace("XX", "180");
                controladorDeTrello.sendCommand(agujasComando);
                Thread.sleep(10000);

                //Vuelve
                alvanzarComando = CommandInterface.Adelante;
                alvanzarComando = alvanzarComando.replace("XX", "30");
                Thread.sleep(10000);

                respuesta = aterrizara(controladorDeTrello);

                String terminarCargado = controladorDeTrello.sendCommand(CommandInterface.QuéBateriaCargda);
                System.out.println("Bateria Cargado: " + empezarCargado + " Fine Cargado: " + terminarCargado);

            }
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    private static String aterrizara(ControladorDeTrello controladorDeTrello) throws IOException {
        String respuesta;
        respuesta = controladorDeTrello.sendCommand(CommandInterface.Aterrizará);
        System.out.println("Comando: " + CommandInterface.Aterrizará + ": " + respuesta);
        return respuesta;
    }

    private static String despegara(ControladorDeTrello controladorDeTrello) throws IOException {
        String respuesta = controladorDeTrello.sendCommand(CommandInterface.Despegará);
        System.out.println("Comando: " + CommandInterface.Despegará + ": " + respuesta);
        return respuesta;
    }

}
