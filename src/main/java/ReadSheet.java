import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadSheet {

    /**
     * Read data from the Google Sheet
     *
     * @return List of List of Objects
     *
     * @throws IOException
     * @throws GeneralSecurityException
     */

    public static List<List<Object>> read() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1R_Mns-PFo3uuLZVeYKrndmPPL3QOw-yKNMZ4AQW20l0";
        final String range = "software_engineer!A4:F";
        Sheets service =
                new Sheets.Builder(HTTP_TRANSPORT, SheetsQuickstart.JSON_FACTORY, SheetsQuickstart.getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(SheetsQuickstart.APPLICATION_NAME)
                        .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();

        return response.getValues();
    }
}
