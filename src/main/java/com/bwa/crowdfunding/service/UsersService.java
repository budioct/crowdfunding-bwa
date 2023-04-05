package com.bwa.crowdfunding.service;

import com.bwa.crowdfunding.dao.UsersDao;
import com.bwa.crowdfunding.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UsersService {

    private UsersDao usersDao;

    @Autowired
    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<Users> getAllUsers() {
        return this.usersDao.findAll();
    }


}
