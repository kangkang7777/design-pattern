package kitchen.time;

import java.util.*;

/**
 * 
 */
public class Time {

    /**
     *
     */
    private Time() {
    }

    /**
     * 
     */
    private static Time instance;

    /**
     * 
     */
    private ArrayList<TimeObserver> timeObservers = new ArrayList<>();


    /**
     * @return
     */
    public static synchronized Time getInstance() {
        if (instance == null) instance = new Time();

        return instance;
    }

    /**
     * 
     */
    public void update(int ticks) {
        while(ticks>0)
        {
            for (TimeObserver o : timeObservers)  o.update();
            ticks--;
        }

    }

    /**
     * @param o
     */
    public void addTimeObserver(TimeObserver o) {
        timeObservers.add(o);
    }

    /**
     * @param o
     */
    public void removeTimeObserver(TimeObserver o) {
        timeObservers.remove(o);
    }

}