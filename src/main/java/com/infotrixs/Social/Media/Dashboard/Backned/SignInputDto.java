package com.infotrixs.Social.Media.Dashboard.Backned;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignInputDto {
    private String email;

    private String password;
}
