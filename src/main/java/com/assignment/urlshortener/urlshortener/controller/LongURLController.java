package com.assignment.urlshortener.urlshortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LongURLController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadIndex() {

        System.out.println("In LongUrlController");
        return "index";
    }
}
