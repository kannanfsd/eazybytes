package com.eazybytes.mapper;

import com.eazybytes.dto.CardsDto;
import com.eazybytes.entity.Cards;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CardsMapper {
    // Entity to DTO
    CardsDto mapToCardsDto(Cards cards);
    // DTO to Entity creation
    Cards mapToCards(CardsDto cardsDto);
    // DTO to Entity updation
    void mapToCards(CardsDto cardsDto, @MappingTarget Cards cards);
}
