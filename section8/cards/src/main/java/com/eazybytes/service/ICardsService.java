package com.eazybytes.service;

import com.eazybytes.dto.CardsDto;

public interface ICardsService {
    /**
     * Creates a new card for the given mobile number.
     * @param mobileNumber
     */
    void createCard(String mobileNumber);

    /**
     * Fetches card details for the given mobile number.
     * @param mobileNumber
     * @return
     */
    CardsDto fetchCard(String mobileNumber);

    /**
     * Updates the card details for the given mobile number.
     * @param cardsDto
     * @return
     */
    boolean updateCard(CardsDto cardsDto);

    /**
     * Deletes the card for the given mobile number.
     * @param mobileNumber
     * @return
     */
    boolean deleteCard(String mobileNumber);
}
