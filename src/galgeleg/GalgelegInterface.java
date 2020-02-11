package galgeleg;

public interface GalgelegInterface extends java.rmi.Remote {
    void nulstil() throws java.rmi.RemoteException;
    void gætBogstav(String bogstav) throws java.rmi.RemoteException;
    String getOrdet() throws java.rmi.RemoteException;
    String getSynligtOrd() throws java.rmi.RemoteException;
    int getAntalForkerteBogstaver() throws java.rmi.RemoteException;
    boolean erSpilletSlut()             throws java.rmi.RemoteException;
    boolean erSpilletVundet()           throws java.rmi.RemoteException;
}
