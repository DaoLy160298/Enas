package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVDataReader {
	public List<String[]> readCSV(String csvFilePath) throws CsvValidationException {
        List<String[]> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                data.add(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
