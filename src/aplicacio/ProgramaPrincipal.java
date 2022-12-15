package aplicacio;
import Dades.Llistes.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import Dades.Classes.*;
import Exception.AliesRepetit;
import Exception.*;

public class ProgramaPrincipal {
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException{
        System.out.println(DataActual().toString());
        LlistaUsuaris l1 = new LlistaUsuaris(4000); 
        LlistaProductes s1  = new LlistaProductes(4000);
        LlistaIntercanvis i1 = new LlistaIntercanvis(4000);
        boolean sortir = false;
        boolean tornar = false; 
        LlegirUsuari(l1);
       
       
        /*SERIALITZAR LA CLASSE USUARI */
        storeData(l1);
        LlistaUsuaris l2 = new LlistaUsuaris(4000);
        readData(l2,l1.getnElem());
       


        Llegir(i1, s1, l2);  

        

       


    
    

    while(!sortir) 
    {
        int menu=menu();
        tornar=false;
        switch(menu)
        {

            case 1:             //Llistes
                
                while(!tornar){
                    
                    
                    switch(menuLlistes())
                        {
                            case 1:

                            while(!tornar){

                                    switch(seleccioLlistes())
                                    {
                                        case 1: 
                                            System.out.println("Llista Intercanvis");
                                        break;

                                        case 2: 
                                            
                                        System.out.println("Llista Productes:\n"+s1.toStringMaco());
                                        break;

                                        case 3: 
                        
                                            System.out.println("Llista Serveis:\n"+s1.GetServeis().toStringMaco());
                                        break;

                                        case 4: 
                                            System.out.println("Llista Bens:\n"+s1.GetBens().toStringMaco());
                                        break; 

                                        case 5: 
                                        System.out.println("Llista Bens:\n"+l1.toString());
                                        break; 

                                        case 6:

                                            tornar = true;
                                        break;
                                    }
                                }
                          
                            break;

                            case 2: 
                            LlistaProductes a= s1.ServeisActius();
                            System.out.println(a.toStringMaco());
                            System.out.println("\n\n");
                            delay(2000);

                            break;

                            case 3: 
                            LlistaProductes B = s1.BensActius();
                            System.out.println(B.toStringMaco());
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
            
                while(!tornar)
                {
                    tornar=false;
                    switch(menuIntercanvis())
                    {
                        case 1:

                        
                        while(!tornar)
                        {
                            System.out.println(" [1] Afegir Bé\n [2] Afegir Petició d'intercanvi\n [3] Afegir Servei\n [4] Tornar al menu Intercanvis\n");
                            int num =llegirEnter(1, 4);

                        
                            switch(num)
                            {

                                case 1: 

                                Producte Benou = AfegirProducteB();
                                s1.afegirProductes(Benou);
                        

                                break;



                                case 2: 


                                break;



                                case 3: 
                                Producte nou = AfegirProducteS();
                                ((Servei)nou).actiu(DataActual());
                                s1.afegirProductes(nou);
                                break; 
                                
                                case 4: 

                                tornar = true;

                                break; 
                            }
                        }
                        break;


                        case 2: 

                        break;

                        case 3: 

                        break;


                        case 4: 

                        break;

                        case 5: 

                        break; 

                        case 6: 

                        tornar= true;

                        break;
                    }
                }
                
            

            break;
            case 3:             //usuari


            break;
            case 4:            //sortir
            
            Escriure(i1, s1);
    
            System.exit(0);
            break; 
        }
    }


    }


    private static int menu()
    {
        int limit1 = 1;
        int limit2 = 4;
        System.out.println("\n\t\t\t\t\t[MENU PRNICPAL]    \n    [1] Consultar Llistes\n    [2] Intercanvis \n    [3] Usuari \n    [4] Sortir de l'aplicació");
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

    private static int seleccioLlistes()
    {
        int limit1= 1;
        int limit2 =6;
        System.out.println(" [1] Consultar Intercanvis\n [2] Consultar Productes\n [3] Consultar Serveis\n [4] Consultar Bens\n [5] Consultar Usuaris\n [6] Tornar al menu principal");

        return llegirEnter(limit1, limit2);
    }

    private static int menuIntercanvis()
    {
        int limit1= 1;
        int limit2= 6;

        System.out.println("\t\t\t  [INTERCANVIS] \n\n [1] Afegir Productes o intercanvis\n [2] Aceptar/Refusar Intercanvi\n [3] Donar de Baixa Usuari/Bé\n [4] Mostrar Peticions\n [5] Servei més popular\n [6] Tornar al menu principal");
        return llegirEnter(limit1, limit2);
    }

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
    public static void Llegir(LlistaIntercanvis i1, LlistaProductes p1, LlistaUsuaris l2) throws FileNotFoundException 
    {
        LlegirServeis(p1, DataActual());  
        LlegirBens(p1);
        LlegirIntercanvis(i1, p1, l2);

    }
    public static void Escriure(LlistaIntercanvis i1, LlistaProductes s1) throws FileNotFoundException 
    {
        WriteS(s1);
        WriteB(s1);
        WriteI(i1);
    }

    public static Data DataActual()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        StringTokenizer dat = new StringTokenizer(dtf.format(now), "/");
        int dia =  Integer.parseInt(dat.nextToken());  
        int mes =  Integer.parseInt(dat.nextToken());
        int any =  Integer.parseInt(dat.nextToken());
        return new Data(dia, mes, any);
    }



    public static void LlegirBens(LlistaProductes s1) throws FileNotFoundException
    {
    
        File fitxerB = new File("bens.txt");
        Scanner fileB = new Scanner(fitxerB);
        while(fileB.hasNextLine())
        {
            Producte padre = ReadP(fileB,1);
                                                                //S'HA D'AFEGIR LA DATA D'INTERCANVI AL LLEGIR
            s1.afegirProductes(padre);                          //mirar que si esta en true, te data

        }
        fileB.close(); 
    }

    public static void LlegirServeis(LlistaProductes s1, Data actual) throws FileNotFoundException{

       
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


    public  static Producte AfegirProducteS()
    {
        System.out.println("Afegir servei:");
        String nom1 = teclat.nextLine();
        System.out.println("\nAfegir descripció:");
        String descripcio1 = teclat.nextLine();
        Data DataITT = DataActual();
        System.out.println("\nAfegir data final (dd/mm/aaaa):");
        String DataIP = teclat.nextLine();
        StringTokenizer DataIPT = new StringTokenizer(DataIP, "/");          /*S'ha de crear excepció per evitar dates mal posades */
        int diaTT = Integer.parseInt(DataIPT.nextToken());                          /* Una altra per evitar posar dates inferiors a la data actual */
        int mesTT = Integer.parseInt(DataIPT.nextToken());
        int anyTT = Integer.parseInt(DataIPT.nextToken());
        Data DataITT5 = new Data(diaTT, mesTT, anyTT);
        String codi = GenCodiProducte();
        return new Servei(codi, nom1, descripcio1, DataITT, DataITT5);


    }
    public static Producte AfegirProducteB()
    {
        System.out.println("Afegir Bé:");
        String nom1 = teclat.nextLine();
        System.out.println("\nAfegir descripció:");
        String descripcio1 = teclat.nextLine();                                                       
        Data DataITT = DataActual();                                /*S'ha de crear excepció per evitar dates mal posades */
        System.out.println("\nDefinir amplada:");
        double amplada = Double.parseDouble(teclat.nextLine());
        System.out.println("\nDefinir alçada:");
        double alçada = Double.parseDouble(teclat.nextLine());
        System.out.println("\nDefinir fons:");
        double fons = Double.parseDouble(teclat.nextLine());
        System.out.println("\nDefinir pes en kilograms:");
        double pesKG = Double.parseDouble(teclat.nextLine());
        String codi = GenCodiProducte();
        return new Bens(codi, nom1, descripcio1, DataITT, amplada, alçada, fons, pesKG);


    }

    public static Producte ReadP(Scanner fileS, int tipus)
    {
        String codi, nom, descripcio, servei;
        int dia1, mes1, any1, dia2, mes2, any2, dia3, mes3, any3;
        Data data, datafi;
        double amplada, alçada, fons, pes;
        Boolean intercanviat;

        servei = fileS.nextLine();
            StringTokenizer Producte = new StringTokenizer(servei, ";");
            codi= Producte.nextToken();
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
                return new Servei(codi, nom, descripcio, data, datafi);  
            }
            else
            {
                amplada = Double.parseDouble(Producte.nextToken());
                alçada =  Double.parseDouble(Producte.nextToken());
                fons =    Double.parseDouble(Producte.nextToken());
                pes  =    Double.parseDouble(Producte.nextToken());
                intercanviat = Boolean.parseBoolean(Producte.nextToken());
                Producte Be= new Bens(codi, nom, descripcio, data, amplada, alçada, fons, pes);
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

    public static void LlegirUsuari(LlistaUsuaris l1) throws FileNotFoundException{
        File fitxer = new File("usuari.txt");
        Scanner file = new Scanner(fitxer);
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
    }

    public static void WriteS(LlistaProductes s1)
    {
        BufferedWriter bw = null;
        try{    
        File fitxerSC = new File("servei.txt");
        FileWriter fw = new FileWriter(fitxerSC);
        bw = new BufferedWriter(fw);
        bw.write(s1.GetServeis().toString());                                    /* S'HA D'ESCRIURE NOMÉS LA MERDA DELS SERVEIS */
        System.out.println("Serveis escrits!");

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
        bw.write(s1.GetBens().toString());                  //FALTA ESCRIURE LA DATA DEL INTERCANVIAT                                   
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
        demanat2 = p1.Trob4aCodi(demanat);
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

    
    public static String GenCodiProducte() {
        int leftLimit = 65; // letter 'a'
        int rightLimit = 90; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
        
        return generatedString;                         //FALTA MIRAR QUE NO ESTIGUI REPETIT
    }
}