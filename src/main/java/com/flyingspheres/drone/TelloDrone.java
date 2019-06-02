package com.flyingspheres.drone;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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

public class TelloDrone extends Thread implements CommandInterface {
    private DatagramSocket udpSocket;
    private boolean corriendo;
    private byte[] buff = new byte[256];

    private static TelloDrone abeja = null;

    public static TelloDrone crear() throws SocketException {
        if (abeja == null) {
            abeja = new TelloDrone();
        }
        return abeja;
    }

    private TelloDrone() throws SocketException {
        udpSocket = new DatagramSocket(4445);
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void run() {
        if (corriendo == true) {
            System.out.println("la abeja ya esta corriendo");
        } else {
            System.out.println("la abeja esta empezando");
            corriendo = true;
            System.out.println("la puesta en marcha de la abeja está completa");
            while (corriendo) {
                System.out.println("la abeja está esperando órdenes");
                try {
                    DatagramPacket packet = new DatagramPacket(buff, buff.length);
                    udpSocket.receive(packet);
                    String received = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Comando recibido: "+ received);

                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();

                    String respuesta = "OK";
                    DatagramPacket respuestaPaquete = new DatagramPacket(respuesta.getBytes(), respuesta.length(), address, port);
                    udpSocket.send(respuestaPaquete);
                    if (received.equals("end")) {
                        corriendo = false;
                        continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("la abeja se está cerrando");
            udpSocket.close();
            corriendo = false;
            System.out.println("la abeja apagada");
        }
    }
}
