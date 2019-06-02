package com.flyingspheres.drone;

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
public interface CommandInterface {

    public static final String Orden = "command";
    public static final String Despegará = "takeoff";
    public static final String Aterrizará = "land";
    public static final String Arriba = "up XX";
    public static final String Bajo = "down XX";
    public static final String Izquierda = "left XX";
    public static final String Derecha = "right XX";
    public static final String Adelante = "forward XX";
    public static final String Atrás = "back XX";
    public static final String AgujasDelReloj = "cw XX";
    public static final String AgujasDelRelojContador = "ccw XX";
    public static final String Voltereta = "flip XX";
    public static final String Velocidad = "speed XX";
    public static final String QuéRápido = "Speed?";
    public static final String QuéBateriaCargda = "Battery?";
    public static final String TiempoDeVuelo = "Time?";

}
