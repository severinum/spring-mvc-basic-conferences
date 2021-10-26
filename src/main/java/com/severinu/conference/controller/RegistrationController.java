package com.severinu.conference.controller;

import com.severinu.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@ControllerAdvice // used for @ModelAttribute method annotation, so default data is available within all controllers
public class RegistrationController {

    @GetMapping("registration")
    public String getRegistration (@ModelAttribute ("registration") Registration registration,
                                   ModelMap model) {

        model.put("message", "This is message from the controller model");
        registration.setName("Baltazar - set in controller method");
        registration.setAge(35);

        return "registration";
    }

    @PostMapping("registration")
    public String addRegistration (@Valid  @ModelAttribute ("registration") Registration registration,
                                    BindingResult bindingResult ) {
       if(bindingResult.hasErrors()) {
           return "error";
       }
        System.out.println("Registration: " + registration.getName()
                + ", age: " + registration.getAge());

        return "registration";
    }

    @ModelAttribute
    public void addModelAttribute (Model model) {
        model.addAttribute("method_message", "This is message from the method in Registration Controller");
    }

}
