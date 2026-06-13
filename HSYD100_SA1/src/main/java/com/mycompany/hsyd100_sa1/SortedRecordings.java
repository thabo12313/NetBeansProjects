/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hsyd100_sa1;

/**
 *
 * @author thabo
 */
import java.util.Scanner;

public class SortedRecordings {
    private String title;
    private String artist;
    private int playingTimeSeconds;

    public SortedRecordings(String title, String artist, int playingTimeSeconds) {
        this.title = title;
        this.artist = artist;
        this.playingTimeSeconds = playingTimeSeconds;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayingTimeSeconds() {
        return playingTimeSeconds;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Playing Time (seconds): " + playingTimeSeconds;
    }

    // Sorting method for song title
    public static void sortByTitle(SortedRecordings[] recordings) {
        for (int i = 0; i < recordings.length - 1; i++) {
            for (int j = i + 1; j < recordings.length; j++) {
                if (recordings[i].getTitle().compareTo(recordings[j].getTitle()) > 0) {
                    SortedRecordings temp = recordings[i];
                    recordings[i] = recordings[j];
                    recordings[j] = temp;
                }
            }
        }
    }

    // Sorting method for artist
    public static void sortByArtist(SortedRecordings[] recordings) {
        for (int i = 0; i < recordings.length - 1; i++) {
            for (int j = i + 1; j < recordings.length; j++) {
                if (recordings[i].getArtist().compareTo(recordings[j].getArtist()) > 0) {
                    SortedRecordings temp = recordings[i];
                    recordings[i] = recordings[j];
                    recordings[j] = temp;
                }
            }
        }
    }

    // Sorting method for playing time
    public static void sortByPlayingTime(SortedRecordings[] recordings) {
        for (int i = 0; i < recordings.length - 1; i++) {
            for (int j = i + 1; j < recordings.length; j++) {
                if (recordings[i].getPlayingTimeSeconds() > recordings[j].getPlayingTimeSeconds()) {
                    SortedRecordings temp = recordings[i];
                    recordings[i] = recordings[j];
                    recordings[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedRecordings[] recordings = new SortedRecordings[7];

        // Prompt the user to enter data for seven recordings
        for (int i = 0; i < 7; i++) {
            System.out.println("Recording " + (i + 1) + ":");
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter artist: ");
            String artist = scanner.nextLine();
            System.out.print("Enter playing time (seconds): ");
            int playingTime = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            recordings[i] = new SortedRecordings(title, artist, playingTime);
        }

        System.out.println("Sort by: ");
        System.out.println("1. Song Title");
        System.out.println("2. Artist");
        System.out.println("3. Playing Time");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sortByTitle(recordings);
                break;
            case 2:
                sortByArtist(recordings);
                break;
            case 3:
                sortByPlayingTime(recordings);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        System.out.println("Sorted Recordings:");
        for (SortedRecordings recording : recordings) {
            System.out.println(recording);
        }

        scanner.close();
    }
}

