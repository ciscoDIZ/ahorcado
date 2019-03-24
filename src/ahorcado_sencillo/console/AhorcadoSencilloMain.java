/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado_sencillo.console;

import ahorcado_sencillo.model.Ahorcado;
import java.util.Scanner;

/**
 *
 * @author Francisco de Asís Domínguez Iceta. 1º DAW, IES Puerto de la Cruz
 */
public class AhorcadoSencilloMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] palabras = {"flor", "otorrino", "alpaca", "alquitranado",
            "esternocleidomastoideo"};
        boolean salir = false;
        while (!salir) {
            System.out.println("Para nueva partida pulsar n, salir s");
            char opt = sc.next().charAt(0);
            if (opt == 'n') {
                System.out.println("Introducir nombre del jugador");
                String nombre = sc.next();
                Ahorcado a = new Ahorcado(nombre, palabras, 6);
                while (a.isPartidaActiva()) {
                    System.out.println("Turno de: "+a.getJugador());
                    System.out.println("Introducir intento");
                    System.out.println(a.getTablero());
                    a.setIntento(sc.next().charAt(0));
                    if (a.comprobarAcierto()) {
                        System.out.println("Has acertado!!");
                    } else {
                        System.out.println("Has fallado!!");
                        a.setErrores(String.valueOf(a.getIntento()));
                        String errores = a.getErrores();
                        if (errores.length() >= a.getERRORES_POSIBLES()) {
                            System.out.println("Has perdido");
                            a.setPartidaActiva(false);
                        }
                    }
                    a.actualizarTablero();
                    System.out.println(a.getTablero());
                    if (a.comprobarVictoriaLarga()) {
                        System.out.println("Has ganado!!");
                        a.setPartidaActiva(false);
                    }
                }
            }else if(opt == 's'){
                System.out.println("Nos vemos pronto!!");
                salir = true;
            }
        }
    }

}
