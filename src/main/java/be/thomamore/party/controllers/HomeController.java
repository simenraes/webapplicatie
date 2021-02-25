package be.thomamore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    private final int mySpecialNumber = 729;
    private final String[] venueNames = {"De Loods", "De Club", "De Hangar", "Zapoi", "Kuub", "Cuba Libre"};
    private LocalDate datum = LocalDate.now();


    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("mySpecialNumber", mySpecialNumber);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("mySpecialNumber", mySpecialNumber);
        return "about";
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        model.addAttribute("LocalDate", datum);

        return "pay";
    }

    @GetMapping({"/venuedetails", "/venuedetails/{venueName}"})
    public String venuedetails(Model model,
                               @PathVariable(required = false) String venueName) {
        model.addAttribute("venueName", (venueName!=null) ? venueName : "--no venue chosen--");


        return "venuedetails";
    }

    @GetMapping("/venuelist")
    public String venueList(Model model) {
        model.addAttribute("venueNames", venueNames);
        return "venuelist";
    }
}
