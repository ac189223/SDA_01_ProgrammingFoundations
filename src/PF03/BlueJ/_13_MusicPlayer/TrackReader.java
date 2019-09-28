package PF03.BlueJ._13_MusicPlayer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class TrackReader {

    public TrackReader() { }

    public ArrayList<Track> readTracks(String folder, final String suffix) {
        File audioFolder = new File(folder);
        ArrayList<Track> tracks = new ArrayList<>();
        File[] audioFiles = audioFolder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(suffix);
            }
        });
        for (File file : audioFiles) {
            Track trackDetails = decodeDetails(file);
            tracks.add(trackDetails);
        }
        return tracks;
    }

    private Track decodeDetails(File file) {
        String artist = "unknown";
        String title = "unknown";
        String filename = file.getPath();
        String details = file.getName();
        String[] parts = details.split("-");

        if (parts.length == 2) {
            artist = parts[0];
            String titlePart = parts[1];
            parts = titlePart.split("\\.");
            if (parts.length >= 1)
                title = parts[0];
            else
                title = titlePart;
        }
        return new Track(artist, title, filename);
    }
}
