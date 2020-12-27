package com.hyperplan.modularschedule.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "blocks")
@AllArgsConstructor
public class Block {
    @Id
    private String id;
    @Setter
    private String name;
}
