package behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dark on 2016. 10. 29..
 */
public class Publisher {

    private List<Subscriber> subscribers = new ArrayList<>();

    public void add(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void fire(String event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receive(event);
        }
    }

}
