package com.james.controllers;

import com.james.entities.Anime;
import com.james.entities.User;
import com.james.services.AnimeRepository;
import com.james.services.UserRepository;
import com.james.utils.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * Created by jamesyburr on 6/24/16.
 */
@Controller
public class ILoveAnimeController {
    @Autowired
    UserRepository users;

    @Autowired
    AnimeRepository animes;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        model.addAttribute("animes", animes.findAll());
        model.addAttribute("now", LocalDateTime.now());
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) throws Exception {
        User user = users.findByName(username);
        if (user == null) {
            user = new User(username, PasswordStorage.createHash(username));
            users.save(user);
        } else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("Incorrect password!");
        }
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/add-anime", method = RequestMethod.POST)
    public String addAnime(HttpSession session, String title, String comment, String time) {
        String username = (String) session.getAttribute("username");
        User user = users.findByName(username);
        Anime anime = new Anime(title, comment, LocalDateTime.parse(time), user);
        animes.save(anime);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(Integer id) {
        animes.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/editAnime", method = RequestMethod.POST)
    public String editAnime(Integer id, String title, String comment, String time) {
        Anime anime = new Anime(id, title, comment, LocalDateTime.parse(time));
        animes.save(anime);
        return "redirect:/";
    }
}

