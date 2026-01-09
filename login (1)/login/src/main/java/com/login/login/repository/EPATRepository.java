package com.login.login.repository;

import com.login.login.dto.BidderDTO;
import com.login.login.dto.BidderVerifiedDTO;
import com.login.login.entity.Bidders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EPATRepository extends JpaRepository<Bidders,Long> {

    @Query(value = "select email,password,is_verified from Bidders where email=:email",nativeQuery = true)
    BidderVerifiedDTO findByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "update Bidders set password=:password,isVerified=1 where email=:email",nativeQuery = true)
    void updateBidder(@Param("email") String email,@Param("password") String password);


    @Modifying
    @Transactional
    @Query(value = "update Bidders set password=:password where email=:email",nativeQuery = true)
    void updateBidderPassword(@Param("email") String email,@Param("password") String password);

    @Query(value = "select password from Bidders where email=:email",nativeQuery = true)
    BidderVerifiedDTO findPasswordByEmail(@Param("email") String email);

}
