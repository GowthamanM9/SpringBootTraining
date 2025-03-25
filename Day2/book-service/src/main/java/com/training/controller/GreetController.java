package com.training.controller;

import com.training.util.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {

    @GetMapping(path = "/greet/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
// Old way syntax
//    @RequestMapping(path="/greet", method = RequestMethod.GET)
    public ResponseMessage Greet(@PathVariable String name) {
        return new ResponseMessage("Welcome to spring REST " + name);
    }
}
