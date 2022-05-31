package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.UserPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostsRepository extends JpaRepository<UserPosts, Integer> {
    //need an update

}
