package com.predict.stock.Dto.account;

import com.predict.stock.account.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDtoSaveRequestDto {

    private String username;

    private String password;

    private String password_confirm;

    @Builder
    public AccountDtoSaveRequestDto(String username, String password, String password_confirm){
        this.username = username;
        this.password = password;
        this.password_confirm = password_confirm;
    }

    public Account toEntity(){
        return Account.builder()
                .username(username)
                .password(password)
                //.role("user")
                .build();
    }


    // 기본 role는 user로 통일한다.


}
