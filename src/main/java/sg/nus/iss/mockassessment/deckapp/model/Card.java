package sg.nus.iss.mockassessment.deckapp.model;

import jakarta.json.JsonObject;


public class Card {
    private Boolean isSuccessful;
    private String imgUrl;
    private String value;
    private String suit;
    private String code;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public static Card createCard(JsonObject cardValues){

        Card newCard = new Card();
        newCard.setImgUrl(cardValues.getString("image"));
        newCard.setValue(cardValues.getString("value"));
        newCard.setSuit(cardValues.getString("suit"));
        newCard.setCode(cardValues.getString("code"));
        
        return newCard;
    }

    


}
