package com.flyingspheres.drone;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron O'Brien on 2019-06-01.
 * <p>
 * This SOFTWARE PRODUCT is provided by THE PROVIDER "as is" and "with all faults."
 * <p>
 * THE PROVIDER makes no representations or warranties of any kind concerning the safety, suitability, lack of viruses,
 * inaccuracies, typographical errors, or other harmful components of this SOFTWARE PRODUCT. There are inherent dangers
 * in the use of any software, and you are solely responsible for determining whether this SOFTWARE PRODUCT is compatible
 * with your equipment and other software installed on your equipment. You are also solely responsible for the protection
 * of your equipment and backup of your data, and THE PROVIDER will not be liable for any damages you may suffer in
 * connection with using, modifying, or distributing this SOFTWARE PRODUCT.
 */
public class TelloController implements CommandInterface{

    private DatagramSocket socket;
    private InetAddress address;
    private int puerto;

    private byte[] buff;
    private static TelloController controller = null;

    private List<String> commandHistory = new ArrayList<String>();

    public static TelloController createController() throws SocketException, UnknownHostException {
        controller = new TelloController();
        return controller;
    }

    public static TelloController createController(String droneDireccion, int dronePuerto) throws SocketException, UnknownHostException {
        controller = new TelloController(droneDireccion, dronePuerto);
        return controller;
    }

    private TelloController() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
        puerto = 4445;
    }

    private TelloController(String droneDireccion, int dronePuerto) throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName(droneDireccion);
        puerto = dronePuerto;
    }

    public String sendCommand(String command) throws IOException {
        buff = command.getBytes();
        DatagramPacket packet = new DatagramPacket(buff, buff.length, address, puerto);
        socket.send(packet);

        packet = new DatagramPacket(buff, buff.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());

        commandHistory.add(command + ":" + received);

        return received;
    }

    public String shutdownDrone() throws IOException {
        return sendCommand("end");
    }
}
