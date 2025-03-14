package com.pharmaconnect.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pharmacies")
public class Pharmacy {
    @Id
    private String id;

    private String doctorId;
    private List<String> medicineNames;
    private String adminId;
}