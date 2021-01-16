package com.example.pollDemo.business;

import com.example.pollDemo.dataAccess.IUserContactDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContactService implements IUserContactService {

    IUserContactDal userContactDal;
    @Autowired
    public UserContactService(IUserContactDal userContactDal) {
        this.userContactDal = userContactDal;
    }




    @Override
    public String userContactFindByValue(String value) {
        return this.userContactDal.userContactFindByValue(value);
    }
}
