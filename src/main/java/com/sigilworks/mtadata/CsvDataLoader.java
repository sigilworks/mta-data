package com.sigilworks.mtadata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * User: tj
 * Date: 12/30/17
 * Time: 7:46 PM
 */
public class CsvDataLoader {
    public static final File RAW_TURNSTILE_DATA = new File("src/main/resources/turnstile_data_20171230.csv");

    public static void main(String[] args) throws Exception {
        log("Loading data from %s...", RAW_TURNSTILE_DATA.getName());
        final long startTime = System.currentTimeMillis();

        // process file into individual rows
        final List<String> rows = getLines(RAW_TURNSTILE_DATA);
        final List<AuditEntry> entries = getAuditEntries(rows);

        log("Entries found: %d", entries.size());
        log("Data loaded in %d ms.", (System.currentTimeMillis() - startTime));

        log("StationService cache ready.");
    }

    private static List<String> getLines(File file) throws IOException {
        final List<String> lines = new ArrayList<>();
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int lineCount = 0;

        while ((line = reader.readLine()) != null) {
            // ignore header row
            if (lineCount > 0) {
                lines.add(line);
            }
            lineCount++;
        }

        return lines;
    }

    private static List<AuditEntry> getAuditEntries(List<String> rows) {
        // parse fields in each row
        final List<AuditEntry> entries = new ArrayList<>(rows.size());

        for (String row : rows) {
            final String[] fields = row.split(",");
            final AuditEntry entry = new AuditEntry(
                    fields[0],
                    fields[1],
                    fields[2],
                    fields[3],
                    fields[4],
                    fields[5],
                    fields[6],
                    fields[7],
                    fields[8],
                    fields[9],
                    fields[10]
            );
            entries.add(entry);
        }
        return entries;
    }

    private static void log(String message, Object... args) {
        System.out.println("[" + LocalDateTime.now() + "] " + String.format(message, args));
    }
}
