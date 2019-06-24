package com.flyingspheres.drone.commands;

import com.flyingspheres.drone.CommandInterface;
import com.flyingspheres.drone.MaquinaDeEstado;

public class DespegaráComando implements Comando {

    public DespegaráComando() {

    }

    @Override
    public String executeCommand(MaquinaDeEstado maquina) {
        String respuesta = CommandInterface.MALO;
        if (maquina.isModoDeComando()){
            respuesta = CommandInterface.BIEN;
        } else {
            System.err.println("Incapaz a complete comando: Despegara.  La Drone no es en Comando Modo");
        }

        return respuesta;
    }
}
