package com.joe.facebookClone.controllers;

import com.joe.facebookClone.dto.LoginDTO;
import com.joe.facebookClone.models.AppUsers;
import com.joe.facebookClone.services.AppUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller("/appUser")
public class AppUserController {
    @Autowired
    AppUserService appUserService;
    @GetMapping("/appUser/login")
    public ModelAndView login(){
        return new ModelAndView("login").addObject("loginDto",new LoginDTO());

    }
    @GetMapping("/appUser/signup")
    public ModelAndView signup(){
        return new ModelAndView("signup").addObject("appUser",new AppUsers());
    }
    @PostMapping("/appUser/save_user")
    public String saveUser(AppUsers appUsers, HttpSession session){
        System.out.println(appUsers);
        appUserService.save(appUsers,session);

        return "redirect:/appUser/login";
    }
    @PostMapping("/appUser/login")
    public String auth(LoginDTO loginDTO, HttpSession session) {
        if(appUserService.auth(loginDTO, session)){
            session.setAttribute("login_status","Successfull");
            return "redirect:/post/home";
        }
        session.setAttribute("login_status","Invalid login credentials");
        return "redirect:/appUser/login";
    }
}
