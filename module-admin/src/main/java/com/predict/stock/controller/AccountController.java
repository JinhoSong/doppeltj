package com.predict.stock.controller;


import com.predict.stock.Dto.account.AccountRequestDto;
import com.predict.stock.account.AccountService;
import com.predict.stock.validator.AccountValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountValidator accountValidator;

    @GetMapping("/login")
    public String login(){
        return "/account/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("accountRequestDto",new AccountRequestDto());
        return "/account/register";
    }


    @PostMapping("/register")
    public String register(@Valid AccountRequestDto accountRequestDto, BindingResult bindingResult){
        accountValidator.validate(accountRequestDto, bindingResult);
        //System.out.println(bindingResult.hasErrors());
        if(bindingResult.hasErrors()) {
            return "/account/register"; // 실패
        }
        else {
            // 성공
            accountService.save(accountRequestDto);
            return "redirect:/";
        }
    }

}
