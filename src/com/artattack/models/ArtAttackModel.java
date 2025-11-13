package com.artattack.models;

/**
 * The ArtAttackModel class represents an artwork with various properties such
 * as ID, title, artist, category, etc. Instances of this class are used to
 * store and manipulate information about individual artworks.
 *
 *
 * @author Prashidika
 */
public class ArtAttackModel {

    private int artworkId;
    private String artworkTitle;
    private String artist;
    private String artworkCategory;
    private String artworkMedium;
    private String artStyle;
    private String creationDate;
    private int artworkHeight;
    private int artworkWidth;
    private long artworkValuation;
    private String artworkLocation;

    public ArtAttackModel(int artworkId, String artworkTitle, String artist,
            String artworkCategory, String artworkMedium, String artStyle, 
            String creationDate, int artworkHeight, int artworkWidth, 
            long artworkValuation, String artworkLocation) {
        this.artworkId = artworkId;
        this.artworkTitle = artworkTitle;
        this.artist = artist;
        this.artworkCategory = artworkCategory;
        this.artworkMedium = artworkMedium;
        this.artStyle = artStyle;
        this.creationDate = creationDate;
        this.artworkHeight = artworkHeight;
        this.artworkWidth = artworkWidth;
        this.artworkValuation = artworkValuation;
        this.artworkLocation = artworkLocation;
    }

    public int getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(int artworkId) {
        this.artworkId = artworkId;
    }

    public String getArtworkTitle() {
        return artworkTitle;
    }

    public void setArtworkTitle(String artworkTitle) {
        this.artworkTitle = artworkTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtworkCategory() {
        return artworkCategory;
    }

    public void setArtworkCategory(String artworkCategory) {
        this.artworkCategory = artworkCategory;
    }

    public String getArtworkMedium() {
        return artworkMedium;
    }

    public void setArtworkMedium(String artworkMedium) {
        this.artworkMedium = artworkMedium;
    }

    public String getArtStyle() {
        return artStyle;
    }

    public void setArtStyle(String artStyle) {
        this.artStyle = artStyle;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getArtworkHeight() {
        return artworkHeight;
    }

    public void setArtworkHeight(int artworkHeight) {
        this.artworkHeight = artworkHeight;
    }

    public int getArtworkWidth() {
        return artworkWidth;
    }

    public void setArtworkWidth(int artworkWidth) {
        this.artworkWidth = artworkWidth;
    }

    public long getArtworkValuation() {
        return artworkValuation;
    }

    public void setArtworkValuation(long artworkValuation) {
        this.artworkValuation = artworkValuation;
    }

    public String getArtworkLocation() {
        return artworkLocation;
    }

    public void setArtworkLocation(String artworkLocation) {
        this.artworkLocation = artworkLocation;
    }

}
