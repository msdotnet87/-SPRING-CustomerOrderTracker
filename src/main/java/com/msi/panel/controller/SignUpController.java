package com.msi.panel.controller;


import com.msi.panel.entity.User;
import com.msi.panel.service.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

private SignUpServiceImpl signUpService;

@Autowired
public SignUpController(SignUpServiceImpl signUpService){
    this.signUpService = signUpService;
}

@GetMapping("/sign_up")
public ModelAndView signup (ModelAndView modelAndView){
    modelAndView.setViewName("sign_up");
    return modelAndView;
}

    @PostMapping("/sign_up")
    public ModelAndView signup_post (ModelAndView modelAndView, @RequestParam("username") String username,
                                     @RequestParam("password") String password){
        modelAndView.setViewName("redirect:/login");
        signUpService.signUpuser(new User(username, password));
        return modelAndView;
    }


}
