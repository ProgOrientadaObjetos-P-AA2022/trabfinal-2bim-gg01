package p1;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import p2.*;
import p3.Enlace;

/**
 *
 * @author TaisBalcazar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);

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
                            + " 1 -> Plan Minutos\n"
                            + " 2 -> Plan Megas\n"
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
                            System.out.println("Ingrese la cantidad de Minutos "
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

                            PlanPostPagoMinutos plan1 = new PlanPostPagoMinutos(
                                    nom, ced, ciu, marca, modelo, numero,
                                    mN, cN, mI, cI);
                            plan1.calcularPagoMensual();
                            c.insertarPostPagoMinutos(plan1);
                            break;
                        }
                        case 2 -> {
                            System.out.println("Ingrese el Número de Megas (Gb):");
                            double numG = entrada.nextDouble();
                            System.out.println("Ingrese el Costo por Mega:");
                            double cosG = entrada.nextDouble();
                            System.out.println("Ingrese la tarifa base:");
                            double tarifa = entrada.nextDouble();
                            PlanPostPagoMegas plan2 = new PlanPostPagoMegas(
                                    nom, ced, ciu, marca, modelo, numero,
                                    numG, cosG, tarifa);
                            plan2.calcularPagoMensual();
                            c.insertarPostPagoMegas(plan2);
                            break;
                        }
                        case 3 -> {
                            System.out.println("Ingrese el Número de minutos:");
                            double min = entrada.nextDouble();
                            System.out.println("Ingrese el Costo por minuto:");
                            double costo = entrada.nextDouble();
                            System.out.println("Ingrese el Número de Megas (Gb):");
                            double numG = entrada.nextDouble();
                            System.out.println("Ingrese el Costo por Mega:");
                            double cosG = entrada.nextDouble();
                            PlanPostPagoMinutosMegas plan3
                                    = new PlanPostPagoMinutosMegas(
                                            nom, ced, ciu, marca, modelo, numero,
                                            min, costo, numG, cosG);
                            plan3.calcularPagoMensual();
                            c.insertarPostPagoMinutosMegas(plan3);
                            break;

                        }

                        case 4 -> {
                            System.out.println("Ingrese el Número de minutos:");
                            double min = entrada.nextDouble();
                            System.out.println("Ingrese el Costo por minuto:");
                            double costo = entrada.nextDouble();
                            System.out.println("Ingrese el Número de Megas (Gb):");
                            double numG = entrada.nextDouble();
                            System.out.println("Ingrese el Costo por Mega:");
                            double cosG = entrada.nextDouble();
                            double descuento = 10;
                            PlanPostPagoMinutosMegasEconomico plan4
                                    = new PlanPostPagoMinutosMegasEconomico(
                                            nom, ced, ciu, marca, modelo, numero,
                                            min, costo, numG, cosG, descuento);
                            plan4.calcularPagoMensual();
                            c.insertarPostPagoMinutosMegasEc(plan4);
                            break;
                        }
                    }
                    if (op < 1 || op > 4) {
                        System.out.println("Opción inválida. Debe ingresar un "
                                + "número entre del 1 y 4");
                    }
                } else {

                    if (op == 2) {
                        System.out.println("------Base de Datos------\n"
                                + " 1 -> Mostrar Tabla Plan Minutos\n"
                                + " 2 -> Mostrar Tabla Plan Megas\n"
                                + " 3 -> Mostrar Tabla Plan Minutos-Megas\n"
                                + " 4 -> Mostrar Tabla Plan Minutos-Megas Económico");
                        opc = entrada.nextInt();
                        switch (opc) {
                            case 1 -> {
                                for (int i = 0; i < c.obtenerDataPostPagoMinutos().size(); i++) {
                                    System.out.printf("%s", c.obtenerDataPostPagoMinutos().get(i));
                                }
                                break;
                            }

                            case 2 -> {
                                for (int i = 0; i < c.obtenerDataPostPagoMegas().size(); i++) {
                                    System.out.printf("%s", c.obtenerDataPostPagoMegas().get(i));
                                }
                                break;
                            }
                            case 3 -> {
                                for (int i = 0; i < c.obtenerDataPostPagoMinutosMegas().size(); i++) {
                                    System.out.printf("%s", c.obtenerDataPostPagoMinutosMegas().get(i));
                                }
                                break;
                            }

                            case 4 -> {
                                for (int i = 0; i < c.obtenerDataPostPagoMinutosMegasEc().size(); i++) {
                                    System.out.printf("%s", c.obtenerDataPostPagoMinutosMegasEc().get(i));
                                }
                                break;
                            }
                        }
                        if (op < 1 || op > 4) {
                            System.out.println("Opción inválida. Debe ingresar un "
                                    + "número entre del 1 y 4");
                        }
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
