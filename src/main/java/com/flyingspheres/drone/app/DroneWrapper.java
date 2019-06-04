package com.flyingspheres.drone.app;

import com.flyingspheres.drone.TelloDrone;

import java.net.SocketException;

public class DroneWrapper {

    public static void main(String[] args) {
        TelloDrone drone = null;
        try {
            drone = TelloDrone.crear();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        drone.run();
    }

}
