package com.artattack.controllers;

import com.artattack.models.ArtAttackModel;
import com.artattack.utils.StringUtil;
import java.util.ArrayList;
import java.util.function.Function;
import javax.swing.JOptionPane;

/**
 *
 * @author Prashidika
 */
public class MergeSort {

    // Setting the default order as Ascending
    private static boolean ascendingOrder = true;
    public static Function<ArtAttackModel, Comparable<?>> getterMethod;

    /**
     * Sets the sorting order for the MergeSort algorithm.
     *
     * @param ascendingOrder: If true, sets the sorting order to ascending; if
     * false, sets it to descending.
     */
    public static void setAscendingOrder(boolean ascendingOrder) {
        MergeSort.ascendingOrder = ascendingOrder;
    }

    /**
     * Sets the getterMethod based on the provided sort field name for the
     * ArtAttackModel class.
     *
     * @param sortField: The field name used to determine the sorting attribute.
     */
    public static void setSortAttribute(String sortField) {
        switch (sortField) {
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
     * Recursively sorts the given ArrayList of ArtAttackModel instances using
     * the merge sort algorithm.
     *
     * @param arr The ArrayList to be sorted.
     */
    public static void sort(ArrayList<ArtAttackModel> arr) {
        if (arr.size() == 1) {
            return;
        }
        // Dividing the main array into 2 sub arrays and filling in the elements
        ArrayList<ArtAttackModel> first = new ArrayList<>();
        for (int i = 0; i < (arr.size() / 2); i++) {
            first.add(i, arr.get(i));
        }

        ArrayList<ArtAttackModel> second = new ArrayList<>();
        for (int i = 0; i < (arr.size() - first.size()); i++) {
            second.add(i, arr.get(i + first.size()));
        }

        // Recursive call
        sort(first);
        sort(second);

        merge(first, second, arr);
    }

    /**
     * Merges two sorted ArrayLists, 'first' and 'second', into a single sorted
     * ArrayList. The sorting order is determined by the 'ascendingOrder' flag.
     *
     * @param first The first sorted ArrayList to be merged.
     * @param second The second sorted ArrayList to be merged.
     * @param mainArray The resulting merged ArrayList.
     */
    public static void merge(ArrayList<ArtAttackModel> first,
            ArrayList<ArtAttackModel> second,
            ArrayList<ArtAttackModel> mainArray) {
        // Clearing the mainArray ArrayList
        mainArray.clear();

        // Initializing the counters
        int firstCounter = 0, secondCounter = 0, mainArrayCounter = 0;

        // Sorting and merging
        while (firstCounter < first.size() && secondCounter < second.size()) {
            if (ascendingOrder) {
                /*Retrieving values from the respective elements in 'first' 
                and 'second' lists using the provided getterMethod.*/
                Comparable<?> firstValue = getterMethod.apply(first.get(firstCounter));
                Comparable<?> secondValue = getterMethod.apply(second.get(secondCounter));

                // Ensuring the values are comparable
                if (!(firstValue instanceof Comparable)
                        || !(secondValue instanceof Comparable)) {
                    System.out.println("Values aren't comparable");
                    JOptionPane.showMessageDialog(null,
                            "Values aren't comparable",
                            StringUtil.TITLE_ERROR,
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if (((Comparable) firstValue).compareTo(secondValue) < 0) {
                    mainArray.add(mainArrayCounter, first.get(firstCounter));
                    firstCounter++;
                } else {
                    mainArray.add(mainArrayCounter, second.get(secondCounter));
                    secondCounter++;
                }
                mainArrayCounter++;

            } else if (!ascendingOrder) {
                Comparable<?> firstValue = getterMethod.apply(first.get(firstCounter));
                Comparable<?> secondValue = getterMethod.apply(second.get(secondCounter));

                // Ensure the values are comparable
                if (!(firstValue instanceof Comparable)
                        || !(secondValue instanceof Comparable)) {
                    System.out.println("Values aren't comparable");
                    JOptionPane.showMessageDialog(null,
                            "Values aren't comparable",
                            StringUtil.TITLE_ERROR,
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if (((Comparable) firstValue).compareTo(secondValue) > 0) {
                    mainArray.add(mainArrayCounter, first.get(firstCounter));
                    firstCounter++;
                } else {
                    mainArray.add(mainArrayCounter, second.get(secondCounter));
                    secondCounter++;
                }
                mainArrayCounter++;
            }
        }

        // Adding the remaining elements
        while (firstCounter < first.size()) {
            mainArray.add(mainArrayCounter, first.get(firstCounter));
            firstCounter++;
            mainArrayCounter++;
        }

        while (secondCounter < second.size()) {
            mainArray.add(mainArrayCounter, second.get(secondCounter));
            secondCounter++;
            mainArrayCounter++;
        }
    }

    /**
     * Performs merge sort on the provided ArrayList of ArtAttackModel instances
     *
     * @param artworkList The ArrayList to be sorted.
     * @return The sorted ArrayList.
     */
    public static ArrayList<ArtAttackModel> mergeSort(ArrayList<ArtAttackModel>
            artworkList) {
        sort(artworkList);
        return artworkList;
    }
}
