//CLASE QUE UTILIZO PARA MOSTRAR RESULTADOS AL CLIENTE

package Telefonia;

import java.util.Scanner;

public class Main {

    //METODO PARA VALIDACION
    private static double leernumero (Scanner teclado, String mensaje) {
        while (true) {
            System.out.println(mensaje);

            if (teclado.hasNextDouble()) {
                double valor = teclado.nextDouble();
                teclado.nextLine();

                if (valor >= 0) {
                    return valor;
                }
                System.out.println("ERROR, EL VALOR NO PUEDE SER NEGATIVO");
            } else {
                System.out.println("ERROR, SOLO SE RECIBEN DATOS NUMERICOS");
                teclado.nextLine();
            }
        }
    }

    public static void main (String [] args) {

        Scanner teclado = new Scanner (System.in);
        boolean valido;

        //LINEA PREPAGO
        LineaPrepago lineaPre = new LineaPrepago ();
        System.out.println("===== REGISTRO DE LINEA PREPAGO =====");

        valido = false;
        while (!valido) {
            System.out.println("INGRESE EL NUMERO TELEFONICO: ");
            valido = lineaPre.setNumeroLinea (teclado.nextLine());
        }

        valido = false;
        while (!valido) {
            System.out.println("INGRESE EL NOMBRE DEL TITULAR: ");
            valido = lineaPre.setTitular (teclado.nextLine());
        }

        lineaPre.setSaldoActual (leernumero (teclado, "INGRESE EL SALDO INICIAL: "));
        lineaPre.realizarllamada (leernumero (teclado, "INGRESE LOS MINUTOS DE LA LLAMADA: "));

        System.out.println();
        System.out.println("===== RESULTADO LINEA PREPAGO =====");
        System.out.println("NUMERO: " + lineaPre.getNumeroLinea ());
        System.out.println("TITULAR: " + lineaPre.getTitular ());
        System.out.println("MINUTOS USADOS: " + lineaPre.getMinutosUsados ());
        System.out.printf("SALDO RESTANTE: $%.0f%n", lineaPre.getSaldoActual ());
        System.out.printf("COSTO DE LLAMADAS: $%.0f%n", lineaPre.calcularcostoconsumo ());

        //LINEA POSTPAGO
        LineaPostpago lineaPos = new LineaPostpago ();
        System.out.println();
        System.out.println("===== REGISTRO DE LINEA POSTPAGO =====");

        valido = false;
        while (!valido) {
            System.out.println("INGRESE EL NUMERO TELEFONICO: ");
            valido = lineaPos.setNumeroLinea (teclado.nextLine());
        }

        valido = false;
        while (!valido) {
            System.out.println("INGRESE EL NOMBRE DEL TITULAR: ");
            valido = lineaPos.setTitular (teclado.nextLine());
        }

        lineaPos.setTopeCredito (leernumero (teclado, "INGRESE EL TOPE DE CREDITO: "));
        lineaPos.setCargoFijoBasico (leernumero (teclado, "INGRESE EL CARGO FIJO MENSUAL: "));
        lineaPos.realizarllamada (leernumero (teclado, "INGRESE LOS MINUTOS DE LA LLAMADA: "));

        System.out.println();
        System.out.println("===== RESULTADO LINEA POSTPAGO =====");
        System.out.println("NUMERO: " + lineaPos.getNumeroLinea ());
        System.out.println("TITULAR: " + lineaPos.getTitular ());
        System.out.println("MINUTOS USADOS: " + lineaPos.getMinutosUsados ());
        System.out.printf("COSTO DE LLAMADAS: $%.0f%n", lineaPos.calcularcostoconsumo ());
        System.out.printf("CARGO FIJO MENSUAL: $%.0f%n", lineaPos.getCargoFijoBasico ());
        System.out.printf("FACTURA FINAL: $%.0f%n", lineaPos.calcularfacturafinal ());

        teclado.close();
        System.out.println("SISTEMA DE TELEFONIA FINALIZADO");
    }

}
