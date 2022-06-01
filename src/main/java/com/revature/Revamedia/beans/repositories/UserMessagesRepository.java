package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.UserMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessagesRepository extends JpaRepository<UserMessages, Integer> {
}
