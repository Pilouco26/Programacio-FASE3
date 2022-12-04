package aplicacio;
import java.io.*;
import java.util.*;
import Dades.Classes.*;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import Exception.AliesRepetit;


public class LeerArchivo {

    static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        
        /*LLEGIR LA QUANTITAT DE USUARIS QUE TENIM DINS LA LLISTA */
        BufferedReader reader = new BufferedReader(new FileReader("usuari.txt"));
        int numUsuaris = 0;
        while (reader.readLine() != null) numUsuaris++;
        reader.close();

        /*OBTENIR LES LINIES DEL FITXER AMB CLASSE SCANNER */
        File fitxer = new File("usuari.txt");
        Scanner file = new Scanner(fitxer);
        

        String Alies, email, Usuari;
        String nom, descripcio, servei;
        Data data, datafi;
        int cp;
        int dia1, mes1, any1, dia2, mes2, any2;

        
        int i=0;

        LlistaUsuaris l1 = new LlistaUsuaris(numUsuaris); 

        /*CONSTRUIR LLISTA USUARIS */ 
        while(file.hasNextLine())
        {
            Usuari= file.nextLine();
        
            StringTokenizer prova = new StringTokenizer(Usuari, ";");
            Alies = prova.nextToken();
            email = prova.nextToken();
            cp = Integer.parseInt(prova.nextToken());
            Usuari u1 = new Usuari(Alies, email, cp);
            try {
                l1.AfegirUsuari(u1);
            } catch (AliesRepetit e) {
                
                System.out.println("Usuari Repetit, posició["+i+"]");
                
            }
            i++;
        }
        file.close();
        
        /*SERIALITZAR LA CLASSE USUARI */
        storeData(l1);
        LlistaUsuaris l2 = new LlistaUsuaris(numUsuaris);
        readData(l2, numUsuaris);

       /*CLASSE SERVEI */
      
        /*LLEGIR LA QUANTITAT DE USUARIS QUE TENIM DINS LA LLISTA */
        BufferedReader readerS = new BufferedReader(new FileReader("servei.txt"));
        int numServeis= 0;
        while (readerS.readLine() != null) numServeis++;
        readerS.close();

        /*OBTENIR LES LINIES DEL FITXER AMB CLASSE SCANNER */
        File fitxerS = new File("servei.txt");
        Scanner fileS = new Scanner(fitxerS);

        LlistaProductes s1  = new LlistaProductes(numServeis);

        while(fileS.hasNextLine())
        {
            servei = fileS.nextLine();
            StringTokenizer prova = new StringTokenizer(servei, ";");
            nom = prova.nextToken();
            descripcio = prova.nextToken();
            StringTokenizer data1 = new StringTokenizer(prova.nextToken(), "/");

            dia1 = Integer.parseInt(data1.nextToken()) ;
            mes1 = Integer.parseInt(data1.nextToken());
            any1 = Integer.parseInt(data1.nextToken());

            data= new Data(dia1, mes1, any1);

            StringTokenizer data2 = new StringTokenizer(prova.nextToken(), "/");
            
            dia2 = Integer.parseInt(data2.nextToken()) ;
            mes2 = Integer.parseInt(data2.nextToken());
            any2 = Integer.parseInt(data2.nextToken());

            datafi= new Data(dia2, mes2, any2);

            Producte padre = new Servei(nom, descripcio, data, datafi);

            s1.afegirProductes(padre);

        }
        fileS.close();

        System.out.println(s1.toString());

        }



       










            public static void storeData (LlistaUsuaris list) {
                ObjectOutputStream outputFile;
                try {
                outputFile = new ObjectOutputStream(new FileOutputStream("Usuari.ser"));
                for (int i=0; i<list.getnElem(); i++) {
                outputFile.writeObject(list.StoreData(i));
                }
                outputFile.close();
                }
                catch (IOException e) {
                System.out.println("Error en l'arxiu de sortida.");
                }
    
             }

             public static void readData (LlistaUsuaris list, int numUsuaris) {
                ObjectInputStream inputFile;
                try {
                inputFile = new ObjectInputStream(new FileInputStream("Usuari.ser"));
                for (int i=0; i<numUsuaris; i++) {
                try {
                    list.AfegirUsuari((Usuari)inputFile.readObject());
                } catch (AliesRepetit e) {
                    System.out.println("Atenció, alies repetit");
                }
               
                }
                inputFile.close();
                }
                catch (IOException e) {
                System.out.println("Error en l'arxiu d'entrada.");
                }
                catch (ClassNotFoundException e) {
                System.out.println("Error, no es troba la classe Usuari."+e);
                }
                catch (ClassCastException e){
                System.out.println("Error, el format de l'arxiu no és correcte per la definició actual de la classe Usuari."+e);
                }
                }


        
}
        


