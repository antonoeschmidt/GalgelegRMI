package galgeleg;

import brugerautorisation.transport.rmi.Brugeradmin;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class GalgeKlient {
    public static void main(String[] args) throws Exception{

        //GalgelegInterface glI =(GalgelegInterface) Naming.lookup("rmi://localhost:1099/galgeservice");
        GalgelegInterface glI =(GalgelegInterface) Naming.lookup("rmi://dist.saluton.dk:23609/kontotjeneste");
        glI.nulstil();
        Scanner scan = new Scanner(System.in);

        Brugeradmin brugeradmin = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        System.out.println("Indtast studienummer: ");
        String studienummer = scan.nextLine();
        System.out.println("Indtast kode: ");
        String kode = scan.nextLine();

        try {
            brugeradmin.hentBruger(studienummer,kode);
            System.out.println("Login autoriseret");
            runGalgeleg(glI, scan);
        } catch (IllegalArgumentException e) {
            System.out.println("Forkert brugernavn eller adgangskode. Spillet lukkes.");
        }



    }

    private static void runGalgeleg(GalgelegInterface glI, Scanner scan) throws RemoteException {
        System.out.println("dude");
        glI.nulstil();
        System.out.println("-- Galgeleg starter --");

        while (!glI.erSpilletSlut()) {
            System.out.println("Gæt et bogstav: ");
            glI.gætBogstav(scan.nextLine());
            System.out.println(glI.getSynligtOrd());
            System.out.println(7 - glI.getAntalForkerteBogstaver() + " liv tilbage");
        }

        System.out.println(glI.erSpilletVundet() ? "Tillykke du vandt!" : "Du tabte desværre. Ordet du prøvede at gætte var: " + glI.getOrdet());
    }


}
