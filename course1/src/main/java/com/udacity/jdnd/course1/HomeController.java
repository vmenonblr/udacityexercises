package com.udacity.jdnd.course1;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private MessageListService messageListService;

    HomeController(MessageListService messageListService){
        this.messageListService = messageListService;
    }


    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String postHome(@ModelAttribute("animalObj") AnimalForm animalObj, Model model){
        System.out.println("Animal Name is" + animalObj.getAnimalName());
        System.out.println(("Adjective is " + animalObj.getAdjective()));
        return "home";
    }


    @PostMapping("/animal")
    public String postAnimal(@ModelAttribute("newMessage") MessageForm newMessage, Model model ){
        messageListService.addMessage(newMessage.getText());
        return "animal";
    }
}