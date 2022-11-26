package aplicacio;

import java.util.Scanner;

import Dades.Classes.*;
import Dades.Llistes.LlistaProductes;
import Exception.ValorNoOk;

public class ProgramaPrincipal {
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args){

    int linies=5;
    boolean sortir=false;
    boolean tornar = false; 
    Data d1= new Data(2, 5, 21);
    Data d2= new Data(2, 2, 22);
    Data actual= new Data(2, 5, 21);
    Producte prova= new Servei("YY", "YY", d1, d2);
    ((Servei)prova).actiu(actual);
    System.out.println(((Servei)prova).getActiu());
    LlistaProductes p = new LlistaProductes(linies);
    p.afegirProductes(prova);

    //Prova Serveis Actius
    Producte ñ = new Servei("4", "4", d2, actual);
    p.afegirProductes(ñ);
    LlistaProductes a= p.ServeisActius();
  

    //Prova Bens actius
    Producte bProva = new Bens("Padre", "Padre", actual, 50, 20, 10, 35.2);
    //((Bens)bProva).Intercanviat();
   
    p.afegirProductes(bProva);
    LlistaProductes B = p.BensActius();

   
    
    

    while(!sortir) 
    {
        int menu=menu();
        switch(menu)
        {

            case 1:             //Llistes
                
                while(!tornar){
                    
                    
                    switch(menuLlistes())
                        {
                            case 1:
                            
                            System.out.println(p.toString());
                            System.out.println("\n\n");
                            delay(2000);
                            break;

                            case 2: 

                            System.out.println(a.toString());
                            System.out.println("\n\n");
                            delay(2000);

                            break;

                            case 3: 

                            System.out.println(B.toString());
                            System.out.println("\n\n");
                            delay(2000);
                            break; 
                            
                            case 4: 
                            tornar=true;
                            break; 
                        }
                }
            
            break;
            
            case 2:             //intercanvis

            
            break;
            case 3:             //usuari


            break;
            case 4:            //sortir

            System.exit(0);
            break; 
        }
    }


    }


    private static int menu()
    {
        int limit1 = 1;
        int limit2 = 4;
        System.out.println("\n\n\n\t\t\t\t\t[MENU PRNICPAL]    \n    [1] Consultar Llistes\n    [2] Intercanvis \n    [3] Usuari \n    [4] Sortir de l'aplicació");
        int menu = llegirEnter(limit1, limit2);

        return menu;
    }

    private static int menuLlistes()
    {
        int limit1=1;
        int limit2 = 4;
        System.out.println(" [1] Consultar totes les llistes\n [2] Serveis Actius\n [3] Bens disponibles\n [4] Tornar al menu principal");
        

        return llegirEnter(limit1, limit2); 
        
    }

    /*private static void Llistes(int menu)
    {
        int limit1=1;
        int limit2 = 3;
        switch(menu)
        {
            case 1: 
                System.out.println("Quina tipus de llista vols selecionar?");
                TotesLlistes(llegirEnter(limit1, limit2));

            case 2: 

            
           
            
            break;
            case 3: 

                //Bens disponibles

        }
        
    }*/

    /*private static void TotesLlistes(int menu)
    {

        switch(menu) {

            case 1: //intercanvis

            case 2: //producte

                System.out.println("FUNCIONA");
            case 3: //serveis

            case 4: //usuaris

            case 5: //bens
        }


    }*/

    /**
     * funcio per tenir un delay, rep els segons per parametre
    * @param s --> segons que volem de retard
    */
    public static void delay(int ms) {						
        try {
        Thread.sleep(ms);
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