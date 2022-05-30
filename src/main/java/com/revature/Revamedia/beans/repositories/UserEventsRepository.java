package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.UserEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventsRepository extends JpaRepository<UserEvents, Integer> {
}
