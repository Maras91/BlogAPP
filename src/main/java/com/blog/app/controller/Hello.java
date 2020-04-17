package com.blog.app.controller;


import com.blog.app.model.Account;
import com.blog.app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String hello() {
        return "loginView";
    }
    @PostMapping("/data")
    public @ResponseBody
    String introduce(String name, String password) {
      Account account = accountRepository.findByLogin(name);
        if (account == null) {
            return "Login is incorrect";
        }
        if (!account.getPassword().equals(password)) {
            return "incorrect password";
        }
        return "Hi, " + account.getName();
    }
}
