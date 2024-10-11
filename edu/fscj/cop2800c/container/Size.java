// Size.java
// D. Singletary 
// 10/6/22
// Enum which represents container sizes

package edu.fscj.cop2800c.container;

// enumerated type to represent container sizes
public enum Size {
    NO_SIZE, SMALL, MEDIUM, LARGE, JUMBO;
    
    public static Size parseSize(String sizeStr) {
        Size retVal = NO_SIZE;
        switch (sizeStr.toLowerCase()) { // convert to lower case to compare
            case "small":
                retVal = SMALL;
                break;
            case "medium":
                retVal = MEDIUM;
                break;
            case "large":
                retVal = LARGE;
                break;
            case "jumbo":
                retVal = JUMBO;
                break;                
        }
        return retVal;
    }       
}