package com.flyingspheres.drone;

import com.flyingspheres.drone.commands.Comando;
import com.flyingspheres.drone.commands.FabricaDeComando;

/**
 * Created by Aaron O'Brien on 2019-06-02.
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
public class MaquinaDeEstado implements CommandInterface {
    /*
        Esta clase es mi idea de cómo implementar la representación estatal el drone.
        Reglas -
            El comando "command" debar primer si no, todos comandos son ignorados

     */
    boolean modoDeComando = false;

    private static MaquinaDeEstado máquina = null;

    public static MaquinaDeEstado crearMáquina() {
        if (máquina == null) {
            máquina = new MaquinaDeEstado();
        }
        return máquina;
    }

    private MaquinaDeEstado() {

    }

    public String recibirComando(String comando){
        String respuesta = MALO;
        try {
            Comando comandoObjecto = FabricaDeComando.recuperarComando(comando);
            respuesta = ejecutarComando(comandoObjecto);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (modoDeComando) {

        } else {
            if (comando.equals(Orden)){
                modoDeComando = true;
                respuesta = BIEN;
            }
        }
        return respuesta;
    }

    private String ejecutarComando(Comando comandoObjecto) {
        return comandoObjecto.executeCommand(this);
    }

    public boolean isModoDeComando() {
        return modoDeComando;
    }

    public void setModoDeComando(boolean modoDeComando) {
        this.modoDeComando = modoDeComando;
    }
}
