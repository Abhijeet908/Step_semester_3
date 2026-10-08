package encapsulation.assigment_problems;

import java.util.Arrays;

/**
 * Assignment Problem 2: The Playlist.
 * getSongs() returns a copy, protecting the private internal array.
 */
public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        if (maxSongs < 0) {
            throw new IllegalArgumentException("Maximum songs cannot be negative");
        }
        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (song != null && songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}
