package com.bharath.socialmedia.core.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private String userId;

    @Size(min = 2, message = "User name should greater then 2 characters")
    private String userName;

    @Email
    private String email;

    private String city;

    private Integer pinCode;

    @Max(value = 100)
    private Integer age;
}
