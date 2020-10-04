package com.predict.stock.controller;


import com.predict.stock.account.Account;
import com.predict.stock.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{role}/{username}/{password}")
    public Account createAccount (@ModelAttribute Account account){
        return accountService.save(account);
    }

    @GetMapping("/login")
    public String login(){
        return "/account/login";
    }

//    @PostMapping("/login")
//    public String login(Account account){
//        // 넘어오는건 username과 password 이를 검증하려면 username으로 가져온 비밀번호 값과 로직으로 해싱한 값이 일치하면 된다.
//        System.out.println(account.getId());
//        if(accountService.loadUserByUsername(account.getUsername()) != null){
//            // 로그인 성공시 '/'로 redirect 한다.
//            return "redirect:/";
//        } else {
//            return "redirect:/account/login";
//        }
//    }

    @GetMapping("/register")
    public String register(){
        return "/account/register";
    }


    @PostMapping("/register")
    public String register(Account account){
        accountService.save(account);
        return "redirect:/";
    }

}
