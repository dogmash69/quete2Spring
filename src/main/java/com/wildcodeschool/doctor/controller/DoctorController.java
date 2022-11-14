package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number, @RequestParam(defaultValue = "", required = false) String name) {

        if(number == 13) {
            String docName = name.replace("_", " ");

            return new Doctor(number, docName);
        }

        if(number >=1 && number <=12) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        }

        if(number > 12) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer le Doctor n° " + number);
        }

        return new Doctor();
    }
}
