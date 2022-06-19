package com.example.graphql.mutation;

import com.example.graphql.converter.HumanConverter;
import com.example.graphql.entity.HumanEntity;
import com.example.graphql.repository.HumanRepository;
import com.example.graphql.types.Human;
import com.example.graphql.types.HumanInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;

import static com.example.graphql.converter.HumanConverter.toEntity;

@DgsComponent
@RequiredArgsConstructor
public class HumanMutation {

    private final HumanRepository humanRepository;

    @DgsMutation
    public Human createHuman(@InputArgument("input") HumanInput input){
        HumanEntity entity = toEntity(input);
        return HumanConverter.toType(humanRepository.save(entity));
    }
}
