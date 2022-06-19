package com.example.graphql.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HumanEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;
    private Integer height;
}
