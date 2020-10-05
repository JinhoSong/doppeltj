package com.predict.stock.validator;

import com.predict.stock.Dto.account.AccountRequestDto;
import com.predict.stock.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AccountValidator implements Validator {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AccountRequestDto.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        AccountRequestDto accountRequestDto = (AccountRequestDto) obj;
        if(!((AccountRequestDto) obj).getPassword().equals(((AccountRequestDto) obj).getPassword_confirm())){
            //비밀번호와 비밀번호 확인이 다르다면
            errors.rejectValue("password", "key","비밀번호가 일치하지 않습니다.");
        } else if(accountRepository.findByUsername(((AccountRequestDto) obj).getUsername()) !=null){
            // 이름이 존재하면
            errors.rejectValue("username", "key","이미 사용자 이름이 존재합니다.");
        }

    }// 비밀번호 검사할때 쓰면 될듯
}
