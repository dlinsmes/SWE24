//File > Project Structure > Project Settings > Libraries > + > From Maven > com.opencsv
//csv file goes in project folder (not src)

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class CSVImporter {

    public static ArrayList<String []> importData(String filename) {

        //will attempt to run code in the try section
        //-if anything crashes/breaks, the catch section runs instead
        try {
            FileReader fr = new FileReader(filename);
            CSVReader reader = new CSVReader(fr);

            //make an arraylist from the csv file
            //each element of the arraylist is a row from the spreadsheet
            //each row is a string array
            //each element of the string array is a cell from the row
            ArrayList<String[]> data = new ArrayList(reader.readAll());
            return data;
        }
        catch (Exception e) {
            //print info about the error that occurred
            e.printStackTrace();
        }
        return null;
    }
}