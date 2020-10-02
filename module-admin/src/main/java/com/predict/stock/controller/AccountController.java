package com.predict.stock.controller;


import com.predict.stock.account.Account;
import com.predict.stock.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/account/{role}/{username}/{password}")
    public Account createAccount (@ModelAttribute Account account){
        return accountService.save(account);
    }

    @GetMapping("/account/signup")
    public String register(){
        return "signup";
    }

}
