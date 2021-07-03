package com.demo.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersImpl {

    private UsersRep usersRep;

    @Autowired
    public UsersImpl(UsersRep usersRep) {
        this.usersRep = usersRep;
    }

    public void add(Users users) {
        usersRep.save(users);
    }

    public List<Users> getAll() {
        return usersRep.findAll();
    }

    public void delete(int id) {
        usersRep.delete(usersRep.getOne(id));
    }

    public Users getuser(String log)
    {
        return usersRep.findByUsername(log);
    }

    public boolean checkpar(String log, String par)
    {
        Users user = usersRep.findByUsername(log);
        if (user == null) return false;
        return user.conf_auth(par);
    }
}