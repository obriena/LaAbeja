package com.flyingspheres.drone.commands;

import com.flyingspheres.drone.CommandInterface;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Constructor;

public class FabricaDeComando {

    private static final Map<String, String> comandoMapa = new HashMap<>();
    static {
        comandoMapa.put(CommandInterface.Orden, "com.flyingspheres.drone.commands.ComandoModo");
        comandoMapa.put(CommandInterface.Despegará, "com.flyingspheres.drone.commands.DespegaráComando");
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