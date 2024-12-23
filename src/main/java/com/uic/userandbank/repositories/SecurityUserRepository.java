package com.uic.userandbank.repositories;

import com.uic.userandbank.security.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser,Long> {

    @Query("SELECT u FROM SecurityUser u WHERE u.email = :email")
    SecurityUser findUserByEmail(@Param("email") String email);
}
