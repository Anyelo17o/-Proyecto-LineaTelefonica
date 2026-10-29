// CLASE HIJA SUB CLASE --- > HEREDA DE LineaTelefonica


package Telefonia;

public class LineaPostpago extends LineaTelefonica {


private double topeCredito;
private double cargoFijoBasico;

// CREAR EL CONSTRUCTOR
public LineaPostpago () {
    super (); //super me permite heredar
    this.topeCredito = 0;
    this.cargoFijoBasico = 0;
}

//METODOS SET Y GET PROPIOS
public boolean setTopeCredito (double topeCredito) {
    if (topeCredito >= 0) {
        this.topeCredito = topeCredito;
        return true;
    } else {
        System.out.println("ERROR, EL TOPE DE CREDITO NO PUEDE SER NEGATIVO");
        return false;
    }
}

public boolean setCargoFijoBasico (double cargoFijoBasico) {
    if (cargoFijoBasico >= 0) {
        this.cargoFijoBasico = cargoFijoBasico;
        return true;
    } else {
        System.out.println("ERROR, EL CARGO FIJO NO PUEDE SER NEGATIVO");
        return false;
    }
}

public double getTopeCredito () {
    return topeCredito;
}

public double getCargoFijoBasico () {
    return cargoFijoBasico;
}

//SIMULACION DE UNA LLAMADA (EL CONSUMO NO PUEDE PASAR EL TOPE)
@Override
public boolean realizarllamada (double minutos) {
    if (minutos <= 0) {
        System.out.println("ERROR, LOS MINUTOS DEBEN SER MAYORES A CERO");
        return false;
    }

    double nuevostotalminutos = getMinutosUsados () + minutos;
    double nuevocostoconsumo = nuevostotalminutos * VALOR_MINUTO;

    if (nuevocostoconsumo > topeCredito) {
        System.out.println("LLAMADA RECHAZADA, SE SUPERARIA EL TOPE DE CREDITO");
        return false;
    }

    setMinutosUsados (nuevostotalminutos);
    System.out.println("LLAMADA REALIZADA CON EXITO");
    return true;
}

//CALCULAR LA FACTURA FINAL (CONSUMO + CARGO FIJO)
public double calcularfacturafinal () {
    return calcularcostoconsumo () + cargoFijoBasico;
}

}
