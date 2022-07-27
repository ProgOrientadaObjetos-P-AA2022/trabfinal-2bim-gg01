package p1;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import p2.PlanPostPagoMegas;
import p3.Enlace;

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
        Enlace c = new Enlace();
        boolean bandera = false;
        int opc;
        int op;
        char salida;

        do {
            try {
                System.out.println("[1] para Ingresar un tipo de Plan Celular\n"
                        + "[2] para Leer la Base de Datos");
                op = entrada.nextInt();
                if (op == 1) {
                    System.out.println("Ingrese un tipo de Plan Celular\n"
                            + " 1 -> Plan Megas\n"
                            + " 2 -> Plan Minutos\n"
                            + " 3 -> Plan Minutos-Megas\n"
                            + " 4 -> Plan Minutos-Megas Económico");
                    opc = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingrese Nombres del Cliente");
                    String nom = entrada.nextLine();
                    System.out.println("Ingrese Cedula del Cliente");
                    String ced = entrada.nextLine();
                    System.out.println("Ingrese Ciudad del Cliente");
                    String ciu = entrada.nextLine();
                    System.out.println("Ingrese Marca del Celular");
                    String marca = entrada.nextLine();
                    System.out.println("Ingrese Modelo del Celular");
                    String modelo = entrada.nextLine();
                    System.out.println("Ingrese Numero de Celular");
                    String numero = entrada.nextLine();
                    switch (opc) {
                        case 1 -> {
                            System.out.println("Ingrese cantidad de Minutos "
                                    + "Nacionales");
                            double mN = entrada.nextDouble();
                            System.out.println("Ingrese "
                                    + "costo por Minuto Nacional");
                            double cN = entrada.nextDouble();
                            System.out.println("Ingrese cantidad de Minutos "
                                    + "Internacionales");
                            double mI = entrada.nextDouble();
                            System.out.println("Ingrese "
                                    + "costo por Minuto Internacional");
                            double cI = entrada.nextDouble();

                            PlanPostPagoMegas plan = new PlanPostPagoMegas(
                                    nom, ced, ciu, marca, modelo, numero,
                                    mN, cN, mI, cI);
                            plan.calcularPagoMensual();
                            c.insertarPlanPostPagoMegas(plan);
                        }
                        case 2 -> {
                        }
                        case 3 -> {
                        }
                        case 4 -> {
                        }
                    }
                } else {
                    if (op == 2) {
                        System.out.println("------Base de Datos------");
                        for (int i = 0; i < c.obtenerDataPlanes().size(); i++) {
                            System.out.printf("%s", c.obtenerDataPlanes().get(i));
                        }
                    } else {
                        System.out.println("Ingrese una opción válida(1 o 2)");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción válida(1 o 2)");
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
