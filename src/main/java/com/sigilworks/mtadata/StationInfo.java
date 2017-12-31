package com.sigilworks.mtadata;

import java.util.List;

/**
 * User: tj
 * Date: 12/30/17
 * Time: 7:47 PM
 */
public class StationInfo {
    private final String name;
    private final List<SubwayLine> lines;
    private final Division division;

    public StationInfo(String name, List<SubwayLine> lines, Division division) {
        this.name = name;
        this.lines = lines;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public List<SubwayLine> getLines() {
        return lines;
    }

    public Division getDivision() {
        return division;
    }
}
