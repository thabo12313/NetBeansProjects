/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hsyd100_sa1;

/**
 * 05HA2310394
 * @author thabo
 */
public class Recordings {
    private String title;
    private String artist;
    private int playingTimeSeconds;

    public Recordings(String title, String artist, int playingTimeSeconds) {
        this.title = title;
        this.artist = artist;
        this.playingTimeSeconds = playingTimeSeconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPlayingTimeSeconds() {
        return playingTimeSeconds;
    }

    public void setPlayingTimeSeconds(int playingTimeSeconds) {
        this.playingTimeSeconds = playingTimeSeconds;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", playingTimeSeconds=" + playingTimeSeconds +
                '}';
    }

    public static void main(String[] args) {
        Recordings recording = new Recordings("Song Title", "Artist Name", 240);

        System.out.println("Recording title: " + recording.getTitle());
        System.out.println("Artist: " + recording.getArtist());
        System.out.println("Playing time (seconds): " + recording.getPlayingTimeSeconds());
        System.out.println(recording);
    }
}

