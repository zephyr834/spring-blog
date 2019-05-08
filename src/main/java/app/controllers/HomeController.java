package app.controllers;


import app.models.Post;
import app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Post> latestFivePosts = postService.findLatestFive();
        model.addAttribute("latestFivePosts", latestFivePosts);

        List<Post> latestThreePosts = latestFivePosts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latestThreePosts", latestThreePosts);
        return "index";
    }
}
