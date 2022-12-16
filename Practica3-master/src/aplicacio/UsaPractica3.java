package aplicacio;

import Dades.Classes.Data;
import Dades.Classes.Intercanvi;
import Dades.Classes.Usuari;
import Dades.Classes.Bens;
import Dades.Classes.Servei;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import Exception.AliesRepetit;

public class UsaPractica3 {

    public static void main(String[] args){
    
    Usuari s1 = new Usuari("Albert","pilouco2602@gmail.com", 500);           //Proves
    Usuari s2 = new Usuari("Albart","pilouco2602@gmail.com", 400);
    Usuari s3 = new Usuari("Albarta","pilouco2602@gmail.com", 400);
    LlistaUsuaris u1 = new LlistaUsuaris(3);
    LlistaProductes p1 = new LlistaProductes(5);
    
    try{
        u1.AfegirUsuari(s3);
    }catch(AliesRepetit exc){
        System.out.println(exc.toString());
    }
    try{
        u1.AfegirUsuari(s2);
    }catch(AliesRepetit exc){
        System.out.println(exc.toString());
    }
    try{
        u1.AfegirUsuari(s1);
    }catch(AliesRepetit exc){
        System.out.println(exc.toString());
    }
    
    Data d1= new Data(2, 2, 20);
    Data d2= new Data(2, 2, 22);
    Data d3= new Data(2, 5, 21);
    Servei ss1 = new Servei("LA 33", "yessir", 1, d1, d3);
    Bens b2 = new Bens("PADREO", "guapa", 0, d2, 20, 15, 10, 60);
    Bens b3 = new Bens("PADREADA", "guapa", 0, d2, 20, 15, 10, 60);
    Bens b4 = new Bens("PEDRODELASOJA", "guapa", 0, d2, 20, 15, 10, 60);

    s1.afegirProductes(ss1);
    s1.afegirProductes(ss1);
    s1.afegirProductes(ss1);
    s2.afegirProductes(b2);
    p1.afegirProductes(b2);
    p1.afegirProductes(b3);
    p1.afegirProductes(b4);
    p1.afegirProductes(ss1);


    System.out.println("Numero de productes: " +s1.getNumProductes()+"\n");
       
    Intercanvi i1 = new Intercanvi(999, s1, s2, ss1, b2);
    System.out.println(i1.toString());
    System.out.print(ss1+"\n");
    s2.afegirIntercanvis(i1);
    try{
        u1.AfegirUsuari(s1);
    }catch(AliesRepetit exc){
        System.out.println(exc.toString());
    }
    try{
        u1.AfegirUsuari(s2);
    }catch(AliesRepetit exc){
        System.out.println(exc.toString());
    }
    
    System.out.println(u1.toString()+"\n");  // FALTA IMPRIIMIR LA LLISTA DE PRODUCTE I LA LLISTA DE INTERCANVIS
    
    }
  


}