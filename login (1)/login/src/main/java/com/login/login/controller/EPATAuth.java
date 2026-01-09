package com.login.login.controller;

import com.login.login.helper.APIResponse;
import com.login.login.service.EPATService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/epat/auth")
public class EPATAuth {

    @Autowired
    private EPATService epatService;


    @PostMapping("/authBidder")
    public APIResponse authenticateBidder(@RequestBody String email) {
        APIResponse response =epatService.authenticateBidder(email);
        return response;
    }
}
