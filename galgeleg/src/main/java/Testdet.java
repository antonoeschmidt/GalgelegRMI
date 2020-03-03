import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class Testdet {

    public static void main(String[] args) throws Exception {
//        UseEconomic();
//        UseEconomic2();
        //CvrToName("nordfalken");

        UseDr();

    }

    private static void CvrToName(String name) {
        String url = "https://cvrapi.dk/api?search=" + name + "&country=dk";
        HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();
        System.out.println("json = " + json);

        System.out.println("Adressen er: " + json.getString("address"));
//        System.out.println("Og: "+json.getString("productionunits"));
//        System.out.println("Og: "+json.getJSONArray("productionunits"));
//        System.out.println("Og: "+json.getJSONArray("productionunits").optJSONObject(0).get("name"));
    }

    private static void UseEconomic() {
        String url = "https://restapi.e-conomic.com/?demo=true";
        HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();
        System.out.println("json = " + json);
        System.out.println("Adressen er: " + json.optJSONObject("company").getString("address"));
    }

    private static void UseEconomic2() {
        String url = "https://restapi.e-conomic.com/invoices/drafts?demo=true";
        HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();
//        System.out.println("json = " + json);
        System.out.println("Collection array: " + json.getJSONArray("collection"));
        System.out.println("Draft Invoice Number: " + json.getJSONArray("collection")
                .optJSONObject(0).get("draftInvoiceNumber"));
    }

    private static void UseDr() {
        String url = "https://www.dr.dk/mu-online/api/1.3/list/view/mostviewed?channel=" +
                "dr1&channeltype=TV&limit=5&offset=4";
        HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        JSONObject json = response.getBody().getObject();

        JSONObject json1 = (JSONObject) json.getJSONArray("Items").get(0);
        System.out.println(json1.getString("SeriesTitle"));
        JSONObject json2 = (JSONObject) json.getJSONArray("Items").get(1);
        System.out.println(json2.getString("SeriesTitle"));
        JSONObject json3 = (JSONObject) json.getJSONArray("Items").get(2);
        System.out.println(json3.getString("SeriesTitle"));
        JSONObject json4 = (JSONObject) json.getJSONArray("Items").get(3);
        System.out.println(json4.getString("SeriesTitle"));
        JSONObject json5 = (JSONObject) json.getJSONArray("Items").get(4);
        System.out.println(json5.getString("SeriesTitle"));
    }
}
