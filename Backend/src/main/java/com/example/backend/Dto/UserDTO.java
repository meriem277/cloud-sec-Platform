package com.example.backend.DTO;

import com.example.backend.Entites.Enums.RoleType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    long idUser;
    String username;
    String email;
    String image;
    String phone;
    String address;
    RoleType role;
    boolean enabled;
}
