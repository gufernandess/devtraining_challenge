import java.io.IOException;
import java.util.List;

public class ProcessStudent {

    /**
     * Calculate the student's final grade based on the three partials
     * @param p1 First partial grade
     * @param p2 Second partial grade
     * @param p3 Third partial grade
     *
     * The division by 30 is to convert the grade to a scale of 0 to 10
     *
     * @return The student's final grade
     */

    public static float calculateMedia(float p1, float p2, float p3) {
        return ((p1 + p2 + p3) / 30);
    }

    /**
     * Calculate the student's situation based on the final grade
     * @param absences The student's absences
     * @param media The student's final grade
     *
     * @return The student's situation
     */

    public static String calculateSituation(int absences, float media) {
        if(absences > 15) {
            return "Reprovado por Falta";
        } else {
            if (media < 5) {
                return "Reprovado por Nota";
            } else if (media < 7) {
                return "Exame Final";
            } else {
                return "Aprovado";
            }
        }
    }

    /**
     * Calculate the student's grade required to be approved
     * @param absences The student's absences
     * @param media The student's media
     *
     * @return The student's grade required to be approved
     */

    public static float calculateGradeRequired(int absences, float media) {
        return ((media >= 5 && media < 7) && absences <= 15) ? (float) Math.ceil(10 - media) : 0;
    }

    private static int parseInt(Object obj) {
        return Integer.parseInt((String) obj);
    }

    private static float parseFloat(Object obj) {
        return Float.parseFloat((String) obj);
    }

    /**
     * This method builds the range to be written in the Google Sheets based on the student's id.
     * I think it´s interesting find the row based on the student's id, so I can write the data
     * in the correct row.
     * */

    private static String buildRange(int id) {
        return String.format("software_engineer!G%d:H%d", id + 3, id + 3);
    }

    /*
     * Check all the student´s data and write the situation and the grade required to be approved in the Google Sheets
     *
     * @param row The student's data
     *
     * The row is a list of objects, so I need to convert the objects to the correct type to process the data
     *
    * */

    public static void checkStudent(List<Object> row) {
        try {
            int id = parseInt(row.get(0));

            int absences = parseInt(row.get(2));

            float p1 = parseFloat(row.get(3));
            float p2 = parseFloat(row.get(4));
            float p3 = parseFloat(row.get(5));

            float media = calculateMedia(p1, p2, p3);

            String situation = calculateSituation(absences, media);
            float gradeRequired = calculateGradeRequired(absences, media);

            List<Object> data = List.of(situation, gradeRequired);

            String range = buildRange(id);

            WriteSheet.write(data, range, "1R_Mns-PFo3uuLZVeYKrndmPPL3QOw-yKNMZ4AQW20l0");

        } catch (NumberFormatException e) {
            System.out.println("Error processing row: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
