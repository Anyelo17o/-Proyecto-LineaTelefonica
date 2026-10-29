// CLASE HIJA SUB CLASE --- > HEREDA DE LineaTelefonica
// EL VALOR DE LAS LLAMADAS SE DESCUENTA DIRECTAMENTE DEL SALDO RECARGADO

package Telefonia;

public class LineaPrepago extends LineaTelefonica {

// RECARGAR SALDO (SUMA UN VALOR AL SALDO ACTUAL)
public boolean recargarsaldo (double valor) {
    if (valor > 0) {
        setSaldoActual (getSaldoActual () + valor);
        System.out.println("RECARGA EXITOSA");
        return true;
    } else {
        System.out.println("ERROR, LA RECARGA DEBE SER MAYOR A CERO");
        return false;
    }
}

//SIMULACION DE UNA LLAMADA (DESCUENTA DEL SALDO)
@Override
public boolean realizarllamada (double minutos) {
    if (minutos <= 0) {
        System.out.println("ERROR, LOS MINUTOS DEBEN SER MAYORES A CERO");
        return false;
    }

    double costollamada = minutos * VALOR_MINUTO;

    if (costollamada > getSaldoActual ()) {
        System.out.println("LLAMADA RECHAZADA, EL SALDO ES INSUFICIENTE");
        return false;
    }

    setSaldoActual (getSaldoActual () - costollamada);
    setMinutosUsados (getMinutosUsados () + minutos);
    System.out.println("LLAMADA REALIZADA CON EXITO");
    return true;
}

}
