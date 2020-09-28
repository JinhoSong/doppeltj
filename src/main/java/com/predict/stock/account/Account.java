package com.predict.stock.account;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

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

    private String password;

    private String role;

    @Builder
    public Account(String username, String password, String role){
        this.username=username;
        this.password=password;
        this.role=role;
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
