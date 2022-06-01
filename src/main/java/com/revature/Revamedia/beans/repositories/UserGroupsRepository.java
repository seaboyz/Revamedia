package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.UserGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupsRepository extends JpaRepository<UserGroups, Integer> {
}
