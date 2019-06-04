package com.flyingspheres.drone.commands;

import com.flyingspheres.drone.CommandInterface;
import com.flyingspheres.drone.MaquinaDeEstado;

public class ComandoModo implements Comando {

    public ComandoModo() {

    }

    @Override
    public String executeCommand(MaquinaDeEstado maquina) {
        String response = CommandInterface.BIEN;
        if (!maquina.isModoDeComando()){
            maquina.setModoDeComando(true);
        }
        return response;
    }
}