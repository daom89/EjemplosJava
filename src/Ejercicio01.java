import java.util.Scanner;

public class Ejercicio01 {

    /*
    * Enunciado Ejercicio.
    *
    * Indicar al usuario el importe total de la venta. La empresa ofrece
    * hamburguesa sencilla a $15 pesos y las doble a $20. Si compra tres
    * hamburguesas dobles exactamente, se le da un 10% de descuento en
    * las tres hamburguesas exactamente. El refresco chico a $7 pesos
    * y el grande a $10. Si compra 2 hamburguesas dobles exactamente,
    * el refresco chico es gratis.
    *
    * */

    public static void main(String[] args) {

        int NumHamburSencillas = 0, NumHamburDobles = 0, NumRefrescoChico, NumRefrescoGrande, TotalRefrescoChico, TotalRefrescoGrande;
        float TotalDescuentos, TotalHambDobles, TotalHambSencillas,  RefrescosGratis = 0, TotalCompra = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de compras de Hamburguesas");
        System.out.println("------------------------------------------------");
        System.out.println("Ingrese la cantidad de hamburguesas sencillas ($15 Pesos) que desea comprar");
        NumHamburSencillas = validateNumberValue(sc.next());

        System.out.println("Ingrese la cantidad de hamburguesas dobles ($20 Pesos) que desea comprar");
        NumHamburDobles = validateNumberValue(sc.next());

        System.out.println("Ingrese la cantidad de refrescos chicos ($7 Pesos) que desea comprar");
        NumRefrescoChico = validateNumberValue(sc.next());

        System.out.println("Ingrese la cantidad de refrescos grandes ($10 Pesos) que desea comprar");
        NumRefrescoGrande = validateNumberValue(sc.next());

        /*Calculos de las Hambuerguesas*/
        int SubTotalHambDobles = (NumHamburDobles * 20);
        TotalDescuentos = Math.round(((NumHamburDobles - (NumHamburDobles % 3)) * 20) * 0.10);
        TotalHambDobles = SubTotalHambDobles - TotalDescuentos;

        TotalHambSencillas = NumHamburSencillas * 15;
        System.out.println("El total de las hamburgesas dobles es de: "+SubTotalHambDobles+" \ntienen un descuento de "+TotalDescuentos+" para un total de: "+TotalHambDobles);
        System.out.println("El total de las hamburgesas dobles es de: "+TotalHambSencillas);

        /*Calculos de los refrescos*/

        TotalRefrescoChico = NumRefrescoChico * 7;
        TotalRefrescoGrande = NumRefrescoGrande * 10;
        RefrescosGratis = (NumHamburDobles - (NumHamburDobles % 2)) / 2;

        if (NumRefrescoChico > 0 && RefrescosGratis > 0){
            TotalRefrescoChico = Math.round(TotalRefrescoChico - (RefrescosGratis * 7));
        }

        /* Gran Total */
        TotalCompra = TotalHambDobles + TotalHambSencillas + TotalRefrescoChico + TotalRefrescoGrande;

        System.out.println("El total de los refrescos grandes es de: "+TotalRefrescoGrande);
        System.out.println("El total de los refrescos chicos es de "+TotalRefrescoChico);
        System.out.println("Por sus compras de Hamburguesas dobles usted recibe "+RefrescosGratis+" Refrescos Gratis");
        System.out.println("El total de su compra fue de: "+TotalCompra);
    }

    public static int validateNumberValue (String Valor){
        Scanner sc = new Scanner(System.in);
        int ValueTemp = 0;
        try {
            ValueTemp = Integer.parseInt(Valor);
            if(ValueTemp >= 0){
                return ValueTemp;
            }else{
                System.out.println("El valor ingresado es erroneo la cantidad no puede ser menor a cero (0).");
                System.out.println("Por favor ingrese nuevamente la cantidad");
                return validateNumberValue(sc.next());
            }
        }catch (NumberFormatException nfe) {
            System.out.println("El valor ingresado es erroneo solo puede ingresar numeros enteros.");
            System.out.println("Por favor ingrese nuevamente la cantidad");
            return validateNumberValue(sc.next());
        }
    }


}
