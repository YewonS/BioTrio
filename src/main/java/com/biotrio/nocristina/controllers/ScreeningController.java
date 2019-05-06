package com.biotrio.nocristina.controllers;
import com.biotrio.nocristina.models.Screening;
import com.biotrio.nocristina.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ScreeningController {

    @Autowired
    ScreeningRepository screeningRepo;

    @GetMapping("/api/screenings")
    @ResponseBody
    public List<Screening> showScreenings() {
        return screeningRepo.findAll();
    }

    @GetMapping("/screening/add")
    public String addScreening(Model model) {
        Screening newScreening = new Screening();
        model.addAttribute("newScreening", newScreening);
        return "add-screening";
    }

    @PostMapping("/screening/add")
    public String saveScreening(@ModelAttribute Screening newScreening){
        screeningRepo.findAll().add(newScreening);
        return "redirect:/screening";
    }

}