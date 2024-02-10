import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class SheetsQuickstart {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = SheetsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    /**
     * Check if the student is reproved by absence
     * @param absences The student's absences
     *
     * @return If the student is reproved by absence
     */

    public static String isReprovedByAbsence(int absences) {
        if(absences > 15) {
            return "Reprovado por Falta";
        }

        return "";
    }

    /**
     * Calculate the student's final grade based on the three partials
     * @param p1 First partial grade
     * @param p2 Second partial grade
     * @param p3 Third partial grade
     *
     * @return The student's final grade
     */

    public static float calculateMedia(float p1, float p2, float p3) {
        return ((p1 + p2 + p3) / 30);
    }

    /**
     * Calculate the student's situation based on the final grade
     * @param media The student's final grade
     *
     * @return The student's situation
     */

    public static String calculateSituation(float media) {
        if (media < 5) {
            return "Reprovado por Nota";
        } else if (media < 7) {
            return "Exame Final";
        } else {
            return "Aprovado";
        }
    }

    /**
     * Calculate the student's final grade based on the media
     * @param media The student's media
     *
     * @return The student's final grade
     */

    public static String calculateFinalGrade(float media) {
        return (media >= 5 && media < 7) ? "<= " + (int) Math.ceil(10 - media) : "0";
    }

    /**
     * Print students's data in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1R_Mns-PFo3uuLZVeYKrndmPPL3QOw-yKNMZ4AQW20l0/edit
     */
    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1R_Mns-PFo3uuLZVeYKrndmPPL3QOw-yKNMZ4AQW20l0";
        final String range = "software_engineer!A4:H";
        Sheets service =
                new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                int absences = Integer.parseInt((String) row.get(2));

                String absence = isReprovedByAbsence(absences);

                if (!absence.isEmpty()) {
                    break;
                }

                float p1 = Float.parseFloat((String) row.get(3));
                float p2 = Float.parseFloat((String) row.get(4));
                float p3 = Float.parseFloat((String) row.get(5));

                float media = calculateMedia(p1, p2, p3);

                String situation = calculateSituation(media);
                String finalGrade = calculateFinalGrade(media);
                System.out.printf("%d faltas, %.2f de média, %s, %s\n", absences, media, situation, finalGrade);
            }
        }
    }
}