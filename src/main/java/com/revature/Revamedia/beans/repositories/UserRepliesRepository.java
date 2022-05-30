package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.UserReplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepliesRepository extends JpaRepository<UserReplies, Integer> {
}
