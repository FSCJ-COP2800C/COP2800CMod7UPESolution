// Container.java
// D. Singletary 
// 10/2/22
// Class which represents a container

package edu.fscj.cop2800c.container;

// class which represents a Container
public class Container {

    private Integer id = 0;
    private Size size = Size.NO_SIZE;
    private Color color = Color.NO_COLOR;

    // default constructor
    public Container() { }
    
    // overloaded constructor which accepts id, color, and size parameter
    public Container(Integer id, Size size, Color color) {
        this.id = id;
        this.size = size;
        this.color = color; 
    }

    // id accessor
    public Integer getId() { 
        return this.id; 
    }
    
    // no mutator for id, it is read-only  
      
    // color accessor
    public Color getColor() { 
        return this.color; 
    }
    
    // color mutator
    public void setColor(Color color) { 
        this.color = color; 
    }
    
    // size accessor
    public Size getSize() { 
        return this.size; 
    }
    
    // no mutator for size, it is read-only 
    
    // toString
    @Override
    public String toString() {
        String returnStr = this.getId() + "," + 
                           this.getSize().name() + "," + 
                           this.getColor().name();
        return returnStr;
    }
    
    // check if containers are equal
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        
        if (o instanceof Container) {
            Container c = (Container)o;
            
            if     (c.getId().equals(this.getId()) &&  // wrapper uses .equals
                    c.getColor() == this.getColor() && // == works for enums
                    c.getSize() == this.getSize())
                result = true;
        }
            
        return result;
    }   
}