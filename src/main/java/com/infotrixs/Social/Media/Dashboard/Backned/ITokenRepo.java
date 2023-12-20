package com.infotrixs.Social.Media.Dashboard.Backned;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<UserAuthenticationToken,Integer> {
}
