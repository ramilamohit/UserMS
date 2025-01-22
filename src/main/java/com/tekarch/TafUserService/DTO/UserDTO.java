package com.tekarch.TafUserService.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String phone;

}
