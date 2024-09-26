package com.edpedia.leads.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "leads")
public class Lead  {
    @Id
    private UUID id = UUID.randomUUID();
    private String contactNo;
    private String schoolName;
    private String contactPerson;
    private String location;
    private String schoolStrength;
    private String boards;
    private String date;
    private String status;
}
