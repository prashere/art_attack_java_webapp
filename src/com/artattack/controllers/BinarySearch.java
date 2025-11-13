package com.artattack.controllers;

import com.artattack.models.ArtAttackModel;
import java.util.ArrayList;
import java.util.function.Function;

/**
 *
 * @author Prashidika
 */
public class BinarySearch {

    public static Function<ArtAttackModel, Comparable<?>> getterMethod;

    /**
     * Sets the getter method based on the provided search field name for the
     * ArtAttackModel class.
     *
     * @param searchField The field name used to determine the search attribute.
     */
    public static void setSearchAttribute(String searchField) {
        switch (searchField) {
            case "Title" ->
                getterMethod = ArtAttackModel::getArtworkTitle;
            case "Artist" ->
                getterMethod = ArtAttackModel::getArtist;
            case "Category" ->
                getterMethod = ArtAttackModel::getArtworkCategory;
            case "Medium" ->
                getterMethod = ArtAttackModel::getArtworkMedium;
            case "Art Style" ->
                getterMethod = ArtAttackModel::getArtStyle;
            case "Creation Date" ->
                getterMethod = ArtAttackModel::getCreationDate;
            case "Height" ->
                getterMethod = ArtAttackModel::getArtworkHeight;
            case "Width" ->
                getterMethod = ArtAttackModel::getArtworkWidth;
            case "Current Location" ->
                getterMethod = ArtAttackModel::getArtworkLocation;
            case "Valuation" ->
                getterMethod = ArtAttackModel::getArtworkValuation;
        }
    }

    /**
     * Finds all occurrences of the target value within the provided sorted
     * ArrayList of ArtAttackModel instances.
     *
     * Utilizes binary search to locate the first and last occurrences, and
     * returns their indices in a new ArrayList.
     *
     * @param artworkList The sorted ArrayList of ArtAttackModel instances to
     * search within.
     * @param target The value to find occurrences of within the ArrayList.
     * @return An ArrayList containing the indices of all occurrences of the
     * target value.
     */
    public static ArrayList<Integer> findAllOccurrences
        (ArrayList<ArtAttackModel> artworkList, Comparable target) {
        // Declaring an arrayList to store the indexes of target
        ArrayList<Integer> occurrences = new ArrayList<>();

        if (artworkList.isEmpty()) {
            return occurrences;
        }

        // function call
        int firstOccurrence = binarySearchFirst(artworkList, target);
        // function call
        int lastOccurrence = binarySearchLast(artworkList, target);

        /* Adding indices of occurrences to the ArrayList if at least one 
        occurrence is found */
        if (firstOccurrence != -1) {
            for (int i = firstOccurrence; i <= lastOccurrence; i++) {
                occurrences.add(i);
            }
        }
        return occurrences;
    }

    /**
     * Performs a binary search to find the index of the first occurrence of the
     * target value within the provided sorted ArrayList of ArtAttackModel
     * instances.
     *
     * @param artworkList The sorted ArrayList of ArtAttackModel instances to
     * search within.
     * @param target The value to find the first occurrence of within the
     * ArrayList.
     * @return The index of the first occurrence of the target value, or -1 if
     * not found.
     */
    public static int binarySearchFirst(ArrayList<ArtAttackModel> artworkList, 
            Comparable target) {
        int low = 0, high = artworkList.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Comparable<?> checkValue = "" + getterMethod.apply
        (artworkList.get(mid));

            if (!(checkValue instanceof Comparable) || !(target instanceof 
                    Comparable)) 
            {
                System.out.println("Values aren't comparable!");
            }
            /* Converting comparison Strings to lowercase for non-case-sensitive
            comparisons */
            String checkValueLower = ((String) checkValue).toLowerCase();
            String targetLower = ((String) target).toLowerCase();

            if (checkValueLower.compareTo(targetLower) >= 0) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * Performs a binary search to find the index of the last occurrence of the
     * target value within the provided sorted ArrayList of ArtAttackModel
     * instances.
     *
     * @param artworkList The sorted ArrayList of ArtAttackModel instances to
     * search within.
     * @param target The value to find the last occurrence of within the
     * ArrayList.
     * @return The index of the last occurrence of the target value, or -1 if
     * not found.
     */
    public static int binarySearchLast(ArrayList<ArtAttackModel> artworkList, 
            Comparable target) {
        int low = 0, high = artworkList.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Comparable<?> checkValue = "" + getterMethod.apply
        (artworkList.get(mid));

            if (!(checkValue instanceof Comparable) || !(target instanceof Comparable))
            {
                System.out.println("Values aren't comparable");
            }
            /* Converting comparison Strings to lowercase for non-case-sensitive 
            comparisons */
            String checkValueLower = ((String) checkValue).toLowerCase();
            String targetLower = ((String) target).toLowerCase();

            if (checkValueLower.compareTo(targetLower) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
                result = mid;
            }
        }
        return result;
    }

}
