package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.UserComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCommentsRepository extends JpaRepository<UserComments, Integer> {
    void deleteById(Integer id);
}
