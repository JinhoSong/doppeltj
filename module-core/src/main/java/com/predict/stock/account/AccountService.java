package com.predict.stock.account;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {


    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Account account = accountRepository.findAccountByUsername(username);
        if(account == null){
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .roles((account.getRole()))
                .build();
    }
    public Account save(Account account){
        account.encodePassword(passwordEncoder);
        return this.accountRepository.save(account);
    }

    // 요청이 들어오면  account가 들어오면 account의 비밀번호를 인코딩 한 뒤에 저장한다.
    // DTO로 바꾸려면 들어오는 변수가 Dto로 바뀌고 Dto의 비밀번호를 인코딩 한 뒤 account에 전달하면 된다.

}
