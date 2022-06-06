package com.revature.Revamedia.beans.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.Revamedia.entities.UserPosts;

@Repository
public interface UserPostsRepository extends JpaRepository<UserPosts, Integer> {

    @Query("FROM UserPosts WHERE ownerId= :ownerId")
    public List<UserPosts> getUserPostsByUser(@Param("ownerId") Integer id);
}
