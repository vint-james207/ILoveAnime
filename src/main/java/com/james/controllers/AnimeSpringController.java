package com.james.controllers;

import com.james.services.AnimeRepository;
import com.james.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by jamesyburr on 6/24/16.
 */
@Controller
public class AnimeSpringController {
    @Autowired
    UserRepository users;

    @Autowired
    AnimeRepository animes;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String home(HttpSession session) {
        return "home";
    }
}
