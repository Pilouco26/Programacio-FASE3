package aplicacio;

import java.util.Scanner;

import Exception.ValorNoOk;
public class ProgramaPrincipal {
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args){
    boolean sortir=false;

    int limit1= 1;
    int limit2 =4;
    
    System.out.println("Hola que tal broski.. etc etc i el menu\n");
    int menu = llegirEnter(limit1, limit2);

    while(!sortir) 
    {
        switch(menu)
        {

            case 1:             //Llistes
                limit2=3;
                System.out.println("Where u goin bih???");
                Llistes(llegirEnter(limit1, limit2)); 
            
            case 2:             //intercanvis



            case 3:             //usuari



            case 4:            //sortir
        }
    }






    }


    private static void Llistes(int menu)
    {
        int limit1=1;
        int limit2 = 3;
        switch(menu)
        {
            case 1: 
                System.out.println("Quina tipus de llista vols selecionar?");
                TotesLlistes(llegirEnter(limit1, limit2));

            case 2: 

                //Serveis actius

            case 3: 

                //Bens disponibles

        }
    }

    private static void TotesLlistes(int menu)
    {

        switch(menu) {

            case 1: //intercanvis

            case 2: //producte

                System.out.println("FUNCIONA");
            case 3: //serveis

            case 4: //usuaris

            case 5: //bens
        }


    }

    /**
     * funcio per tenir un delay, rep els segons per parametre
    * @param s --> segons que volem de retard
    */
    public static void delay(int s) {						
        try {
        Thread.sleep(s * 1000);
        } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
        }
        }
    

    public static int llegirEnter(int vMin, int vMax){                //ampliar amb el rang del menu

        boolean llegit= false;
        int num=0;

        while(!llegit){

            try{
                num=Integer.parseInt(teclat.nextLine());
                llegit= true;
                if (num<vMin) throw new ValorNoOk(num);
                if (num>vMax) throw new ValorNoOk(num);
            }catch(NumberFormatException e){
                System.out.println("ERROR, POSA UN PUTO NUMERO IL MENDIGATO :)");
            }catch(ValorNoOk e){
                System.out.println("POSA UN NUMERO DEL MENU");
                llegit=false;
            }

        
        }


        return num;
    }
    }