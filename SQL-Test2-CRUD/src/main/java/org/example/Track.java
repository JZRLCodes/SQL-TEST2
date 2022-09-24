package org.example;

import jakarta.persistence.*;
import java.util.Scanner;


@Entity
@Table(name="track")
public class Track {

    private static final long serialVersionUID = 1L;


    //TrackId
   // @Id
   // @Column(name="TrackId")
   // private int trackId;

    @Id
    @Column(name="TrackId", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trackId;



    //Name
    @Column(name="Name")
    private String name;

    //AlbumId
    @Column(name="AlbumId")
    private int albumId;

    //MediaTypeId
    @Column(name="MediaTypeId")
    private int mediaTypeId;

    //GenreId
    @Column(name="GenreId")
    private int genreId;

    //Composer
    @Column(name="Composer")
    private String composer;

    //Milliseconds
    @Column(name="Milliseconds")
    private int milliseconds;

    //Bytes
    @Column(name="Bytes")
    private int bytes;

    //UnitPrice
    @Column(name="UnitPrice")
    private float unitPrice;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getTrackId() {
        return trackId;
    }
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAlbumId() { return albumId; }
    public void setAlbumId(int albumId) { this.albumId = albumId; }

    public int getMediaTypeId() { return mediaTypeId; }
    public void setMediaTypeId(int mediaTypeId) { this.mediaTypeId = mediaTypeId; }

    public int getGenreId() { return genreId; }
    public void setGenreId(int genreId) { this.genreId = genreId; }

    public String getComposer() {
        return composer;
    }
    public void setComposer (String composer) {
        this.composer = composer;
    }

    public int getMilliseconds() { return milliseconds; }
    public void setMilliseconds(int milliseconds) { this.milliseconds = milliseconds; }

    public int getBytes() { return bytes; }
    public void setBytes(int bytes) { this.bytes = bytes; }

    public float getUnitPrice() { return unitPrice; }
    public void setUnitPrice(float unitPrice) { this.unitPrice = unitPrice; }
}
