package com.login.login.controller;

import com.login.login.dto.BidderDTO;
import com.login.login.entity.Bidders;
import com.login.login.helper.APIResponse;
import com.login.login.service.EPATService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/epat")
public class EPATController {
    @Autowired
    private EPATService epatService;

    @PostMapping("/createBidder")
    public APIResponse createEPATBidder(@RequestBody BidderDTO bidders){
        epatService.createBidder(bidders);
        return new APIResponse(HttpStatus.CREATED.value(),"Bidder created successfully", LocalDateTime.now());

    }

    @PutMapping("/updatePassword")
    public APIResponse updatePassword(@RequestParam String email,
                                      @RequestParam String password) {
        epatService.updatePassword(email,password);
        return new APIResponse(HttpStatus.OK.value(),"Password updated successfully", LocalDateTime.now());
    }


}
