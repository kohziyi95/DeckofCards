package sg.nus.iss.mockassessment.deckapp.controller;

import sg.nus.iss.mockassessment.deckapp.service.DeckService;
import sg.nus.iss.mockassessment.deckapp.model.Card;
import sg.nus.iss.mockassessment.deckapp.model.Deck;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class DeckController {
    
    @Autowired
    DeckService service;

    // ========== For Task 2 ==============
    // @PostMapping(path="/deck")
    // public String showDeck(Model model){

    //     Deck newDeck = service.createDeck();
        
    //     model.addAttribute("deck", newDeck);
    //     return "deck";
    // }

    // @PostMapping(path="/deck/{deckId}")
    // public String showDeck(@PathVariable @RequestParam String deckId, @RequestParam int count, Model model){
    //     Deck remainingDeck = service.drawCards(deckId, count);
    //     model.addAttribute("deck", remainingDeck);
    //     return "drawCard";
    // }

    
    // ========== For Task 3 ==============
    @PostMapping(path="/deck")
    public String showDeck(Model model, HttpSession sess){
        
        List<Card> cardList = (List<Card>) sess.getAttribute("cardList");

        cardList = new ArrayList<Card>();
        sess.setAttribute("cardList", cardList);
         

        Deck newDeck = service.createDeck();
        
        model.addAttribute("deck", newDeck);
        return "deck";
    }

    @PostMapping(path="/deck/{deckId}")
    public String showDeck(@PathVariable @RequestParam String deckId, @RequestParam int count, Model model, HttpSession sess){
        
        Deck remainingDeck = service.drawCards(deckId, count);

        List<Card> cardList = (List<Card>) sess.getAttribute("cardList");

        for (Card cards : remainingDeck.getCards()){
            cardList.add(cards);
            sess.setAttribute("cardList", cardList);
        }
        
        model.addAttribute("deck", remainingDeck);
        model.addAttribute("cardList", cardList);
        
        return "drawCard";
    }
    
}
