package com.revature.Revamedia.beans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Revamedia.entities.UserComments;

@Repository
public interface UserCommentsRepository extends JpaRepository<UserComments, Integer> {
    void deleteById(Integer id);
}
