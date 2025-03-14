package com.pharmaconnect.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patients")
public class Patient {
    @Id
    private String id;

    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;

    private List<String> fileResourceIds;
}