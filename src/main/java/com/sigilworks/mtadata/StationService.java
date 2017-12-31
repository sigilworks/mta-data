package com.sigilworks.mtadata;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * User: tj
 * Date: 12/31/17
 * Time: 7:35 AM
 */
public class StationService {
    private static final Set<StationInfo> CACHE = new HashSet<>();

    public static StationInfo getStation(String name, Set<SubwayLine> lines, Division division) {
        final Optional<StationInfo> cached = CACHE.stream()
                .filter(station -> station.getName().equalsIgnoreCase(name)
                        && station.getLines().containsAll(lines)
                        && station.getDivision().equals(division))
                .findFirst();

        return cached.orElseGet(() -> {
            final StationInfo station = new StationInfo(name, lines, division);
            CACHE.add(station);
            return station;
        });
    }

    public static Set<StationInfo> getStations() {
        return CACHE;
    }

    public static Set<StationInfo> getStationsByName(String name) {
        // TODO: impl. me!
        return null;
    }

    public static Set<StationInfo> getStationsByLine(SubwayLine line) {
        // TODO: impl. me!
        return null;
    }
}