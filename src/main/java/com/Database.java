package com;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.apache.http.client.utils.URIBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class Database {

    protected List<Card> cardDB = new LinkedList<>();
    protected List<ScoredCard> DBScored = new LinkedList<>();
    protected File jdb = new File("C:\\Users\\genes\\Desktop\\HSjson files\\HSDB.json");
    protected File jdbText = new File("C:\\Users\\genes\\Desktop\\HSjson files\\HSDB.txt");
    private final OkHttpClient client = new OkHttpClient();
    private final JsonFactory factory = new JsonFactory();
    protected JsonNode jsonNode;
    private String accessToken;
    private final ObjectMapper mapper = new ObjectMapper();

    Database() throws IOException, URISyntaxException {
        if (!jdb.exists()){
            int page = 1;
            accessToken();
            while (cardDB.size() != 3707) {
            URI uri = new URIBuilder()
                    .setScheme("https")
                    .setHost("us.api.blizzard.com")
                    .setPath("/hearthstone/cards")
                    .setParameter("local", "en_US")
                    .setParameter("collectible", "0,1")
                    .setParameter("pageSize", "500")
                    .setParameter("page", String.valueOf(page))
                    .setParameter("access_token", accessToken)
                    .build();


            jsonNode = mapper.readTree(uri.toURL());

            for (JsonNode subNode : jsonNode.at("/cards")) cardDB.add(new Card(subNode, true));

            System.out.println(cardDB.size() + " Page: " + page);
            page++;
            }
            mapper.writeValue(jdb, cardDB);
            Averages averages = new Averages();
            for (Card card: cardDB) DBScored.add(new ScoredCard(card, new Ratios(card, averages)));
            mapper.writeValue(jdb, DBScored);
            mapper.writerWithDefaultPrettyPrinter().writeValue(jdbText, DBScored);

        }

        else {
            ObjectMapper mapper = new ObjectMapper();
            jsonNode = mapper.readTree(jdb);
            for (JsonNode node: jsonNode
            ) {

                this.DBScored.add(new ScoredCard(node));
            }

        }
    }






    private void accessToken() throws IOException {


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
        this.accessToken = jsonNode.at("/access_token").asText();


    }

    public List<ScoredCard> getDBScored() {
        return DBScored;
    }

    public List<Card> getCardDB() {
        return cardDB;
    }






}

