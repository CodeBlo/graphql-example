package com.example.graphql.query;

import com.example.graphql.converter.HumanConverter;
import com.example.graphql.repository.HumanRepository;
import com.example.graphql.types.Human;
import com.netflix.graphql.dgs.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DgsComponent
@RequiredArgsConstructor
public class HumanQuery {

    private final HumanRepository humanRepository;

    @DgsQuery
    public List<Human> humans(@InputArgument Optional<String> nameFilter,
                              @InputArgument Optional<Integer> ageFilter,
                              @InputArgument Optional<Integer> heightFilter) {
        return humanRepository.
                findAll()
                .stream()
                .filter(h -> h.getName().toLowerCase().contains(nameFilter.orElse("").toLowerCase()))
                .filter(h -> h.getAge() >= ageFilter.orElse(0))
                .filter(h -> h.getHeight() >= heightFilter.orElse(0))
                .map(HumanConverter::toType)
                .collect(Collectors.toList());
    }


    @DgsData(parentType = "Human", field = "age")
    public Integer age(DgsDataFetchingEnvironment dfe){
        Human human = dfe.getSource();
        return human.getAge() + 100;
    }
}
