package PF03.BlueJ.AnimalMonitoring;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SightingReader {
    private static final int NUMBER_OF_FIELDS_EXPECTED = 5;
    private static final int SPOTTER_ID = 0,
                             SPOTTED_ANIMAL = 1,
                             COUNT = 2,
                             AREA = 3,
                             PERIOD = 4;

    public SightingReader() { }

    // read from file
    public ArrayList<Sighting> getSightings(String filename)
    {
        // Create a Sighting from a CSV input line.
        Function<String, Sighting> createSighting =
                record -> {
                    String[] parts = record.split(",");
                    if(parts.length == NUMBER_OF_FIELDS_EXPECTED) {
                        try {
                            int spotter = Integer.parseInt(parts[SPOTTER_ID].trim());
                            String animal = parts[SPOTTED_ANIMAL].trim();
                            int count = Integer.parseInt(parts[COUNT].trim());
                            int area = Integer.parseInt(parts[AREA].trim());
                            int period = Integer.parseInt(parts[PERIOD].trim());
                            return new Sighting(animal, spotter, count, area, period);
                        }
                        catch(NumberFormatException e) {
                            System.out.println("Sighting record has a malformed integer: " + record);
                            return null;
                        }
                    }
                    else {
                        System.out.println("Sighting record has the wrong number of fields: " + record);
                        return null;
                    }
                };
        ArrayList<Sighting> sightings;
        try {
            sightings = Files.lines(Paths.get(filename))
                    .filter(record -> record.length() > 0 && record.charAt(0) != '#')
                    .map(createSighting)
                    .filter(sighting -> sighting != null)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        catch(IOException e) {
            System.out.println("Unable to open " + filename);
            sightings = new ArrayList<>();
        }
        return sightings;
    }

}