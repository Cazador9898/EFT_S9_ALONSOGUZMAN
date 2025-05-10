

package com.mycompany.efts9alonsoguzman;

import java.util.Scanner;
import java.util.ArrayList;


public class EFTS9ALONSOGUZMAN {

    
    
    private static ArrayList<String> asientosReservados = new ArrayList<>(); 
    private static ArrayList<String> asientosDisponibles = new ArrayList<>();
    private static ArrayList<String> asientosSeleccionados = new ArrayList<>();
    private static ArrayList<String> AsientosVIP = new ArrayList<>();
    private static ArrayList<String> AsientosPalco = new ArrayList<>();
    private static ArrayList<String> AsientosPLATEABaja = new ArrayList<>();
    private static ArrayList<String> AsientosPlateaAlta = new ArrayList<>();
    private static ArrayList<String> AsientosGaleria = new ArrayList<>();
    private static double totalapagar = 0;
    private static int EDAD = 0;
    
    
    
    
    
         static void complementarAsientos(){
        
        for (int i = 1; i < 21; i++) {
            
            asientosDisponibles.add("A"+i);
            AsientosVIP.add("A"+i);
            asientosDisponibles.add("B"+i);
            AsientosVIP.add("B"+i);
            asientosDisponibles.add("C"+i);
            AsientosPalco.add("C"+i);
            asientosDisponibles.add("D"+i);
            AsientosPalco.add("D"+i);     
            asientosDisponibles.add("E"+i);
            AsientosPLATEABaja.add("E"+i);
            asientosDisponibles.add("F"+i);
            AsientosPLATEABaja.add("F"+i);
            asientosDisponibles.add("G"+i);
            AsientosPlateaAlta.add("G"+i);
            asientosDisponibles.add("H"+i);
            AsientosPlateaAlta.add("H"+i);
            asientosDisponibles.add("I"+i);
            AsientosGaleria.add("I"+i);
            asientosDisponibles.add("J"+i);
            AsientosGaleria.add("J"+i);
   
            
        }
   
        
    }
         
    static void reservaAsientos(Scanner sc){
        
        System.out.println("Bienvenido al meno de reservas de asientos del Teatro Moror");
        System.out.println("Tenemos multiples descuentos para nuestra Funcion, por favor rellene bien sus datos para el descuento de cada entrada");
        System.out.println("Le recordamos que :");
        System.out.println("Los asientos de la fila A-B SON VIP con una valor de 10500$");
        System.out.println("Los asientos de la fila C-D SON PALCO con una valor de 8700$");
        System.out.println("Los asientos de la fila E-F SON PLATA BAJA con una valor de 6500$");
        System.out.println("Los asientos de la fila G-H SON PLATA ALTA una valor de 4500$");
        System.out.println("Los asientos de la fila I-J SON GALERIA con una valor de 1500$");
        System.out.println("");
        System.out.println("Ingrese el asiento que desea reservar (Por Ejemplo: A7): ");
        String asiento = sc.nextLine().toUpperCase();
        
        if(!asiento.matches("^[A-J]([1-9]|| 1[0-9]|| 2[0-9]$)")){
            System.out.println("Formato de asiento ivalido. Use la letra [A-J] y numero (1-20)" );
            return;
            
            
            
        }
        
        if(!asientosDisponibles.contains(asiento)){
            System.out.println("El asiento" + asiento + "No esta Disponible");
            return;
        }
        
        asientosSeleccionados.add(asiento);
        asientosDisponibles.remove(asiento);
        
        String TipoEntrada = SeleccionarTipoAsiento(asiento);
        double PrecioTipoEntrada = PrecioAsiento(TipoEntrada);
        System.out.println("El asiento"+ asiento + "("+TipoEntrada+") reservado con un valor de: $"+PrecioTipoEntrada);
        System.out.println("");
        System.out.println("¿Desea Reservar otro Asiento? (S/N):");
        String respuesta = sc.nextLine().toUpperCase();
        
        if(respuesta.equals("S")){
        reservaAsientos(sc);    
        }
     
    }         
        
    static void ImprimirBoleta(){
        if(asientosReservados.isEmpty()){
        System.out.println("NO hay asientos comprados para imprimir boleta");
        return;
        
        }
        
        System.out.println("---------------------------------");
        System.out.println("          TEATRO MORO            ");
        System.out.println("---------------------------------");
        System.out.println("     Funcion: Java La Venganza    "  );
        System.out.println("ASIENTO        TIPO        PRECIO");
        System.out.println("---------------------------------");
        
        for(String asiento:asientosReservados){
            String tipo = SeleccionarTipoAsiento(asiento);
            double precio = PrecioAsiento(tipo);
            System.out.printf("%-10s %-13s $%.2f%n", asiento, tipo, precio);
            
            
            
        }
        System.out.println("---------------------------------");
        System.out.printf(" TOTAL A PAGAR:        $%.2f%n",totalapagar );
        System.out.println("---------------------------------");
        System.out.println("     GRACIAS POR SU COMPRA       ");
        System.out.println("---------------------------------");
        
                

        
    }

    
     static void CancelarResaerva(Scanner sc){
     if(asientosReservados.isEmpty()){
        System.out.println("NO hay asientos reservados para cancelar");
        return;
        
    }
    
     System.out.println("Se procedera con la Cancelacion de su Reserva (S (si) para cancelar)");
     String cancelar = sc.next().toUpperCase(); 
     
     if(cancelar.equals("S")){
        
        System.out.println("Su reserva a sido Cancelada");
        System.out.println("Los siguientes asientos seran liberados");
        for(String asiento :asientosSeleccionados ){
            System.out.println("-"+asiento);
            asientosDisponibles.add(asiento);
         
        }
        asientosSeleccionados.clear();
        totalapagar = 0;
        System.out.println("Reserva Cancelada con Exito");
        
        
      
    }else{
        System.out.println("Se continuara con la compra");
        return;
        
        
    }
     
 }   
    
    
    static String SeleccionarTipoAsiento(String asiento){
        if(AsientosVIP.contains(asiento)){
            return "VIP";
            
        } else if(AsientosPalco.contains(asiento)){
            return "PALCO";
            
        }else if(AsientosPLATEABaja.contains(asiento)){
            return "PLATEA BAJA";
            
        }else if(AsientosPlateaAlta.contains(asiento)){
            return "PLATEA ALTA";
            
        }else if(AsientosGaleria.contains(asiento)){
            return "GALERIA";
            
        }
        return "Tipo de Asiento Invalido";
        
    }
      
    static double PrecioAsiento(String PrecioTipoAsiento){
        switch (PrecioTipoAsiento){
            case "VIP":
                return 10500;
            case "PALCO":
                return 8700;
            case "PLATEA BAJA":
                return 6500;
            case "PLATEA ALTA":
                return 4500;
            case "GALERIA":    
                return 1500;   
                
            default:
                return 0;
                
               
        }
    }
    
    
      
    
    
    static void ConfirmarCompra(Scanner sc){
    if(asientosDisponibles.isEmpty()){
        System.out.println("NO hay asientos disponibles");
        return;
        
    }
    
    System.out.println("Confirmar Compra");
    System.out.println("Asientos Reservados");
    System.out.println("Le recordamos que los descuentos no son Aplicables");
    
    
    totalapagar = 0;
    for(String asiento :asientosSeleccionados){
      String TipoEntrada = SeleccionarTipoAsiento(asiento);
      double PrecioTipoEntrada = PrecioAsiento(TipoEntrada);
        System.out.println("-"+asiento+"("+TipoEntrada+"): $"+PrecioTipoEntrada  );
        totalapagar += PrecioTipoEntrada;
    
        
    }
    
    
    
    
    System.out.println("Ingrese su SEXO (M = Masculino) (F = Femenino)");
    String DescuentoMujer = sc.next().toUpperCase(); 
    
    boolean Femenino = DescuentoMujer.equals("F");
    
    if (Femenino){
        System.out.println("Felicidades usted aplica al descuento del 20% por el dia de la mujer");
        totalapagar *=0.8;
        

    }else{
        System.out.println("Muchas gracias por compartir su informacion");
        
    }
    
    EDAD = 0;
    
    
    System.out.println("Ingrese su Edad");
    int Descuento =sc.nextInt();
    
    if (!Femenino){
        if (Descuento <= 10 ){
        System.out.println("Se a aplicado el descuento del 10% pora niños");
       
       totalapagar *=0.9;
   
        }else if (Descuento >= 55){
        System.out.println("Se a aplicado el descuento del 25% por ser de Tercera Edad");
       totalapagar *=0.75;
        
         }else if (Descuento <= 18  ){
        System.out.println("Se a aplicado el descuento del 15% por ser estudiante");
       totalapagar *=0.85;
     
        }else{
        System.out.println("No aplica descuento por su EDAD");
            
      
        }
        
        
        
    }
    
    
    
    System.out.println("Su total a pagar es de : $" +totalapagar);
    System.out.println("¿Confirma la Compra? (S/N)");
    String Confirmacion = sc.next().toUpperCase();
    
    if(Confirmacion.equals("S")){
        asientosReservados.addAll(asientosSeleccionados);
        asientosSeleccionados.clear();
        System.out.println("Compra Confirmada Gracias por su compra");
        
      
    }else{
        System.out.println("Compra Cancelada");
        return;
    }
    
  
    
}


    static void mostrarDisponibilidad(){
        System.out.println("Asientos Disponibles");
        
        if (asientosDisponibles.isEmpty()){
            System.out.println("NO HAY ASIENTOS DISPONIBLES");
            
            
        }else{
            
            for (int i = 1; i < 21; i++) {
                String fila= "";
                
                for(char letra = 'A'; letra <= 'J'; letra++){
                    String asiento = letra + String.valueOf(i);
                    
                    if(asientosDisponibles.contains(asiento)){
                        fila += asiento +" - ";
                        
                        
                    }else{
                        fila += "XX" + " - ";
                        
                    }
                    
                    
                }
                
                if(fila.endsWith(" - ")){
                    fila = fila.substring(0, fila.length() -3);
                    
                } 
                System.out.println(fila);
                
            }
            System.out.println("");
        }
        
        
    }         
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        
        complementarAsientos();
        
        do {
            System.out.println("...::VENTA DE ENTRADAS TEATRO MORO::...");
            System.out.println("Bienvenido al Teatro Moro");
            System.out.println("Nuestra Funcion para el dia de hoy : Java La venganza :");
            System.out.println("Por favor recibe los asientos disponibles antes de reservar su asiento");
            System.out.println("Los asientos de la fila A-B SON VIP");
            System.out.println("Los asientos de la fila C-D SON PALCO ");
            System.out.println("Los asientos de la fila E-F SON PLATA BAJA ");
            System.out.println("Los asientos de la fila G-H SON PLATA ALTA");
            System.out.println("Los asientos de la fila I-J SON GALERIA");
            System.out.println("Tenemos multiples descuentos para nuestra Funcion, por favor rellene bien sus datos para el descuento de cada entrada");
            System.out.println("1.- ASIENTOS DISPONIBLES");
            System.out.println("2.- RESERVAR ASIENTOS");
            System.out.println("3.- Confirmar y comprar asientos");
            System.out.println("4.- Cancelar los asientos reservados");
            System.out.println("5.- Imprimir boleta");
            System.out.println("6.- SALIR");
            
            System.out.println("Seleccione una opcion");
            opcion = sc.nextInt();
            sc.nextLine();
            
            
            
            switch (opcion){
                
                case 1:
                    System.out.println("1.- Asientos Disponibles -->");
                    mostrarDisponibilidad();
                    break;
                    
                case 2:
                    System.out.println("2.- Asientos Reservados -->");
                    reservaAsientos(sc);
                    break;
                    
                case 3:
                    System.out.println("3.- Asientos Comprados -->");
                    ConfirmarCompra(sc);
                    break;
                    
                case 4:
                    System.out.println("4.- Asientos Cancelados -->");
                    CancelarResaerva(sc);
                    break;
                case 5:
                    System.out.println("5.- Imprimir boleta -->");
                    ImprimirBoleta();
                    break;
                case 6:
                    System.out.println("5.- Muchas Gracias por su vicita -->");
                    break;
                    
                default:
                    System.out.println("Opcion Ivalida");
                    
            }
            
        } while (opcion !=6);
        
        sc.close();
        
        
        
        
       
        
    }
}
