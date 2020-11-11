package com.nackademin;

import java.io.*;
import java.util.Scanner;

public class VinstLott {

    // vi vill inte visa dessa variabler använd get,set
    private long nr;
    private String vinst;

    private static String vinsterFil= "vinster.txt";

    public long getNr() {
        return nr;
    }

    public void setNr(long nr) {
        this.nr = nr;
    }

    public String getVinst() {
        return vinst;
    }

    public void setVinst(String vinst) {
        this.vinst = vinst;
    }

     /**
     * Hitta vinnande lott på gissade Lottonummer
     * @param vinstLotter
     * @param lott
     * @return
     */
    public static VinstLott finnsVinst(VinstLott[] vinstLotter,int lott){
        for(int i=0; i < vinstLotter.length; i++){
            if(vinstLotter[i].nr == lott){
                return vinstLotter[i];
            }
        }
        return null;
    }


    /**
     * Skapar en vinstlott från fil genom att ta emot antal lotter du kommer läsa in från din fil
     * och sedan returnerar en vinstlott array
     * @param antalLotter
     * @return
     * @throws FileNotFoundException
     */
    public static VinstLott[] skapaVinstLottFranFil(int antalLotter) throws FileNotFoundException {
        // antal vinstlotter
        VinstLott[] vinstLotter = new VinstLott[antalLotter];


        Scanner fil = new Scanner(new File(vinsterFil));
        //nollställ räknare som hämtar de olika raderna
        int n = 0;

        //ett varv per rad i filen
        while (fil.hasNext()) {
            vinstLotter[n] = new VinstLott();
            String nextNumber = fil.nextLine();
            // lotto numret
            vinstLotter[n].setNr(Integer.parseInt(nextNumber));

            String nextVinst = fil.nextLine();
            if(!nextNumber.equals("")) {
                vinstLotter[n++].setVinst(nextVinst);
            }

        }
        return vinstLotter;
    }


    /**
     * Startar lotteri som frågar användaren om deras lottonummer och sedan letar upp om lottnummret finns bland vinstnummren
     * @param vinstLotter
     */
    public static void startaLotteri(VinstLott[] vinstLotter){
        //frågar användaren vilken lottnr
        Scanner sc = new Scanner(System.in);

        while (true) {
            //String input
            System.out.println("Hej, var god och skriv in ett 9 siffrigt nummer för att delta i lottning:");
            try {
                //Läs in lottnummer
                int lottNummer = sc.nextInt();
                VinstLott vinst = VinstLott.finnsVinst(vinstLotter, lottNummer);

                //om användaren vann
                if (vinst != null) {
                    System.out.println("Grattis du vann! " + vinst.getVinst());
                    break;
                } else {
                    System.out.println("Du vann ingenting, var god och försök igen! Skriv ett icke nummer för att avbryta");
                }
            }catch(Exception e){
                break;
            }

        }
    }
}