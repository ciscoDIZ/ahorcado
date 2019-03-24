/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado_sencillo.model;

/**
 *
 * @author Francisco de Asís Domínguez Iceta. 1º DAW, IES Puerto de la Cruz
 */
public class Ahorcado {
    private String jugador;
    private final String PALABRA_SECRETA;
    private  String[] palabras;
    private char[] tablero;
    private char intento;
    private String errores;
    private final int ERRORES_POSIBLES;
    private boolean partidaActiva;

    public Ahorcado(String jugador, String[] palabras, int erroresPosibles) {
        this.jugador = jugador;
        this.palabras = palabras;
        PALABRA_SECRETA = palabras[(int)(Math.random()*(palabras.length))];
        tablero = new char[PALABRA_SECRETA.length()];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] += '_';
            
        }
        ERRORES_POSIBLES = erroresPosibles;
        partidaActiva=true;
        errores="";
    }
    
    private boolean[] comprobarLetra(String palabra, char c) {
        boolean[] resultado = new boolean[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == c) {
                resultado[i] = true;
            }
        }
        return resultado;
    }
    
    public void actualizarTablero() {
        boolean[] comprobacion = comprobarLetra(PALABRA_SECRETA, intento);
        for (int i = 0; i < tablero.length; i++) {
            if (comprobacion[i] == true) {
                tablero[i] =  intento;
            }
        }
    }
    
    public boolean comprobarVictoriaLarga() {
        String palabraTablero = "";
        for (char tablero1 : tablero) {
            palabraTablero += String.valueOf(tablero1);
        }
        return PALABRA_SECRETA.equals(palabraTablero);
    }
    
    public boolean comprobarVictoriaCorta(String palabraIntento) {
        return PALABRA_SECRETA.equals(palabraIntento);
    }
    
    public boolean comprobarAcierto() {
        return PALABRA_SECRETA.contains(String.valueOf(intento));
    }

    public String[] getPalabras() {
        return palabras;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }
    
    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public char[] getTablero() {
        return tablero;
    }

    public void setTablero(char[] tablero) {
        this.tablero = tablero;
    }

    public boolean isPartidaActiva() {
        return partidaActiva;
    }

    public void setPartidaActiva(boolean partidaActiva) {
        this.partidaActiva = partidaActiva;
    }

    public char getIntento() {
        return intento;
    }

    public void setIntento(char intento) {
        this.intento = intento;
    }

    public String getErrores() {
        return errores;
    }

    public void setErrores(String errores) {
        this.errores += errores;
    }

    public int getERRORES_POSIBLES() {
        return ERRORES_POSIBLES;
    }
}
