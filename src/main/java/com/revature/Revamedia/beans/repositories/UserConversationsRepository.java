package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.UserConversations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConversationsRepository extends JpaRepository<UserConversations, Integer> {
}
