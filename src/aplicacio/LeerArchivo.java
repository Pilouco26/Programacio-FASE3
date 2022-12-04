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
        
       

        /*OBTENIR LES LINIES DEL FITXER AMB CLASSE SCANNER */
        File fitxer = new File("usuari.txt");
        Scanner file = new Scanner(fitxer);
        
        Data actual = new Data(04, 12, 2022);

        String Alies, email, Usuari;
        String nom, descripcio, servei;
        Data data, datafi;
        int cp;
        int dia1, mes1, any1, dia2, mes2, any2;

        
        int i=0;

        LlistaUsuaris l1 = new LlistaUsuaris(4000); 

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
        LlistaUsuaris l2 = new LlistaUsuaris(l1.getnElem());
        readData(l2, l1.getnElem());
        System.out.println(l2.toString());

       /*CLASSE SERVEI */
       
        /*OBTENIR LES LINIES DEL FITXER AMB CLASSE SCANNER */
        File fitxerS = new File("servei.txt");
        Scanner fileS = new Scanner(fitxerS);

        LlistaProductes s1  = new LlistaProductes(4000);

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

            Producte padre = new Servei(nom, descripcio, data, datafi);             //IF HAS NEXT TOKEN PER BENS
            System.out.println(padre.toStringMaco());
            ((Servei)padre).actiu(actual);
            s1.afegirProductes(padre);

        }
        fileS.close();                                                      //EL TO STRING S'HA DE FER MACO

        System.out.println("Afegir servei");
        String nom1 = teclat.nextLine();
        String descripcio1 = teclat.nextLine();
        String DataI = teclat.nextLine();
        StringTokenizer DataIT = new StringTokenizer(DataI, "/");       /*S'ha de crear excepció per evitar dates mal posades */
        int diaT = Integer.parseInt(DataIT.nextToken());
        int mesT = Integer.parseInt(DataIT.nextToken());
        int anyT = Integer.parseInt(DataIT.nextToken());
        Data DataITT = new Data(diaT, mesT, anyT);
        String DataIP = teclat.nextLine();
        StringTokenizer DataIPT = new StringTokenizer(DataIP, "/");
        int diaTT = Integer.parseInt(DataIPT.nextToken());
        int mesTT = Integer.parseInt(DataIPT.nextToken());
        int anyTT = Integer.parseInt(DataIPT.nextToken());
        Data DataITT5 = new Data(diaTT, mesTT, anyTT);

        Producte afegit = new Servei(nom1, descripcio1, DataITT, DataITT5);
        ((Servei)afegit).actiu(actual);
        s1.afegirProductes(afegit);



        BufferedWriter bw = null;
        try{    
        File fitxerSC = new File("servei.txt");
        FileWriter fw = new FileWriter(fitxerSC);
        bw = new BufferedWriter(fw);
        bw.write(s1.toString());
        System.out.println("File written Successfully");

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
         finally
         { 
            try{
                if(bw!=null)
                bw.close();
            }catch(Exception ex){
                
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
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
        


