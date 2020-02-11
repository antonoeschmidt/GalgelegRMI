package galgeleg;



import brugerautorisation.data.Bruger;
import brugerautorisation.data.Diverse;
import brugerautorisation.transport.rmi.Brugeradmin;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class TestBrugerLogin {
    public static void main(String[] args) throws Exception {
        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

        Bruger off = ba.hentBrugerOffentligt("s163053");
        System.out.println("Fik offentlige data " + Diverse.toString(off));

        //ba.sendGlemtAdgangskodeEmail("s163053", "Dette er en test, husk at skifte kode");
        //ba.ændrAdgangskode("s163053", "koden123", "koden123");
        Bruger b = ba.hentBruger("s163053", "koden123");
        System.out.println("Fik bruger " + b);
        System.out.println("med data " + Diverse.toString(b));
        // ba.sendEmail("jacno", "xxx", "Hurra det virker!", "Jeg er så glad");

        Object ekstraFelt = ba.getEkstraFelt("s163053", "koden123", "hobby");
        System.out.println("Brugerens hobby er: " + ekstraFelt);

        ba.setEkstraFelt("s163053", "koden123", "hobby", "Tennis og programmering"); // Skriv noget andet her

        String webside = (String) ba.getEkstraFelt("s163053", "koden123", "webside");
        System.out.println("Brugerens webside er: " + webside);
    }

}
