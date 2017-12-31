package com.sigilworks.mtadata;

/**
 * User: tj
 * Date: 12/30/17
 * Time: 7:48 PM
 */
public enum SubwayLine {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    J("J"),
    L("L"),
    M("M"),
    N("N"),
    Q("Q"),
    R("R"),
    W("W"),
    Z("Z"),

    S("S");

    private String tag;
    SubwayLine(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public static SubwayLine fromTag(String tag) {
        SubwayLine found = null;
        for (SubwayLine line : SubwayLine.values()) {
            if (line.getTag().equalsIgnoreCase(tag)) {
                found = line;
            }
        }
        return found;
    }
}
