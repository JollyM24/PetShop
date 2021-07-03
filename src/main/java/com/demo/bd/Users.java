package com.demo.bd;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "log")
    private String username;

    @Column(name = "par")
    private String password;

    public boolean conf_auth(String pass)
    {
        return password.equals(pass);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", log='" + username + '\'' +
                ", par='" + password + '\'' +
                '}';
    }
}
