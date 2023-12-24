package com.example.dizajn.service.impl;

import com.example.dizajn.Exception.NoName;
import com.example.dizajn.Exception.Nofound;
import com.example.dizajn.model.Userd;
import com.example.dizajn.repository.Userrepod;
import com.example.dizajn.service.Userservice;
import org.springframework.stereotype.Service;

@Service
public class Userserviceimpl implements Userservice {

    private final Userrepod userrepod;

    public Userserviceimpl(Userrepod userrepod) {
        this.userrepod = userrepod;
    }

    @Override
    public Userd login(String email, String password) {
        if(email.isEmpty() || email==null || password.isEmpty() || password==null)
        {
            throw new IllegalArgumentException();
        }
        return userrepod.findByEmailAndPassword(email,password).orElseThrow(Nofound :: new);
    }


    @Override
    public Userd registration(String name, String surname, String email, String password, String location) {
        if(name.isEmpty() || name==null || email.isEmpty() || email==null || password.isEmpty() || password==null || location.isEmpty() || location==null)
        {
            throw  new NoName();
        }
        Userd user = new Userd(name,surname,email,password,location);
        return userrepod.save(user);
    }

    @Override
    public Integer soberipoeni(Long id) {

        Userd u = userrepod.findById(id);
        Integer poeni = u.getPoeni();
        poeni = poeni + 1;
        u.setPoeni(poeni);
        return poeni;
    }
}
