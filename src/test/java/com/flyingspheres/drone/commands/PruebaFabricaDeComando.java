package com.flyingspheres.drone.commands;
import com.flyingspheres.drone.CommandInterface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PruebaFabricaDeComando {


    @Test 
    public void purebaFabricaDeComando() {
        try {
            Comando comando = FabricaDeComando.recuperarComando(CommandInterface.Orden);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof ComandoModo);
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    @Test 
    public void purebaDespegaráComando() {
        try {
            Comando comando = FabricaDeComando.recuperarComando(CommandInterface.Despegará);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof ComandoModo);
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}