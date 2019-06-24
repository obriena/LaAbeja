package com.flyingspheres.drone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

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
public class ProbarDrone {
    TelloDrone drone = null;
    ControladorDeTrello controller = null;


    @Before
    public void setup() {

        try {
            drone = TelloDrone.crear();
            controller = ControladorDeTrello.createController();
        } catch (SocketException e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDrone() {
        Assert.assertNotNull(drone);
        Assert.assertNotNull(controller);
    }

    @Test
    public void testStartStopDrone() {
        Assert.assertFalse(drone.isCorriendo());

        drone.start();
        pause(1);
        Assert.assertTrue(drone.isCorriendo());

        try {
            String respuesta = controller.shutdownDrone();
            System.out.println("la abeja dijo: " + respuesta);
            pause(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertFalse(drone.isCorriendo());
        System.out.println("Prueba Completa");
    }

    private void pause(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
