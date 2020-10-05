package com.predict.stock.account;


import com.predict.stock.Dto.account.AccountRequestDto;
import com.predict.stock.Role.Role;
import com.predict.stock.Role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {


    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Account account = accountRepository.findByUsername(username);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("role_user"));
        System.out.println(new User(account.getUsername(),account.getPassword(),grantedAuthorities));
        return new User(account.getUsername(),account.getPassword(),grantedAuthorities);

        // UserDetails를 구현한 객체인 User를 리턴하면된다.

    }

    public Account save(AccountRequestDto accountRequestDto){

            //입력한 비밀번호와 비밀번호 확인이 같다면
            Role role = roleRepository.findByName("role_user");
            // 일반 유저 권한을 찾아서 가져온다음.
            Account account = new Account(accountRequestDto);
            // 새로 account를 하나 만들어서
            account.encodePassword(passwordEncoder);
            account.getRoles().add(role);
            return accountRepository.save(account);
    }

    // 인증을 위한 메소드

//    public Account save(Account account){
//        account.encodePassword(passwordEncoder);
//        Role role = new Role();
//        role.setId(1l);
//        role.setName("role_user");
//        account.getRoles().add(role);
//        return accountRepository.save(account);
//    }

    // 요청이 들어오면  account가 들어오면 account의 비밀번호를 인코딩 한 뒤에 저장한다.
    // DTO로 바꾸려면 들어오는 변수가 Dto로 바뀌고 Dto의 비밀번호를 인코딩 한 뒤 account에 전달하면 된다.

}
