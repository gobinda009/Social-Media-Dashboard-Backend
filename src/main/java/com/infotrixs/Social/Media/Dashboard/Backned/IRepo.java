package com.infotrixs.Social.Media.Dashboard.Backned;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String newEmail);
}
