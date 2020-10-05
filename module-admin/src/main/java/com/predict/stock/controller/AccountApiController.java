package com.predict.stock.controller;


import com.predict.stock.Dto.account.AccountRequestDto;
import com.predict.stock.account.Account;
import com.predict.stock.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountApiController {

    private final AccountService accountService;

    @PostMapping("/api/v1/register")
    public Account register_save(@RequestBody AccountRequestDto accountRequestDto){
        return null;
    }

}
