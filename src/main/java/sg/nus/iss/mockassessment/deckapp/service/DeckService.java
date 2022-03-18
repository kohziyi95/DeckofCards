package sg.nus.iss.mockassessment.deckapp.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.nus.iss.mockassessment.deckapp.model.Card;
import sg.nus.iss.mockassessment.deckapp.model.Deck;

@Service
public class DeckService {
    
    public Deck createDeck(){
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.getForEntity("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", String.class);

        InputStream is = new ByteArrayInputStream(resp.getBody().getBytes());
        JsonReader reader = Json.createReader(is);
        JsonObject data = reader.readObject();

        Deck newDeck = new Deck();
        List<Card> newList = new ArrayList<>();
        newDeck.setDeckId(data.getString("deck_id"));
        newDeck.setCardsRemaining(data.getInt("remaining"));
        newDeck.setIsShuffled(data.getBoolean("shuffled"));
        newDeck.setIsSuccessful(data.getBoolean("success"));
        newDeck.setCards(newList);
        return newDeck;
    }

    public Deck drawCards (String deckId, Integer count) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.getForEntity("https://deckofcardsapi.com/api/deck/"+ deckId +"/draw/?count="+count, String.class);

        InputStream is = new ByteArrayInputStream(resp.getBody().getBytes());
        JsonReader reader = Json.createReader(is);
        JsonObject data = reader.readObject();

        Deck deck = new Deck();

        deck.setDeckId(data.getString("deck_id"));
        deck.setCardsRemaining(data.getInt("remaining"));
        deck.setIsSuccessful(data.getBoolean("success"));
        JsonArray cardArray = data.getJsonArray("cards");
        ArrayList<Card> cardList = new ArrayList<>();
        for (int i = 0; i < count; i++){
            Card newCard = Card.createCard(cardArray.getJsonObject(i));
            cardList.add(newCard);
        }
        deck.setCards(cardList);

        return deck;
    }
}
