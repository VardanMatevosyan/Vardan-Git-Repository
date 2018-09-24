package ru.matevosyan.persistens.repository;

import ru.matevosyan.entity.Offer;

import java.util.List;

/**
 * Interface for Offer repository.
 * @param <E> class of Offer type.
 */
public interface IOffer<E extends Offer> {
    /**
     * Save Offer entry to the database.
     * @param entry offer.
     */
    void add(E entry);

    /**
     * Get all offers from the database.
     * @return list of Offer objects.
     */
    List<Offer> getOffers();

    /**
     * Get image path from the database.
     * @return offers image path.
     */
    String getImagePath();

    /**
     * Change sell status in offer table.
     * @param statusButton status value.
     * @param offerId offer id value.
     */
    void changeSellState(Boolean statusButton, Integer offerId);

    /**
     * To show the offers by the last day.
     * @return list of offers.
     */
    List<E> getLastDayOffers();

    /**
     * To show offers with photo.
     * @return list of offers.
     */
    List<E> getOfferWithPhoto();

    /**
     * Get the list of offers by brand.
     * @param brand car brand.
     * @return list of offers.
     */
    List<E> getOffersByBrand(String brand);
}