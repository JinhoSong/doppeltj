package com.predict.stock.controller;

import com.predict.stock.Dto.account.AccountDtoSaveRequestDto;
import com.predict.stock.Dto.account.AccountResponseDto;
import com.predict.stock.account.Account;
import com.predict.stock.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountApiController {

    private final AccountService accountService;

    @PostMapping("/api/v1/register")
    public Account register_save(@RequestBody AccountDtoSaveRequestDto accountDto){
        System.out.println(accountDto.getUsername());
        if(accountDto.getPassword().equals(accountDto.getPassword_confirm())){
            // 비밀번호 두개가 일치하면
            System.out.println("비밀번호 일치");
            return accountService.save(accountDto.toEntity());
        }
        else {
            System.out.println("비밀번호 불일치");
            return accountDto.toEntity();
        }
    }

}
