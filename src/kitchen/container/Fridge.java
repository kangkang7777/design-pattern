package container;

import java.util.*;

/**
 * 
 */
public class Fridge extends Container {

    /**
     * Default constructor
     */
    public Fridge() {
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * 
     */
    private static Fridge instance;

    /**
     * @return instance
     */
    public static synchronized Fridge getInstance() {
        if (instance == null) {
            instance = new Cabinet();
        }
        return instance;
    }

    /**
     * @return
     */
    public String getName()
    {
        return("冰箱");
    }

}