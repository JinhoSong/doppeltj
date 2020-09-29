package com.predict.stock.Dto.account;


import com.predict.stock.account.Account;
import lombok.Getter;

@Getter
public class AccountResponseDto {

    private Long id;
    private String username;
    private String password;
    private String role;

    public AccountResponseDto(Account account){
        this.id=account.getId();
        this.username=account.getUsername();
        this.password=account.getPassword();
        this.role=account.getRole();
    }

}
