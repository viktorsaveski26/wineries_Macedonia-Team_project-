package com.example.dizajn.service;

import com.example.dizajn.model.Userd;

public interface Userservice {
    Userd login(String email, String password);
    Userd registration(String name, String surname, String email, String password, String location);

    Integer soberipoeni(Long id);

}
