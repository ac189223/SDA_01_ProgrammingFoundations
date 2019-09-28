package PF03.BlueJ._13_MusicPlayer;

public class Track {
    private String artist;
    private String title;
    private String filename;

    public static final String[] FIELDS = {"Artist", "Title", "Filename",};

    public Track(String artist, String title, String filename) { setDetails(artist, title, filename); }

    public Track(String filename) { setDetails("unknown", "unknown", filename); }

    public String getArtist() { return artist; }
    public String getTitle() { return title; }
    public String getFilename() { return filename; }

    public String getField(String field) {
        if (field.equals("Artist"))
            return artist;
        else if (field.equals("Title"))
            return title;
        else if (field.equals("Filename"))
            return filename;
        else
            throw new IllegalArgumentException("Unknown field name: " + field);
    }

    public String[] getFields() {
        String[] fields = new String[FIELDS.length];
        for(int i = 0; i < FIELDS.length; i++)
            fields[i] = getField(FIELDS[i]);
        return fields;
    }

    public String getDetails() { return artist + ": " + title + "  (file: " + filename + ")"; }

    private void setDetails(String artist, String title, String filename) {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
    }
}
