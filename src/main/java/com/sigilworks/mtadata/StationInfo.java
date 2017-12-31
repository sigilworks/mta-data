package com.sigilworks.mtadata;

import java.util.Objects;
import java.util.Set;

/**
 * User: tj
 * Date: 12/30/17
 * Time: 7:47 PM
 */
public class StationInfo {
    private final String name;
    private final Set<SubwayLine> lines;
    private final Division division;

    public StationInfo(String name, Set<SubwayLine> lines, Division division) {
        this.name = name;
        this.lines = lines;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public Set<SubwayLine> getLines() {
        return lines;
    }

    public Division getDivision() {
        return division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StationInfo)) return false;
        StationInfo that = (StationInfo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(lines, that.lines) &&
                division == that.division;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lines, division);
    }
}
