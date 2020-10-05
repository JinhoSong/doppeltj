package com.predict.stock.account;


import com.predict.stock.Dto.account.AccountRequestDto;
import com.predict.stock.Role.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique =true)
    private String username;

    @NotNull
    private String password;

    @ManyToMany
    @JoinTable(
            name="account_role",
            joinColumns = @JoinColumn(name="account_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles = new ArrayList<>(); //null point 방지

    public Account(AccountRequestDto accountRequestDto){
        this.username=accountRequestDto.getUsername();
        this.password=accountRequestDto.getPassword();
    }

    @Builder
    public Account(String username, String password, List<Role> roles){
        this.username=username;
        this.password=password;
        this.roles=roles;
    }
    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    /*
    public void encodePassword(Account account){
        this.password = "{noop}"+account.getPassword();
    }
     */
}
