import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Nikhil Upadhyay.
 */
public class CSVReaderWithManualHeader {
    private static final String SAMPLE_CSV_FILE_PATH = "./java-csv-file-handling-with-apache-commons-csv/users.csv";

    public static void main(String[] args) throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("Name", "Type", "Date_Added", "Country")
                    .withIgnoreHeaderCase()
                    .withTrim());
        ) {

            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by the names assigned to each column

                String name = csvRecord.get("Name");
                String type = csvRecord.get("Type");
                String date_added = csvRecord.get("Date_Added");
                String country = csvRecord.get("Country");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + name);
                System.out.println("Type : " + type);
                System.out.println("Date_added : " + date_added);
                System.out.println("Country : " + country);
                System.out.println("---------------\n\n");
            }
        }
    }
}
