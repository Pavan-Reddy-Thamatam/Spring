package com.edpedia.leads.collections;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "LEADS_COMMENTS")
public class LeadComments{
    @Id
    private UUID id = UUID.randomUUID();
    private String comments;
    private UUID leadId;
}
