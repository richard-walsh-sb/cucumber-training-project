package com.cucumber.training;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shouty {
    private static final int MESSAGE_RANGE = 1000;
    private Map<String, Coordinate> locations = new HashMap<>();
    private Map<String, List<String>> shouts = new HashMap<>();

    public void setLocation(String person, Coordinate location) {
        locations.put(person, location);
    }

    public void shout(String shouter, String shout) {
        if (!shouts.containsKey(shouter)) {
            List<String> personsShouts = new ArrayList<>();
            shouts.put(shouter, personsShouts);
        }

        shouts.get(shouter).add(shout);
    }

    public Map<String, List<String>> getShoutsHeardBy(String listener) {
        HashMap<String, List<String>> shoutsHeard = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : shouts.entrySet()) {
            String shouter = entry.getKey();
            if (shouter.equals(listener)) {
                continue;
            }
            List<String> personsShouts = entry.getValue();
            int distance = locations.get(listener).distanceFrom(locations.get(shouter));
            if (distance < MESSAGE_RANGE)
                shoutsHeard.put(shouter, personsShouts);
        }

        return shoutsHeard;
    }
}