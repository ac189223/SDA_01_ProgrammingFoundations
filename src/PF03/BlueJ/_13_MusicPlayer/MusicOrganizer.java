package PF03.BlueJ._13_MusicPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MusicOrganizer
{
    private ArrayList<Track> tracks;
    private TrackReader reader;

    public MusicOrganizer(String folderName) {
        tracks = new ArrayList<>();
        reader = new TrackReader();
        readLibrary(folderName);
    }

    public void addFile(String filename) { tracks.add(new Track(filename)); }

    public void addTrack(Track track) { tracks.add(track); }

    public Track getTrack(int index) {
        if(indexValid(index))
            return tracks.get(index);
        else
            return null;
    }

    public int getNumberOfTracks() { return tracks.size(); }

    public List<Track> getAllTracks() { return new ArrayList<>(tracks); }

    public List<Track> sortByArtist() { return sortByField("Artist"); }

    public List<Track> sortByTitle() { return sortByField("Field"); }

    private List<Track> sortBy(Comparator<Track> comparator) {
        List<Track> copy = getAllTracks();
        Collections.sort(copy, comparator);
        return copy;
    }

    public List<Track> sortByField(final String field) {
        return sortBy(new Comparator<Track>() {
            public int compare(Track t1, Track t2) {
                return t1.getField(field).compareTo(t2.getField(field));
            }
        });
    }

    public void removeTrack(int index) {
        if(indexValid(index))
            tracks.remove(index);
    }

    private boolean indexValid(int index) {
        boolean valid;
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        } else if (index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public void readLibrary(String folderName) {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");
        for(Track track : tempTracks)
            addTrack(track);
    }
}
