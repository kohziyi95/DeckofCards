package sg.nus.iss.mockassessment.deckapp.model;

import java.util.List;


public class Deck {
    private Boolean isSuccessful;
    private String deckId;
    private Boolean isShuffled;
    private Integer cardsRemaining;
    private List<Card> cards;

    public String getDeckId() {
        return deckId;
    }
    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }
    public Integer getCardsRemaining() {
        return cardsRemaining;
    }
    public void setCardsRemaining(Integer cardsRemaining) {
        this.cardsRemaining = cardsRemaining;
    }

    public Boolean getIsShuffled() {
        return isShuffled;
    }
    public void setIsShuffled(Boolean isShuffled) {
        this.isShuffled = isShuffled;
    }

    public Boolean getIsSuccessful() {
        return isSuccessful;
    }
    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    
    // public Deck createDeck(){
    //     RestTemplate template = new RestTemplate();
    //     ResponseEntity<String> resp = template.getForEntity("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", String.class);

    //     InputStream is = new ByteArrayInputStream(resp.getBody().getBytes());
    //     JsonReader reader = Json.createReader(is);
    //     JsonObject data = reader.readObject();

    //     Deck newDeck = new Deck();

    //     newDeck.setDeckId(data.getString("deck_Id"));
    //     newDeck.setCardsRemaining(data.getInt("remaining"));
    //     newDeck.setIsShuffled(data.getBoolean("shuffled"));
    //     newDeck.setIsSuccessful(data.getBoolean("success"));

    //     return newDeck;
    // }
}

    

    


