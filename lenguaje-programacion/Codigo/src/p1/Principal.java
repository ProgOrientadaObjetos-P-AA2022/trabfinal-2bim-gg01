package p1;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean bandera = false;
        int op;
        int opc;
        char salida;

        do {
            System.out.println("[1] para Ingresar un tipo de Plan Celular\n"
                    + "[2] para leer la Base de Datos");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese un tipo de Plan Celular\n"
                            + " 1 -> Plan Megas\n"
                            + " 2 -> Plan Minutos\n"
                            + " 3 -> Plan Minutos-Megas\n"
                            + " 4 -> Plan Minutos-Megas Económico");
                    opc = entrada.nextInt();
                    switch (opc) {
                        case 1 -> {
                            
                        }
                        case 2 -> {
                        }
                        case 3 -> {
                        }
                        case 4 -> {
                        }
                    }
                case 2:
                    System.out.println("------Base de Datos------");
                default: break;
            }

            //Salida
            entrada.nextLine(); //Limpieza de buffer

            System.out.println("Ingrese 'x' para salir, 'c' para continuar");
            salida = entrada.nextLine().charAt(0);
            if (salida == 'x') {
                bandera = true;
            } else {
                if (salida != 'x' && salida != 'c') {
                    System.err.print("Ingrese opción válida ('x' o 'c')");
                    bandera = true;
                }
            }
        } while (bandera == false);
    }

}
