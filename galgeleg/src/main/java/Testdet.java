import kong.unirest.Unirest;

public class Testdet {

    public static void main(String[] args) {
        searchCompany("egn");

    }

    public static void searchCompany(String firma) {
        System.out.println(Unirest.get("https://cvrapi.dk/api?search=" + firma + "&country=dk&format=xml")
                .queryString("", "name")
                .asString().getBody());
    }
}
