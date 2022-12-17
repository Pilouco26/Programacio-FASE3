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
       


        Llegir(i1, s1, l1);  

    

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
                                            System.out.println("Llista Intercanvis:\n"+i1.toStringMaco());
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
                                        System.out.println("Llista Usuaris:\n"+l1.toString());
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

                                Producte Benou = AfegirProducteB(s1);
                                s1.afegirProductes(Benou);
                        

                                break;



                                case 2: 

                                Intercanvi  IntercanviNou = AfegirIntercanvi(l1, s1);
                                i1.AfegirIntercanvi(IntercanviNou);

                                break;



                                case 3: 
                                Producte nou = AfegirProducteS(s1);
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

                        Contestar(l1, i1);
                        
                        break;

                        case 3: 

                        System.out.println("Escriu l'indicador del producte que vols donar de baixa:\n");
                        String codi = teclat.nextLine();
                        int k = s1.CercaCodiS(codi);
                        if(k!=-1) s1.DonarBaixaServei(codi, k);
                        else System.out.println("Aquest servei no existeix");

                        break;


                        case 4: 

                            System.out.println("Escriu l'indicador del producte que vols donar de baixa:\n");
                            String codi2 = teclat.nextLine();
                            if(s1.intercanviable(codi2)) s1.DonarBaixaBe(codi2);
                            else System.out.println("L'indicador no existeix o ja ha estat intercanviat ://\n");
                        break;

                        case 5: 

                        break; 

                        case 6: 

                        

                        break;
                        case 7: 

                        tornar=true;
                        break;
                    }
                }
                
            

            break;
            case 3:             //usuari

                while(!tornar)
                {

               
                    switch(menuUsuari())
                    {
                        case 1: 

                        try {
                            l1.AfegirUsuari(AfegirUsuari());
                        } catch (AliesRepetit e) {
                            
                            System.out.println("L'alies ja està seleccionat :(");
                        }
                        

                        break; 


                        case 2: 


                        break;


                        case 3: 

                        tornar = true;
                        break; 
                    }

                }
            break;
            case 4:            //sortir
            
            Escriure(i1, s1);
            storeData(l1);
    
            System.exit(0);
            break; 
        }
    }


    }

    /*MENUS */
    private static int menu()
    {
        int limit1 = 1;
        int limit2 = 4;
        System.out.println("\n\t\t\t\t\t[MENU PRNICPAL]    \n    [1] Consultar Llistes\n    [2] Intercanvis \n    [3] Usuari \n    [4] Sortir de l'aplicació");
        int menu = llegirEnter(limit1, limit2);

        return menu;
    }

    private static int menuUsuari()
    {
        int limit1 = 1;
        int limit2 = 3;
        System.out.println("\n\t\t\t\t\t[MENU PRNICPAL]    \n    [1] Donar d'alta Usuari\n    [2] Mostrar Usuaris segons valoració \n    [3] Sortir del menú Usuari");
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
        int limit2= 7;

        System.out.println("\t\t\t  [INTERCANVIS] \n\n [1] Afegir Productes o intercanvis\n [2] Aceptar/Refusar Intercanvi\n [3] Donar de Baixa Servei\n [4] Donar de Baixa Bé\n [5] Mostrar Peticions\n [6] Servei més popular\n [7] Tornar al menu principal");
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
                System.out.println("ERROR, POSA UN  NUMERO :)");
            }catch(ValorNoOk e){
                System.out.println("POSA UN NUMERO DEL MENU");
                llegit=false;
            }

        
        }


        return num;
    }
    public static void Llegir(LlistaIntercanvis i1, LlistaProductes p1, LlistaUsuaris l1) throws FileNotFoundException 
    {
        LlegirServeis(p1, DataActual());  
        LlegirBens(p1);
        readData(l1);
        /*SERIALITZAR LA CLASSE USUARI */
        storeData(l1);
        LlegirIntercanvis(i1, p1, l1); //Necessita petits tweaks


    }
    public static void Escriure(LlistaIntercanvis i1, LlistaProductes s1) throws FileNotFoundException 
    {
        WriteS(s1);
        WriteB(s1);
        WriteI(i1); //Necessita petits tweaks
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

    /*AFEGIR USUARIS, PRODUCTES I INTERCANVIS */

    public  static Producte AfegirProducteS(LlistaProductes l1)
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
        String codi = GenCodiProducte(l1);
        return new Servei(codi, nom1, descripcio1, DataITT, DataITT5);


    }
    public static Producte AfegirProducteB(LlistaProductes s1)
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
        String codi = GenCodiProducte(s1);
        return new Bens(codi, nom1, descripcio1, DataITT, amplada, alçada, fons, pesKG);


    }
    public static Intercanvi AfegirIntercanvi(LlistaUsuaris u1, LlistaProductes p1)
    {
        System.out.println("Qui ets?");
        String interessat = teclat.nextLine();
        System.out.println("\nA qui li vols intercanviar?");
        String contesta = teclat.nextLine();                                                       
        System.out.println("\nIndicador del producte que vols oferir:");                                     /*S'ha de crear excepció per veure si el usuar existeix, si el producte existeix i l'usuari té aquest producte */
        String oferit = teclat.nextLine(); 
        System.out.println("\nIndicador del producte que vols demanar");
        String demanat = teclat.nextLine(); 
        Usuari interessat2 = u1.TrobaUsuari(interessat);
        Usuari contesta2 = u1.TrobaUsuari(contesta);
        Producte demanat2 = p1.TrobaCodi(demanat);
        Producte oferit2 = p1.TrobaCodi(oferit);
        
        int codi= GenCodiIntercanvi();

        return new Intercanvi(codi, interessat2, contesta2, demanat2, oferit2);

    }

    public static void Contestar(LlistaUsuaris u1, LlistaIntercanvis l1)
    {
        System.out.println("\nIndicador del intercanvi que vols contestar");
        int codiI = Integer.parseInt(teclat.nextLine()); 
        System.out.println("Qui ets?");
        String contesta = teclat.nextLine();                          /*BUSCAR QUE SIGUI L'USUARI QUE HA DE CONSTESTAR */
        System.out.println("\nA qui li vols acceptar o refusar la proposta?");
        String interessat = teclat.nextLine();                                                       
        System.out.println("\nQue vols constestar?");   
                                                                         /*S'ha de crear excepció per veure si el usuar existeix, si el producte existeix i l'usuari té aquest producte */
        Boolean resposta = Boolean.parseBoolean(teclat.nextLine());
        System.out.println("\nValoració del intercanvi (contestador):");
        int ovaloracio = Integer.parseInt(teclat.nextLine()); 
        System.out.println("\nValoració del intercanvi (interessat):");
        int ivaloracio = Integer.parseInt(teclat.nextLine()); 
        Usuari interessat2 = u1.TrobaUsuari(interessat);
        Usuari contesta2 = u1.TrobaUsuari(contesta);    
        
        if(interessat2 != null && contesta2 != null) {
        
        l1.AcepRefusarIntercanvi(resposta, codiI, ivaloracio, ovaloracio);


        }


    }

    public static Usuari AfegirUsuari() throws AliesRepetit
    {
        System.out.println("Alies:");
        String Alies = teclat.nextLine();
        System.out.println("Email: ");
        String email = teclat.nextLine();
        System.out.println("cp ");
        int cp = Integer.parseInt(teclat.nextLine());

        return new Usuari(Alies, email, cp);
    }


    /*LLEGIR FITXERS */

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

    public static void readData (LlistaUsuaris list) {
                ObjectInputStream inputFile;
                try {
                inputFile = new ObjectInputStream(new FileInputStream("Usuari.ser"));
                for (int i=0; i<4000; i++) {                                                //FALTA ARREGLAR AIXÓ
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


    /*Generació aleatoria de codis */

     public static boolean GenRepetit(LlistaProductes l1, String codi)
    {
        boolean repetit=false;
        int i=0;
        while(i<l1.getnElem() && !repetit)
        {
           
            
        }
        return repetit;
    }
            
    public static String GenCodiProducte(LlistaProductes l1) {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'
        int targetStringLength = 6;
        Random random = new Random();
      
        String generatedString = random.ints(leftLimit, rightLimit + 1)
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        
        
        
        
        return generatedString;                         //FALTA MIRAR QUE NO ESTIGUI REPETIT
    }

    public static int GenCodiIntercanvi()
    {
        int min =0;
        int max =9999;
       

        return (int)(Math.random()*(max-min+1)+min);
    }

}