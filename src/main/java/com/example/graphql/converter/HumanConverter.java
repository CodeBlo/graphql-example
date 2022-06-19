package com.example.graphql.converter;

import com.example.graphql.entity.HumanEntity;
import com.example.graphql.types.Human;
import com.example.graphql.types.HumanInput;

public final class HumanConverter {

    public static HumanEntity toEntity(HumanInput humanInput){
        return HumanEntity.builder()
                .name(humanInput.getName())
                .age(humanInput.getAge())
                .height(humanInput.getHeight())
                .build();
    }

    public static Human toType(HumanEntity humanEntity){
        return Human.newBuilder()
                .name(humanEntity.getName())
                .age(humanEntity.getAge())
                .height(humanEntity.getHeight())
                .build();
    }
}
