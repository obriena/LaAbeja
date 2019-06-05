package com.flyingspheres.drone.commands;

import com.flyingspheres.drone.CommandInterface;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Constructor;

public class FabricaDeComando {

    private static final Map<String, String> comandoMapa = new HashMap<>();
    static {
        comandoMapa.put(CommandInterface.Adelante, "com.flyingspheres.drone.commands.AdelanteComando");
        comandoMapa.put(CommandInterface.AgujasDelReloj, "com.flyingspheres.drone.commands.AgujasDelRelojComando");
        comandoMapa.put(CommandInterface.AgujasDelRelojContador, "com.flyingspheres.drone.commands.AgujasDelRelojContadorComando");
        comandoMapa.put(CommandInterface.Arriba, "com.flyingspheres.drone.commands.ArribaComando");
        comandoMapa.put(CommandInterface.Aterrizará, "com.flyingspheres.drone.commands.AterrizaráComando");
        comandoMapa.put(CommandInterface.Atrás, "com.flyingspheres.drone.commands.AtrásComando");
        comandoMapa.put(CommandInterface.Bajo, "com.flyingspheres.drone.commands.BajoComando");
        comandoMapa.put(CommandInterface.Derecha, "com.flyingspheres.drone.commands.DerechaComando");
        comandoMapa.put(CommandInterface.Despegará, "com.flyingspheres.drone.commands.DespegaráComando");
        comandoMapa.put(CommandInterface.Izquierda, "com.flyingspheres.drone.commands.IzquierdaComando");
        comandoMapa.put(CommandInterface.Orden, "com.flyingspheres.drone.commands.ComandoModo");
        comandoMapa.put(CommandInterface.QuéBateriaCargda, "com.flyingspheres.drone.commands.QuéBateriaCargdaComando");
        comandoMapa.put(CommandInterface.QuéRápido, "com.flyingspheres.drone.commands.QuéRápidoComando");
        comandoMapa.put(CommandInterface.TiempoDeVuelo, "com.flyingspheres.drone.commands.TiempoDeVueloComando");
        comandoMapa.put(CommandInterface.Velocidad, "com.flyingspheres.drone.commands.VelocidadComando");
        comandoMapa.put(CommandInterface.Voltereta, "com.flyingspheres.drone.commands.VolteretaComando");
    }

    public FabricaDeComando() {

    }

    public static Comando recuperarComando(String comandollave) throws Throwable {
        String nombreDeClase = comandoMapa.get(comandollave);
        Comando comando = null;
    
        Class claseDeComando = FabricaDeComando.class.getClassLoader().loadClass(nombreDeClase);
        Constructor[] constructors = claseDeComando.getConstructors();
        for (Constructor c : constructors){
            if (c.getParameterTypes().length == 0) {
                Object o = c.newInstance(null);
                comando = (Comando) o;
            }
        }

        return comando;
    }

}