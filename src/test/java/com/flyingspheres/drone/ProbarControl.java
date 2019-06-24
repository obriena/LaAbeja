package com.flyingspheres.drone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ProbarControl {

    ControladorDeTrello control;

    @Before
    public void preparar(){
        try {
            control = ControladorDeTrello.createController("localhost", 4445);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(control);
    }

    @Test
    public void testController() {
        try {
            String respuesta = control.sendCommand(CommandInterface.Orden);
            Assert.assertNotNull(respuesta);
            Assert.assertEquals(respuesta, CommandInterface.BIEN);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTakeOff() {
        String respuesta = null;
        try {
            respuesta = control.sendCommand(CommandInterface.Despegará);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(respuesta);
        Assert.assertEquals(respuesta, CommandInterface.BIEN);
    }

    @Test
    public void probarApagar() {
        try {
            control.sendCommand("end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
