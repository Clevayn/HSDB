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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Database {

    protected List<Card> wildDB = new LinkedList<>();
    protected List<Card> standardDB = new LinkedList<>();
    protected File WildCardList = new File("C:\\HSDeckBuilder\\src\\main\\resources\\WildCardList.json");
    protected File StandardCardList = new File("C:\\HSDeckBuilder\\src\\main\\resources\\StandardCardList.json");
    protected File metaData =  new File("C:\\HSDeckBuilder\\src\\main\\resources\\metadata.json");
    private final OkHttpClient client = new OkHttpClient();
    private final JsonFactory factory = new JsonFactory();
    protected JsonNode jsonNode;
    private String accessToken;
    private final ObjectMapper mapper = new ObjectMapper();

    Database() throws IOException, URISyntaxException {
        accessToken = accessToken();
        metadata();
        System.out.println("Retreived MetaData");
        setIds();
            int page = 1;
            int cardCount = -1;
            while (wildDB.size() != cardCount) {
            URI cardsUri = new URIBuilder()
                    .setScheme("https")
                    .setHost("us.api.blizzard.com")
                    .setPath("/hearthstone/cards")
                    .setParameter("locale", "en_US")
                    .setParameter("collectible", "0,1")
                    .setParameter("pageSize", "500")
                    .setParameter("page", String.valueOf(page))
                    .setParameter("access_token", accessToken)
                    .build();

            jsonNode = mapper.readTree(cardsUri.toURL());
            cardCount = jsonNode.at("/cardCount").asInt();

            for (JsonNode subNode : jsonNode.at("/cards")) {
                    Card card = new Card(subNode);
                    setStandard(card);
                    card.setControl();
                    card.setBonus();
                    card.setSpellTrigger();
                    card.setDraw();
                    card.setEnhanced();
                    card.setRepeat();
                wildDB.add(card);
                if (card.isStandard()) standardDB.add(card);
            }

            System.out.println(wildDB.size() + " Page: " + page);
            page++;
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(WildCardList, wildDB);
            mapper.writerWithDefaultPrettyPrinter().writeValue(StandardCardList ,standardDB);
            new Averages();
            new WildRatios();
            new StandardRatios();
            new KeywordValueModifier();
            minionKeywordModStandard();
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
                .setParameter("access_token", accessToken)
                .build();

        jsonNode = mapper.readTree(metadataUri.toURL());

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\HSDeckBuilder\\src\\main\\resources\\MetaData.json"), jsonNode);

        /*System.out.println(jsonNode.get("sets"));
        System.out.println(jsonNode.get("types"));
        System.out.println(jsonNode.get("rarities"));
        System.out.println(jsonNode.get("classes"));
        System.out.println(jsonNode.get("minionTypes"));
        System.out.println(jsonNode.get("gameModes"));
        System.out.println(jsonNode.get("keywords"));*/



    }

    void minionKeywordModStandard() throws IOException {
        File kwModValue = new File("C:\\HSDeckBuilder\\src\\main\\resources\\KeywordModifier.json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(kwModValue);
        List<Card> tempList = new LinkedList<>();

        for (Card card: new Filter("standard").minions().collectible().getCardList()
        ) {
            double temp = card.getPowerScoreStandard();
            for (int x: card.getKeywordIds()
            ) {
                temp += jsonNode.get(ValueTranslator.keywordName(x)).asDouble();
            }
            card.setPowerScoreStandard(temp);
            tempList.add(card);
        }
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\HSDeckBuilder\\src\\main\\resources\\StandardCardList.json"), tempList);
    }

    void setStandard(Card card) throws IOException {
        File standardIds = new File("C:\\HSDeckBuilder\\src\\main\\resources\\standardIds.json");
        List<Integer> standard = new LinkedList<>();

        for (JsonNode node: mapper.readTree(standardIds)) standard.add(node.asInt());

        if (standard.contains(card.getCardSetId())) card.setStandard(true);
        else card.setStandard(false);
    }

    void setIds() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File meta = new File("C:\\HSDeckBuilder\\src\\main\\resources\\MetaData.json");
        File cardSetIdBySlug = new File("C:\\HSDeckBuilder\\src\\main\\resources\\cardSetIdBySlug.json");
        File cardSetSlugById = new File("C:\\HSDeckBuilder\\src\\main\\resources\\cardSetSlugById.json");
        File standardIds = new File("C:\\HSDeckBuilder\\src\\main\\resources\\standardIds.json");

        JsonNode metaData = mapper.readTree(meta);;

        LinkedHashMap<String, Integer> wildBySlug = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> wildById = new LinkedHashMap<>();
        List<Integer> standard = new LinkedList<>();


        for (JsonNode set: metaData.get("sets")
        ) {
            wildBySlug.put(set.get("slug").asText(), set.get("id").asInt());
            wildById.put(set.get("id").asInt(), set.get("slug").asText());

        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(cardSetIdBySlug, wildBySlug);
        mapper.writerWithDefaultPrettyPrinter().writeValue(cardSetSlugById, wildById);

        for (JsonNode node: metaData.get("setGroups")
        ) {

            if (node.get("slug").asText().equals("standard")){
                for (JsonNode node1: node.get("cardSets")
                ) {
                    standard.add(wildBySlug.get(node1.textValue()));
                }
            }
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(standardIds, standard);
    }


/*    public List<ScoredCard> getDBScored() {
        return DBScored;
    }*/

    public List<Card> getWildDB() {
        return wildDB;
    }






}

