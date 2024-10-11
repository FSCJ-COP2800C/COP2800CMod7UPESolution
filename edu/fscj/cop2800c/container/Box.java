// Box.java
// D. Singletary 
// 10/2/22
// Class which represents a box

package edu.fscj.cop2800c.container;

// class which represents a box
public class Box extends Container {

    // dimensions in inches
    private Double length, width, height;

    // default constructor
    public Box() { 
        // call to super() is implicit here
        this.length = this.width = this.height = 0.0;
    }
    
    // overloaded constructor which accepts id, color, and size 
    // parameters for the superclass in addition to box dimensions
    public Box(Integer id, Size size, Color color,
               Double length, Double width, Double height) {
        super(id, size, color);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // dimension accessors
    public Double getLength() { 
        return this.length; 
    }
    
    public Double getWidth() { 
        return this.width; 
    }

    public Double getHeight() { 
        return this.height; 
    }
    
    // no dimension mutators, they are read-only 
    
    // toString
    @Override
    public String toString() {
        String returnStr = super.toString() + 
                           "(" + this.getLength() + "," + 
                                 this.getWidth() + "," + 
                                 this.getHeight() + ")";
        return returnStr;
    }
    
    // check if boxes are equal
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        
        if (o instanceof Box) {
            Box b = (Box)o;

            if ((super.equals(b) == true) &&
                    this.getLength().equals(b.getLength()) &&
                    this.getWidth().equals(b.getWidth()) &&
                    this.getHeight().equals(b.getHeight()))
                result = true;
        }
            
        return result;
    }   
}