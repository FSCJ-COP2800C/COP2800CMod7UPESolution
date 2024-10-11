// BoxFactory.java
// D. Singletary 
// 10/2/22
// Class which represents a factory containing boxes of various colors

package edu.fscj.cop2800c.container;

import java.util.Arrays;
import edu.fscj.cop2800c.table.TableFormatter;

public class BoxFactory implements TableFormatter {

    public static final int MAX_BOXES = 20;
    
    // array (instance variable) of boxes
    private Box[] boxes;
    
    // default constructor
    public BoxFactory() { }
    
    // overloaded constructor - create array with boxCount Box elements
    public BoxFactory(int boxCount, Box[] boxes) {
        this.boxes = new Box[boxCount];
        for (int count = 0; count < boxCount; count++) {
            this.boxes[count] = boxes[count];
        }
    }
        
    // toString
    @Override
    public String toString() {
        // header
        String retString = "Box Factory Contents:\n"; // start here
   
        for (int boxCount = 0; boxCount < this.boxes.length; boxCount++)
            retString += this.boxes[boxCount] + "\n";

        return retString;
    }

    // return contents in tabular format
    public String table() {
        final String DATAFORMAT = "%-12s%-12s%-12s%-12s%-12s%-12s\n";
        // header
        String retString = "Box Factory Contents:\n"; // start here
        // data headers
        retString += String.format(DATAFORMAT, "ID", "SIZE", "COLOR", 
                                                "LENGTH", "WIDTH", "HEIGHT");
        // data
        for (int boxCount = 0; boxCount < this.boxes.length; boxCount++) {
            String boxStr = String.format(DATAFORMAT,
                this.boxes[boxCount].getId(),
                this.boxes[boxCount].getSize().name(),
                this.boxes[boxCount].getColor().name(),
                this.boxes[boxCount].getLength(),
                this.boxes[boxCount].getWidth(),
                this.boxes[boxCount].getHeight());
            retString += boxStr;
        }

        return retString;
    } 
    
    public static void main(String[] args) {

        String[][] inputArray = BoxReader.read(MAX_BOXES);

        // create an empty array with the maximum specified elements
        Box[] boxArray = new Box[MAX_BOXES];
        int boxCount = 0;  // may be partially filled
        
        // fill the array with up to the number of elements that were read
        for (    int rows = 1;  // skip the header! 
                 rows < MAX_BOXES && inputArray[rows][0] != null; 
                 rows++) {
            
            Integer newBoxId = Integer.parseInt(inputArray[rows][0]);
            Size newBoxSize = Size.parseSize(inputArray[rows][1]);
            Color newBoxColor = Color.parseColor(inputArray[rows][2]); 
            Double newBoxLength = Double.parseDouble(inputArray[rows][3]);
            Double newBoxWidth = Double.parseDouble(inputArray[rows][4]);
            Double newBoxHeight = Double.parseDouble(inputArray[rows][5]);

            boxArray[boxCount++] = new Box(newBoxId, newBoxSize, newBoxColor, 
                                   newBoxLength, newBoxWidth, newBoxHeight);
        }
        
        // create the Box Factory's array with only the populated elements
        BoxFactory boxFact = new BoxFactory(boxCount, boxArray);
        
        Box box1 = new Box(100, Size.LARGE, Color.YELLOW, 10.0, 10.0, 10.0);
        Box box2 = new Box(100, Size.LARGE, Color.YELLOW, 10.0, 10.0, 10.0);
        System.out.println("box1 and box2 equal? " + box1.equals(box2));
        
        System.out.println(boxFact);
        
        // toString will display unformatted data, don't use it here
        // Instead, call the table method to format in a nice tabular form
        System.out.println(boxFact.table());
    }
}