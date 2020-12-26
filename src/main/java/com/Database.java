package com;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import okhttp3.*;
import org.apache.http.client.utils.URIBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Database {

    protected List<Card> cardDB = new LinkedList<>();
    protected List<ScoredCard> DBScored = new LinkedList<>();
    protected File jdb = new File("C:\\HSDeckBuilder\\src\\main\\resources\\HSDB.json");
    protected File basicDB = new File("C:\\HSDeckBuilder\\src\\main\\resources\\BasicDB.json");
    protected File metaData =  new File("C:\\HSDeckBuilder\\src\\main\\resources\\metadata.json");
    private final OkHttpClient client = new OkHttpClient();
    private final JsonFactory factory = new JsonFactory();
    protected JsonNode jsonNode;
    private String accessToken;
    private final ObjectMapper mapper = new ObjectMapper();

    Database() throws IOException, URISyntaxException {
        metadata();
        if (!jdb.exists()){
            int page = 1;
            int cardCount = 1000000;
            while (cardDB.size() != cardCount) {
            URI cardsUri = new URIBuilder()
                    .setScheme("https")
                    .setHost("us.api.blizzard.com")
                    .setPath("/hearthstone/cards")
                    .setParameter("locale", "en_US")
                    .setParameter("collectible", "0,1")
                    .setParameter("pageSize", "500")
                    .setParameter("page", String.valueOf(page))
                    .setParameter("access_token", accessToken())
                    .build();


            jsonNode = mapper.readTree(cardsUri.toURL());
            cardCount = jsonNode.at("/cardCount").asInt();

            for (JsonNode subNode : jsonNode.at("/cards")) cardDB.add(new Card(subNode));

            System.out.println(cardDB.size() + " Page: " + page);
            page++;
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(basicDB, cardDB);

            for (Card card: cardDB) DBScored.add(new ScoredCard(card, new Ratios(card)));
            mapper.writerWithDefaultPrettyPrinter().writeValue(jdb, DBScored);


        }

        else {
            ObjectMapper mapper = new ObjectMapper();
            jsonNode = mapper.readTree(jdb);
            for (JsonNode node: jsonNode) this.DBScored.add(new ScoredCard(node));
        }





    }

    private String accessToken() throws IOException {
        FormBody formBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .build();

        Request request = new Request.Builder()
                .url("https://us.battle.net/oauth/token")
                .addHeader("Authorization", Credentials.basic("6b86930010924da8b8aa7364472d40bb", "2FOiemAvoP4l5atqmtDEO9kicQx0KEwi"))
                .post(formBody)
                .build();

        Call call = this.client.newCall(request);
        Response response = call.execute();
        ResponseBody responseBody = response.body();
        assert responseBody != null;

        JsonParser parser = factory.createParser(responseBody.bytes());
        this.jsonNode = this.mapper.readTree(parser);
        System.out.println("Access Token: " + jsonNode.at("/access_token").asText());
        return jsonNode.at("/access_token").asText();
    }


    private void metadata() throws IOException, URISyntaxException {
        URI metadataUri = new URIBuilder()
                .setScheme("https")
                .setHost("us.api.blizzard.com")
                .setPath("/hearthstone/metadata")
                .setParameter("locale", "en_US")
                .setParameter("access_token", accessToken())
                .build();

        jsonNode = mapper.readTree(metadataUri.toURL());

        System.out.println(jsonNode.get("sets"));
        System.out.println(jsonNode.get("types"));
        System.out.println(jsonNode.get("rarities"));
        System.out.println(jsonNode.get("classes"));
        System.out.println(jsonNode.get("minionTypes"));
        System.out.println(jsonNode.get("gameModes"));
        System.out.println(jsonNode.get("keywords"));



    }


    public List<ScoredCard> getDBScored() {
        return DBScored;
    }

    public List<Card> getCardDB() {
        return cardDB;
    }






}

