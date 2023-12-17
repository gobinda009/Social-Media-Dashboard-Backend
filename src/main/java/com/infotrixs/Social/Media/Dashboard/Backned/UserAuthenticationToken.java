package com.infotrixs.Social.Media.Dashboard.Backned;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UAuthentication")
public class UserAuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    private String tokenValue;

    public UserAuthenticationToken(User user){
        this.user= user;
        this.tokenValue = UUID.randomUUID().toString();
    }

    @OneToOne
    @JoinColumn(name="fk_user_id")
    private User user;
}
