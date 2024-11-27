package com.learnwithak.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRestModel {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;

}
