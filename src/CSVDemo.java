import java.util.ArrayList;

public class CSVDemo {
    public static void main(String [] args) {

        ArrayList<String []> data = CSVImporter.importData("Employee Data.csv");
        for (String [] row: data) {
            for (String cell : row)
                System.out.print(cell + "\t");
            System.out.println();
        }
    }
}
