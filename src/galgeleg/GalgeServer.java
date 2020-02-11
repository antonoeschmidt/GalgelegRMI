package galgeleg;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class GalgeServer {

    public static void main(String[] args) throws Exception {
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        GalgelegInterface glI = new Galgelogik();
        Naming.rebind("rmi://localhost:1099/galgeservice",glI);
        System.out.println("Galgeservice registreret.");
    }
}
