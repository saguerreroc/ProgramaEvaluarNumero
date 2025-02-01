package com.redeban.primos.util;
/**
 * Clase que contiene las constantes generales de la aplicación.
 */
public class GeneralConstantes {

    /** constante que contiene el mensaje de número primo */
    public static final String NUMERO_PRIMO = "El número %d es primo";
    /** constante que contiene el mensaje de número no primo */
    public static final String NUMERO_NO_PRIMO = "El número %d no es primo";
    /** constante que contiene el código de error */
    public static final String CODE_ERROR = "01";
    /** constante que contiene el mensaje de error al evaluar el número */
    public static final String ERROR_CONVERTIR_NUMERO = "Excede el límite de un int en Java, que es 2,147,483,647 (máximo número de 10 dígitos).";

    /**
        * Constructor privado para evitar la instanciación de la clase.
     */
    public GeneralConstantes() {}
}
