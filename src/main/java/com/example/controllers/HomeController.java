package com.example.controllers;

import com.example.beans.Avenger;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CopyOnWriteArrayList;

@Controller
@Getter
@Setter
public class HomeController {

    private CopyOnWriteArrayList<Avenger> avengerList
            =new CopyOnWriteArrayList<>();

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("avengerList", avengerList);
        return "index";
    }

    @GetMapping("/addPage")
    public String goToAdd(Model model){

        model.addAttribute("avenger", new Avenger());
        return "add_avenger";
    }

    @PostMapping("/addAvenger")
    public String addAvenger(@ModelAttribute Avenger avenger){
        avengerList.add(avenger);
        return "redirect:/";
    }


}
