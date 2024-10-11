// BoxReader.java
// D. Singletary
// 10/8/22
// Reads box information from a CSV file

// D. Singletary
// 10/16/22
// added new columns, increased data dimensions, renamed constant

package edu.fscj.cop2800c.container;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BoxReader {

    public static final int DATA_DIMENSIONS = 6;

    // read data from a CSV file, return a 2D array
    public static String[][] read(final int MAX_BOXES) {
          final String FILENAME = "boxes.csv";
          String[][] boxes = null;

          // create a file instance
          File file = new File(FILENAME);
          try (Scanner input = new Scanner(file);) {
               boxes = new String[MAX_BOXES][DATA_DIMENSIONS];
               for (int rows = 0; rows < MAX_BOXES; rows++)
                   for (int cols = 0; cols < DATA_DIMENSIONS; cols++)
                       boxes[rows][cols] = null;

                // read data from file
                int rowCount = 0;
                // constants for the columns
                final int BOX_ID_COL = 0;
                final int BOX_SIZE_COL = 1;
                final int BOX_COLOR_COL = 2;
                final int BOX_COLOR_LENGTH = 3;
                final int BOX_COLOR_WIDTH = 4;
                final int BOX_COLOR_HEIGHT = 5;

                // loop while there is more input               
                while (input.hasNext()) {
                      String line = input.nextLine();
                      String[] sp = line.split(",",DATA_DIMENSIONS);
                      boxes[rowCount][BOX_ID_COL] = sp[BOX_ID_COL];
                      boxes[rowCount][BOX_SIZE_COL] = sp[BOX_SIZE_COL];
                      boxes[rowCount][BOX_COLOR_COL] = sp[BOX_COLOR_COL];
                      boxes[rowCount][BOX_COLOR_LENGTH] = sp[BOX_COLOR_LENGTH];
                      boxes[rowCount][BOX_COLOR_WIDTH] = sp[BOX_COLOR_WIDTH];
                      boxes[rowCount][BOX_COLOR_HEIGHT] = sp[BOX_COLOR_HEIGHT];
                      // increment rowCount to get ready for the next row
                      rowCount++;
                }
          } catch (IOException ex) {
                System.err.println("Exception! " + ex);
          } 
                
          return(boxes);
     }
}