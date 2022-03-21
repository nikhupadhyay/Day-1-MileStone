import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Nikhil Upadhyay.
 */
public class BasicCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "./java-csv-file-handling-with-apache-commons-csv/users.csv";

    public static void main(String[] args) throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index

                String name = csvRecord.get(0);
                String type = csvRecord.get(1);
                String date_added = csvRecord.get(2);
                String country = csvRecord.get(3);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + name);
                System.out.println("Type : " + type);
                System.out.println("Date_Added : " + date_added);
                System.out.println("Country : " + country);
                System.out.println("---------------\n\n");
            }
        }
    }
}
