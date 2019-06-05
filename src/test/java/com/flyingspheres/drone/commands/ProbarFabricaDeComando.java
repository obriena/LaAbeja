package com.flyingspheres.drone.commands;
import com.flyingspheres.drone.CommandInterface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;

public class ProbarFabricaDeComando {

    @Test 
    public void purebaFabricaDeComando() {
        try {
            Comando comando = FabricaDeComando.recuperarComando(CommandInterface.Orden);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof ComandoModo);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Adelante);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof AdelanteComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.AgujasDelReloj);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof AgujasDelRelojComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.AgujasDelRelojContador);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof AgujasDelRelojContadorComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Arriba);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof ArribaComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Aterrizará);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof AterrizaráComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Atrás);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof AtrásComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Bajo);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof BajoComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Derecha);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof DerechaComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Despegará);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof DespegaráComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Izquierda);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof IzquierdaComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.QuéBateriaCargda);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof QuéBateriaCargdaComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.QuéRápido);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof QuéRápidoComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.TiempoDeVuelo);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof TiempoDeVueloComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Velocidad);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof VelocidadComando);

            comando = FabricaDeComando.recuperarComando(CommandInterface.Voltereta);
            Assert.assertNotNull(comando);
            Assert.assertTrue(comando instanceof VolteretaComando);
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.assertTrue(false);
        }
    }

}