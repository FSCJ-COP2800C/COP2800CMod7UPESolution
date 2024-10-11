// Color.java
// D. Singletary 
// 9/24/22
// Enum which represents colors

package edu.fscj.cop2800c.container;

// enumerated type to represent color values
public enum Color {
    NO_COLOR, RED, GREEN, BLUE, YELLOW;
    
    public static Color parseColor(String colorStr) {
        Color retVal = NO_COLOR;
        switch (colorStr.toLowerCase()) { // convert to lower case to compare
            case "red":
                retVal = RED;
                break;
            case "blue":
                retVal = BLUE;
                break;
            case "green":
                retVal = GREEN;
                break;
            case "yellow":
                retVal = YELLOW;
                break;
        }
        return retVal;
    }
}