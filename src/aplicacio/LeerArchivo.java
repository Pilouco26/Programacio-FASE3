package aplicacio;
import java.io.*;
import java.util.*;
import Dades.Classes.*;
import Dades.Llistes.LlistaIntercanvis;
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
        LlistaIntercanvis i1 = new LlistaIntercanvis(4000);
                                                      //EL TO STRING S'HA DE FER MACO
        LlegirServeis(s1);  
        LlegirBens(s1);
        LlegirIntercanvis(i1, s1, l2);
    
        WriteS(s1);
        WriteB(s1);
        WriteI(i1);
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

    public static void LlegirIntercanvis(LlistaIntercanvis i1, LlistaProductes p1, LlistaUsuaris u1) throws FileNotFoundException{

        File fitxerS = new File("intercanvis.txt");
        Scanner fileS = new Scanner(fitxerS);
        while(fileS.hasNextLine())
        {
            
            Intercanvi I1 = ReadI(fileS, p1, u1);
            i1.AfegirIntercanvi(I1);                                //NO AFEGEIX CAP PRODUCTE
            
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
        int dia1, mes1, any1, dia2, mes2, any2, dia3, mes3, any3;
        Data data, datafi;
        double amplada, alçada, fons, pes;
        Boolean intercanviat;

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
                intercanviat = Boolean.parseBoolean(Producte.nextToken());
                Producte Be= new Bens(nom, descripcio, data, amplada, alçada, fons, pes);
                ((Bens)Be).setIntercanvi(intercanviat);
                if(intercanviat){

                    StringTokenizer data3 = new StringTokenizer(Producte.nextToken(), "/");
                    dia3 = Integer.parseInt(data3.nextToken());
                    mes3 = Integer.parseInt(data3.nextToken());
                    any3 = Integer.parseInt(data3.nextToken());

                    datafi = new Data(dia3, mes3, any3);
                    ((Bens)Be).setData(datafi);
                }

                return Be;

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
        bw.write(s1.GetBens().toString());                                    
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

    public static void WriteI(LlistaIntercanvis i1)
    {
        BufferedWriter bw = null;
        try{    
        File fitxerSC = new File("intercanvis.txt");
        FileWriter fw = new FileWriter(fitxerSC);
        bw = new BufferedWriter(fw);
        bw.write(i1.toString());                                   
        System.out.println("Intercanvis escrits!");

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

    public static Intercanvi ReadI(Scanner FileI, LlistaProductes p1, LlistaUsuaris u1)
    {
        int codi, ivaloracio, ovaloracio;
        boolean trato, resposta;
        String interessat, contesta;
        String demanat, oferit;
        Usuari interessat2, contesta2;
        Producte demanat2, oferit2;

       
        String intercanvis = FileI.nextLine();

        StringTokenizer intercanvi = new StringTokenizer(intercanvis, ";");
        codi = Integer.parseInt(intercanvi.nextToken());
        interessat = intercanvi.nextToken();
        contesta = intercanvi.nextToken();
        demanat = intercanvi.nextToken();
        oferit = intercanvi.nextToken();
        resposta = Boolean.parseBoolean(intercanvi.nextToken());
        trato = Boolean.parseBoolean(intercanvi.nextToken());
        ivaloracio = Integer.parseInt(intercanvi.nextToken());
        ovaloracio = Integer.parseInt(intercanvi.nextToken());
        interessat2 = u1.TrobaUsuari(interessat);
        contesta2 = u1.TrobaUsuari(contesta);
        demanat2 = p1.TrobaCodi(demanat);
        oferit2 = p1.TrobaCodi(oferit);
        Intercanvi nou = new Intercanvi(codi, interessat2, contesta2, demanat2, oferit2);
        nou.setIvaloracio(ivaloracio);
        nou.setOvaloracio(ovaloracio);
        nou.setResposta(resposta);
        nou.setTrato(trato);

        return nou;
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
        


