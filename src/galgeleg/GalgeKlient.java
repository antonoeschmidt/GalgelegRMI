package galgeleg;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class GalgeKlient {
    public static void main(String[] args) throws Exception{
        GalgelegInterface glI =(GalgelegInterface) Naming.lookup("rmi://localhost:1099/galgeservice");
        Scanner scan = new Scanner(System.in);


        runGalgeleg(glI, scan);
    }

    private static void runGalgeleg(GalgelegInterface glI, Scanner scan) throws RemoteException {
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
