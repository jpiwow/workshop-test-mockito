package com.pgs.workshop.domain;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class User {
    
    private Long id;
    private String firstName;
    private String lastName;
    private Company company;
    
}
