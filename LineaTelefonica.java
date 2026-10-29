// CLASE PADRE (SUPER CLASE)
// VALOR FIJO DEL MINUTO EN COLOMBIA = $150 (CONSTANTE)

package Telefonia;

public class LineaTelefonica {

public static final double VALOR_MINUTO = 150;

private String numeroLinea;
private String titular;
private double minutosUsados;
private double saldoActual;

//CONSTRUCTOR VACIO 
public LineaTelefonica () {
    this.numeroLinea = "SIN NUMERO";
    this.titular = "SIN TITULAR";
    this.minutosUsados = 0;
    this.saldoActual = 0;
}

//METODOS SET 
public boolean setNumeroLinea (String numeroLinea) {
    if (numeroLinea != null && !numeroLinea.trim().isEmpty()) {
        this.numeroLinea = numeroLinea.trim();
        return true;
    } else {
        System.out.println("ERROR, EL NUMERO TELEFONICO NO PUEDE ESTAR VACIO");
        return false;
    }
}

public boolean setTitular (String titular) {
    if (titular != null && !titular.trim().isEmpty()) {
        this.titular = titular.trim();
        return true;
    } else {
        System.out.println("ERROR, EL TITULAR NO PUEDE ESTAR VACIO");
        return false;
    }
}

public boolean setMinutosUsados (double minutosUsados) {
    if (minutosUsados >= 0) {
        this.minutosUsados = minutosUsados;
        return true;
    } else {
        System.out.println("ERROR, LOS MINUTOS NO PUEDEN SER NEGATIVOS");
        return false;
    }
}

public boolean setSaldoActual (double saldoActual) {
    if (saldoActual >= 0) {
        this.saldoActual = saldoActual;
        return true;
    } else {
        System.out.println("ERROR, EL SALDO NO PUEDE SER NEGATIVO");
        return false;
    }
}

// METODOS GET 
public String getNumeroLinea () {
    return numeroLinea;
}

public String getTitular () {
    return titular;
}

public double getMinutosUsados () {
    return minutosUsados;
}

public double getSaldoActual () {
    return saldoActual;
}

//CALCULAR EL COSTO DEL CONSUMO MENSUAL
public double calcularcostoconsumo () {
    return minutosUsados * VALOR_MINUTO;
}

//SIMULAR UNA LLAMADA (LAS HIJAS LO MODIFICAN)
public boolean realizarllamada (double minutos) {
    if (minutos <= 0) {
        System.out.println("ERROR, LOS MINUTOS DEBEN SER MAYORES A CERO");
        return false;
    }
    setMinutosUsados (minutosUsados + minutos);
    return true;
}

}
