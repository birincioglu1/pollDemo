package com.example.pollDemo.restApi;

import com.example.pollDemo.business.IUserContactService;
import com.example.pollDemo.model.CheckEmailOrPhoneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserContactController {

    IUserContactService userContactService;

    @Autowired
    public UserContactController(IUserContactService userContactService) {
        this.userContactService = userContactService;
    }

    @PostMapping("/find")
    public String auth(@RequestBody CheckEmailOrPhoneRequest request)
    {

        return this.userContactService.userContactFindByValue(request.getValue());

    }

}
