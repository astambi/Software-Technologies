package blog.controllers;

import blog.forms.*;
import blog.models.*;
import blog.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PostsController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/posts/view/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);

        if (post == null) {
            notificationService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }

        model.addAttribute("post", post);
        return "posts/view";
    }

////    TODO
//    @RequestMapping("/posts/edit/{id}")
//    public String editPost(@PathVariable("id") Long id,
//                           PostForm postForm, Model model) {
//        Post post = postService.findById(id);
//
//        if (post == null) {
//            notificationService.addErrorMessage("Cannot find post #" + id);
//            return "redirect:/";
//        }
////        TODO
////        postForm -> post
//
//        model.addAttribute("post", post);
////        TODO
//        return "posts/edit";
//    }
//
////    TODO
//    @RequestMapping(value = "/posts/edit/{id}", method = RequestMethod.POST)
//    public String editPost(@Valid PostForm postForm,
//                           BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            notificationService.addErrorMessage("ERROR");
//        }
//        if (postService.edit(post))
//
//        notificationService.addInfoMessage("Post edited successfully");
//        return "redirect:/";
//    }
}
