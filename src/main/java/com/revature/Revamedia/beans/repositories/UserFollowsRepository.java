package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.UserFollows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface UserFollowsRepository extends JpaRepository<UserFollows, Integer> {

}
