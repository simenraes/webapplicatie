package be.thomamore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Controller
public class HomeController {
    private final int mySpecialNumber = 729;
    private final String[] venueNames = {"De Loods", "De Club", "De Hangar", "Zapoi", "Kuub", "Cuba Libre"};
    private final LocalDate datum = LocalDate.now(); // controller moet eig stateless zijn dusmoet ditniet final zijn ?
    private final Calendar c1 = Calendar.getInstance();


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

    public String pay(Model model,
                      @PathVariable(required = false) boolean weekend) {

        model.addAttribute("LocalDate", datum);


        return "pay";
    }

    @GetMapping({"/venuedetails", "/venuedetailsbyindex/{index}"})
    public String venueDetails(Model model,
                               @PathVariable(required = false)  Integer index) {
        if (index!=null && index>=0 && index<venueNames.length ) {
            model.addAttribute("venueName", venueNames[index]);
            model.addAttribute("prevIndex", index>0 ? index-1 : venueNames.length-1);
            model.addAttribute("nextIndex", index<venueNames.length-1 ? index+1 : 0);
        }
        return "venuedetails";
        //NOG EXCEPTION TOEVOEGEN ZIE BUNDEL P27
    }
//model.addAttribute("venueName", (venueName!=null) ? venueName : "--no venue chosen--");




    @GetMapping("/venuelist")
    public String venueList(Model model) {
        model.addAttribute("venueNames", venueNames);
        return "venuelist";
    }

}
