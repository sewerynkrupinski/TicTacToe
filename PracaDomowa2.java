
import java.util.ArrayList;
import java.util.Scanner;


public class PracaDomowa2 {
    
    public static void main(String[] args) {
        
       String[][] tab = new String[3][3]; //deklaracja pola gry
       Scanner odczyt = new Scanner(System.in);
       ArrayList<String> listaWykluczonych = new ArrayList<>();  //deklaracja wykluczonych ruchów, np. jest już zajęte
       
       
        System.out.println("Witaj w grze 'kółko i krzyżyk' ");
        System.out.println("------------------------------");
        System.out.println("Podaj najpierw współrzędną y (0-2), potem x (0-2) w formacie np. 00 ");
        
        //Blok rysujący pustą planszę z __ na polach
        for (int i=0; i<tab.length; i++)
        {   
            for (int j=0; j<tab.length; j++){
                tab[i][j] = "_";
            }
            
        }
       
        //Blok rysujący współrzędne pola gry (może być źle wyśtwietlany na innym komputerze, wtedy należy go usunąć)
        System.out.println("  0 1 2");
        for (int i=0; i<tab.length; i++)
            {System.out.print(i+" ");
            for (int j=0; j<tab.length; j++)
            {
                System.out.print(tab[i][j]+ " ");
            }
            System.out.println("");
            }
        
        // Pętla "gry"
        while(true)
        {
            
            
            System.out.println("Gracz 1: podaj gdzie chcesz postawić 0");
            String kolko = odczyt.nextLine();  //odczytuje współrzędne dla kółka
            System.out.println("");
            
            if (listaWykluczonych.contains(kolko)) //jeżeli podana współrzędna jest niedostępna to opuszcza iterację
            {
                System.out.println("Nie możesz tam wstawić, podaj inną współrzędną");
                continue;
            }
            
            else                    //jeżeli podana współrzędna jest wolna to dodaje ją do listy wykluczonych w następnym ruchu
            listaWykluczonych.add(kolko);
            
            
            if(kolko.equals("00"))          //umieszcza kółko w podanym polu
                tab[0][0] = "0";
            else if (kolko.equals("01"))
                tab[0][1] = "0";
            else if (kolko.equals("02"))
                tab[0][2] = "0";
            else if (kolko.equals("10"))
                tab[1][0] = "0";
            else if (kolko.equals("11"))
                tab[1][1] = "0";
            else if (kolko.equals("12"))
                tab[1][2] = "0";
            else if (kolko.equals("20"))
                tab[2][0] = "0";
            else if (kolko.equals("21"))
                tab[2][1] = "0";
            else if (kolko.equals("22"))
                tab[2][2] = "0";
            
            System.out.println("  0 1 2");          //odświeża planszę z podanym w poprzezdnim kroku kółkiem
        for (int i=0; i<tab.length; i++)
            {System.out.print(i+" ");
            for (int j=0; j<tab.length; j++)
            {
                System.out.print(tab[i][j]+ " ");
            }
            System.out.println("");
            }
            // Warunki wygranej przez "kółko"
            if (tab[0][0].equals(tab[0][1]) && tab[0][0].equals(tab[0][2])&& tab[0][0].equals("0"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            
            if (tab[1][0].equals(tab[1][1]) && tab[1][0].equals(tab[1][2])&& tab[1][0].equals("0"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[2][0].equals(tab[2][1]) && tab[2][0].equals(tab[2][2])&& tab[2][0].equals("0"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][0].equals(tab[1][1]) && tab[0][0].equals(tab[2][2])&& tab[0][0].equals("0"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][2].equals(tab[1][1]) && tab[0][2].equals(tab[2][0])&& tab[0][2].equals("0"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][0].equals(tab[1][0]) && tab[0][0].equals(tab[2][0])&& tab[0][0].equals("0"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][1].equals(tab[1][1]) && tab[0][1].equals(tab[2][1])&& tab[0][1].equals("0"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][2].equals(tab[1][2]) && tab[0][2].equals(tab[2][2])&& tab[0][2].equals("0"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            // Warunek "remisu" czyli wszystkie pola zajęte, ale nie spełniają żdnego z warunków wygranej
            if (!tab[0][0].equals("_") && !tab[0][1].equals("_") && !tab[0][2].equals("_") && !tab[1][0].equals("_") && !tab[1][1].equals("_") & !tab[1][2].equals("_") && !tab[2][0].equals("_") && !tab[2][1].equals("_") && !tab[2][2].equals("_")){
                
                System.out.println("Remis!");
                break;
            }
            
            
            
            
            System.out.println("Gracz 2: podaj gdzie cgcesz postawić X");
            String krzyzyk = odczyt.nextLine();  //odczytuje współrzędne dla krzyżyka
            System.out.println("");
            
            
            if (listaWykluczonych.contains(krzyzyk))  // sprawdza czy wskazana współrzędna nie jest już zajęta...
            {
                while(listaWykluczonych.contains(krzyzyk)){ //...jeśli jest zajęta to każe podać inną
                System.out.println("Nie możesz tam wstawić, podaj inną współrzędną");
                krzyzyk = odczyt.nextLine();
               
                  
                
                }
            }
            
            else
            listaWykluczonych.add(krzyzyk);     //jeżeli współrzędna była dobrze podana to dodają ją do listy wykluczonych w następnej rundzie
            
            if(krzyzyk.equals("00"))  //umieszcza krzyżyk w zależności od podanej współrzędnej
                tab[0][0] = "X";
            else if (krzyzyk.equals("01"))
                tab[0][1] = "X";
            else if (krzyzyk.equals("02"))
                tab[0][2] = "X";
            else if (krzyzyk.equals("10"))
                tab[1][0] = "X";
            else if (krzyzyk.equals("11"))
                tab[1][1] = "X";
            else if (krzyzyk.equals("12"))
                tab[1][2] = "X";
            else if (krzyzyk.equals("20"))
                tab[2][0] = "X";
            else if (krzyzyk.equals("21"))
                tab[2][1] = "X";
            else if (krzyzyk.equals("22"))
                tab[2][2] = "X";
            
            
            System.out.println("  0 1 2");      //odświeża planszę z podanym w poprzednim kroku krzyżykiem
        for (int i=0; i<tab.length; i++)
            {System.out.print(i+" ");
            for (int j=0; j<tab.length; j++)
            {
                System.out.print(tab[i][j]+ " ");
            }
            System.out.println("");
            }
        
            //Warunki wygranej przez "krzyżyk"
            if (tab[0][0].equals(tab[0][1]) && tab[0][0].equals(tab[0][2])&& tab[0][0].equals("X"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            
            if (tab[1][0].equals(tab[1][1]) && tab[1][0].equals(tab[1][2])&& tab[1][0].equals("X"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[2][0].equals(tab[2][1]) && tab[2][0].equals(tab[2][2])&& tab[2][0].equals("X"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][0].equals(tab[1][1]) && tab[0][0].equals(tab[2][2])&& tab[0][0].equals("X"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][2].equals(tab[1][1]) && tab[0][2].equals(tab[2][0])&& tab[0][2].equals("X"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][0].equals(tab[1][0]) && tab[0][0].equals(tab[2][0])&& tab[0][0].equals("X"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][1].equals(tab[1][1]) && tab[0][1].equals(tab[2][1])&& tab[0][1].equals("X"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            if (tab[0][2].equals(tab[1][2]) && tab[0][2].equals(tab[2][2])&& tab[0][2].equals("X"))
                    {
                        System.out.println("Wygrałeś");
                        break;
                    }
            // Warunek remisu
            if (!tab[0][0].equals("_") && !tab[0][1].equals("_") && !tab[0][2].equals("_") && !tab[1][0].equals("_") && !tab[1][1].equals("_") & !tab[1][2].equals("_") && !tab[2][0].equals("_") && !tab[2][1].equals("_") && !tab[2][2].equals("_")){
                
                System.out.println("Remis!");
                break;
            }
            
        }  
            
        
        
        
    }
    
}
