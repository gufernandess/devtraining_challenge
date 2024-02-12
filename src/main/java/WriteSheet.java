import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WriteSheet {

    /**
     * Writes data to a specific range in a Google Sheet
     *
     * @param data List of data to write
     * @param range Range to write to
     * @param spreadsheetID ID of the spreadsheet to write to
     *
     * @throws IOException
     */
    public static void write(List<Object> data, String range, String spreadsheetID) throws IOException {
        List<List<Object>> values = Collections.singletonList(data);

        ValueRange body = new ValueRange().setValues(values);
        UpdateValuesResponse result = SheetsQuickstart.spreadsheets.values().update(spreadsheetID, range, body)
                .setValueInputOption("RAW").execute();

        System.out.printf("%d cells updated. ", result.getUpdatedCells());
        System.out.println("Data written to range: " + range + "\n");
    }
}
