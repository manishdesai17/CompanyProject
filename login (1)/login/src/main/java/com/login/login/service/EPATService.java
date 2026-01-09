package com.login.login.service;

import com.login.login.dto.BidderDTO;
import com.login.login.dto.BidderVerifiedDTO;
import com.login.login.entity.Bidders;
import com.login.login.enums.Status;
import com.login.login.exception.BidderNotFoundException;
import com.login.login.helper.APIResponse;
import com.login.login.repository.EPATRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class EPATService {

    @Autowired
    private EPATRepository epatRepository;


    public Bidders createBidder(BidderDTO bidderDTO)
    {
        Bidders bidder=new Bidders();
        bidder.setName(bidderDTO.getName());
        bidder.setEmail(bidderDTO.getEmail());
        bidder.setPanCard(bidderDTO.getPanCard());
        bidder.setPhone(bidderDTO.getPhone());
        bidder.setPassword(null);
        bidder.setIsVerified(0);
        bidder.setStatus(Status.ACTIVE);
        epatRepository.save(bidder);
        return  bidder;
    }

    public String updatePassword(String email,String password)
    {
        epatRepository.updateBidderPassword(email,password);
        return "successfully updated";
    }


    public String generateTempPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@$";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }


    public APIResponse authenticateBidder(String email) {

        BidderVerifiedDTO bidder = epatRepository.findByEmail(email);

        if (bidder == null) {
            throw new BidderNotFoundException("You are not bidder please register first.");
        }

        if (bidder.getIsVerified() == 0) {
            String tempPass = generateTempPassword();
            epatRepository.updateBidder(email, tempPass);

            BidderVerifiedDTO newBidder = epatRepository.findByEmail(email);

            if (tempPass.equals(newBidder.getPassword())) {
                return new APIResponse(HttpStatus.OK.value(),
                        "Login Successfully with Temp Password " + tempPass,
                        LocalDateTime.now());
            }
        }

        return new APIResponse(HttpStatus.OK.value(),
                "Bidder successfully login.",
                LocalDateTime.now());
    }




//    public void sendTempPasswordEmail(String email, String tempPass) {
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom(EMAIL_FROM);
//            message.setTo(email);
//            message.setSubject(EMAIL_SUBJECT);
//            message.setText(buildEmailBody(tempPass));
//            mailSender.send(message);
//            log.info("Temp password emailed to: {}", email);
//        } catch (Exception e) {
//            log.error("Failed to send email to {}: {}", email, e.getMessage());
//            // In real: Queue for retry via RabbitMQ
//        }
//    }

//    private String buildEmailBody(String tempPass) {
//        return """
//                Dear User,
//
//                Your temporary password for eProcurement Technologies Ltd. is: %s
//
//                Please log in immediately and change it to a secure one. This password expires in %d hours.
//
//                If you didn't request this, contact support@eprocuretech.com.
//
//                Best regards,
//                eProcurement Team
//                """.formatted(tempPass, TEMP_PASS_EXPIRY_HOURS);
//    }
}
