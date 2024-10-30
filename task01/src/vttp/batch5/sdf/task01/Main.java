package vttp.batch5.sdf.task01;

// Use this class as the entry point of your program

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import vttp.batch5.sdf.task01.models.*;
import vttp.batch5.sdf.task01.models.toBikeEntry;

public class Main {

    // BikeEntry be = new BikeEntry();
    public static final String[] position = { "highest", "second highest", "third highest", "fourth highest",
            "fifth highest" };
    static BikeEntry be = new BikeEntry();

    public static void main(String[] args) {

        String file = args[0];

        List<String> arr = new ArrayList<>();

        int count = 0;

        try {

            // String file = "SDF Test\\vttp_b5_assessment_template\\task01\\day.csv";

            if (file != null) {
                System.out.println("file received");
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "x";
            while (line != null) {

                line = br.readLine();
                String[] values = line.split("");

                // arr.add(values.toString());
                BikeEntry.toBikeEntry(values);
                System.out.println(values);

            }

            // Printing
            for (int i = 0; i < 5; i++) {

            }

            br.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
