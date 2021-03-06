package be.thomamore.party.controllers;

import be.thomamore.party.model.Venue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Controller
public class HomeController {

    private final String[] venueNames = {"De Loods", "De Club", "De Hangar", "Zapoi", "Kuub", "Cuba Libre"};
    private final Venue v1 = new Venue("v1", "link1", 6, true, false, true, false, "brussel", 40);
    private final Venue v2 = new Venue("v2", "link2", 6, true, false, true, false, "brussel", 40);
    private final Venue v3 = new Venue("v3", "link3", 6, true, false, true, false, "brussel", 40);
    private final Venue v4 = new Venue("v4", "link4", 6, true, false, true, false, "brussel", 40);

    private final Venue[] venues ={v1,v2,v3,v4};
    private final LocalDate datum = LocalDate.now(); // controller moet eig stateless zijn dusmoet ditniet final zijn ?
    private final Calendar c1 = Calendar.getInstance();


    @GetMapping({"/", "/home"})
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {

        return "about";
    }

    @GetMapping("/pay")

    public String pay(Model model,
                      @PathVariable(required = false) boolean weekend) {

        model.addAttribute("LocalDate", datum);


        return "pay";
    }

    @GetMapping({"/venuedetails", "/venuedetails/{index}"})
    public String venueDetails(Model model,
                               @PathVariable(required = false)  Integer index) {
        if (index!=null && index>=0 && index<venueNames.length ) {
            model.addAttribute("venueName", venueNames[index]);
            model.addAttribute("prevIndex", index>0 ? index-1 : venueNames.length-1);
            model.addAttribute("nextIndex", index<venueNames.length-1 ? index+1 : 0);
            model.addAttribute("venueName", (venueNames!=null) ? venueNames : "--no venue chosen--");
        }
        return "venuedetails";
        //NOG EXCEPTION TOEVOEGEN ZIE BUNDEL P27
        // ZIE BUNDEL 2 PG 4 NOG DOEN
    }





    @GetMapping("/venuelist")
    public String venueList(Model model) {
        model.addAttribute("venues", venues);
       return "venuelist";
    }
//    @GetMapping("/venuelist")
//    public String venueList(Model model) {
//        model.addAttribute("venueNames", venueNames);
//        return "venuelist";
//    }



}
