package sg.nus.iss.mockassessment.deckapp.controller;

import sg.nus.iss.mockassessment.deckapp.service.DeckService;
import sg.nus.iss.mockassessment.deckapp.model.Deck;

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


    @PostMapping(path="/deck")
    public String showDeck(Model model){
        Deck newDeck = service.createDeck();
        model.addAttribute("deck", newDeck);
        return "deck";
    }

    @PostMapping(path="/deck/{deckId}")
    public String showDeck(@PathVariable @RequestParam String deckId, @RequestParam int count, Model model){
        Deck remainingDeck = service.drawCards(deckId, count);
        model.addAttribute("deck", remainingDeck);
        return "drawCard";
    }

    
}
