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
        LlistaUsuaris l1 = new LlistaUsuaris(4000); 
        int i=0;

        /*CONSTRUIR LLISTA USUARIS */ 
        while(file.hasNextLine())
        {
            Usuari u1= ReadU(file);
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
        
        LlistaProductes s1  = new LlistaProductes(4000);

                                                          //EL TO STRING S'HA DE FER MACO
        LlegirServeis(s1);
        LlegirBens(s1);
    
        WriteS(s1);
        WriteB(s1);
    }








    public static void LlegirBens(LlistaProductes s1) throws FileNotFoundException
    {
    
        File fitxerB = new File("bens.txt");
        Scanner fileB = new Scanner(fitxerB);
        while(fileB.hasNextLine())
        {
            Producte padre = ReadP(fileB,1);
                                                                //S'HA D'AFEGIR LA DATA D'INTERCANVI AL LLEGIR
            s1.afegirProductes(padre);

        }
        fileB.close(); 
    }

    public static void LlegirServeis(LlistaProductes s1) throws FileNotFoundException{

        Data actual = new Data(04, 12, 2022);
        File fitxerS = new File("servei.txt");
        Scanner fileS = new Scanner(fitxerS);
        while(fileS.hasNextLine())
        {
           // System.out.println(ReadP(fileS).toStringMaco());
            Producte padre = ReadP(fileS, 0);
            ((Servei)padre).actiu(actual);
            s1.afegirProductes(padre);

        }
        fileS.close();   
    }


    public static Producte AfegirProducteS()
    {
        System.out.println("Afegir servei:");
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

        return new Servei(nom1, descripcio1, DataITT, DataITT5);


    }

    public static Producte ReadP(Scanner fileS, int tipus)
    {
        String nom, descripcio, servei;
        int dia1, mes1, any1, dia2, mes2, any2;
        Data data, datafi;
        double amplada, alçada, fons, pes;

        servei = fileS.nextLine();
            StringTokenizer Producte = new StringTokenizer(servei, ";");
            nom = Producte.nextToken();
            descripcio = Producte.nextToken();
            StringTokenizer data1 = new StringTokenizer(Producte.nextToken(), "/");

            dia1 = Integer.parseInt(data1.nextToken());
            mes1 = Integer.parseInt(data1.nextToken());
            any1 = Integer.parseInt(data1.nextToken());

            data= new Data(dia1, mes1, any1);

            if(tipus==0)
            {
                StringTokenizer data2 = new StringTokenizer(Producte.nextToken(), "/");
                dia2 = Integer.parseInt(data2.nextToken()) ;
                mes2 = Integer.parseInt(data2.nextToken());
                any2 = Integer.parseInt(data2.nextToken());

                datafi= new Data(dia2, mes2, any2);
                return new Servei(nom, descripcio, data, datafi);  
            }
            else
            {
                amplada = Double.parseDouble(Producte.nextToken());
                alçada =  Double.parseDouble(Producte.nextToken());
                fons =    Double.parseDouble(Producte.nextToken());
                pes  =    Double.parseDouble(Producte.nextToken());

                return new Bens(nom, descripcio, data, amplada, alçada, fons, pes);

            }
                       //IF HAS NEXT TOKEN PER BENS

    }

    public static Usuari ReadU(Scanner file) 
    {
        int cp;
        String Alies, email, Usuari;       
        Usuari= file.nextLine();
        
            StringTokenizer prova = new StringTokenizer(Usuari, ";");
            Alies = prova.nextToken();
            email = prova.nextToken();
            cp = Integer.parseInt(prova.nextToken());
           return new Usuari(Alies, email, cp);


    }



    public static void WriteS(LlistaProductes s1)
    {
        BufferedWriter bw = null;
        try{    
        File fitxerSC = new File("servei.txt");
        FileWriter fw = new FileWriter(fitxerSC);
        bw = new BufferedWriter(fw);
        bw.write(s1.GetServeis().toString());                                    /* S'HA D'ESCRIURE NOMÉS LA MERDA DELS SERVEIS */
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

    public static void WriteB(LlistaProductes s1)
    {
        BufferedWriter bw = null;
        try{    
        File fitxerSC = new File("bens.txt");
        FileWriter fw = new FileWriter(fitxerSC);
        bw = new BufferedWriter(fw);
        bw.write(s1.GetBens().toString());                                    /* S'HA D'ESCRIURE NOMÉS LA MERDA DELS SERVEIS */
        System.out.println("Bens escrits!");

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

    public void ReadI(Scanner FileI)
    {
        int codi, ivaloracio, ovaloracio;
        boolean trato, resposta;
        Usuari interessat, contesta;
        Producte demanat, oferit;

        int cp;
        String Alies, email; 
       
        String intercanvis = FileI.nextLine();

        StringTokenizer intercanvi = new StringTokenizer(intercanvis, ";");
        codi = Integer.parseInt(intercanvi.nextToken());
        Alies = intercanvi.nextToken();
        email = intercanvi.nextToken();
        cp = Integer.parseInt(intercanvi.nextToken());
        interessat = new Usuari(Alies, email, cp);

        Alies = intercanvi.nextToken();
        email = intercanvi.nextToken();
        cp = Integer.parseInt(intercanvi.nextToken());
        contesta = new Usuari(Alies, email, cp);

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
        


