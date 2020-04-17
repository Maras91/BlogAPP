package com.blog.app.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NotBlank
    @Column(unique = true)
    private String login;
    @NotBlank
    private String password;
  //  @NotBlank
    private AccountType accountType;

    public Account() {
    }

    public Account(Long id, String name, @NotBlank String login, @NotBlank String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
