package com.infotrixs.Social.Media.Dashboard.Backned;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITokenService {
    @Autowired
    ITokenRepo iTokenRepo;
    public void createToken(UserAuthenticationToken token) {

            iTokenRepo.save(token);

    }
}
