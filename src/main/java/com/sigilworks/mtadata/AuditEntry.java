package com.sigilworks.mtadata;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * User: tj
 * Date: 12/30/17
 * Time: 9:29 PM
 */
public class AuditEntry {
        private final String controlArea;
        private final String remoteUnit;
        private final String scp;

        private final StationInfo station;
        private final LocalDate date;
        private final LocalTime time;
        private final AuditType auditType;
        private final int entryCount;
        private final int exitCount;

        public AuditEntry(String controlArea, String remoteUnit, String scp, String station, String lineNames, String division,
                          String formattedDate, String formattedTime, String auditDesc, String entries, String exits) {
            this.controlArea = controlArea;
            this.remoteUnit = remoteUnit;
            this.scp = scp;

            this.station = new StationInfo(station, parseLineNames(lineNames), Division.valueOf(division));

            this.date = parseDate(formattedDate);
            this.time = parseTime(formattedTime);
            this.auditType = AuditType.fromDescription(auditDesc);
            this.entryCount = Integer.parseInt(entries);
            this.exitCount = Integer.parseInt(exits);
        }

        private LocalDate parseDate(String formattedDate) {
            String[] dateParts = formattedDate.split("/");
            int month = Integer.parseInt(dateParts[0]);
            int day = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);
            return LocalDate.of(year, month, day);
        }

        private LocalTime parseTime(String formattedTime) {
            String[] timeParts = formattedTime.split(":");
            int hour = Integer.parseInt(timeParts[0]);
            int min = Integer.parseInt(timeParts[1]);
            return LocalTime.of(hour, min);
        }

        private List<SubwayLine> parseLineNames(String lineString) {
            final List<SubwayLine> lineNames = new ArrayList<>();
            final String[] lines = lineString.split("");
            for (String line : lines) {
                lineNames.add(SubwayLine.fromTag(line));
            }
            return lineNames;
        }

        public StationInfo getStation() {
            return station;
        }

        public LocalDate getDate() {
            return date;
        }

        public LocalTime getTime() {
            return time;
        }

        public AuditType getAuditType() {
            return auditType;
        }

        public int getEntryCount() {
            return entryCount;
        }

        public int getExitCount() {
            return exitCount;
        }
}


