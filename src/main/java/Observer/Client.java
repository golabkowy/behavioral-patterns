package Observer;

import Observer.subscribers.SubscriberA;
import Observer.subscribers.SubscriberB;
import Observer.subscribers.SubscriberC;

public class Client {
    // client should set up publisher and subscribers
    public static void main(String[] args) {

        Publisher publisher = new Publisher();

        SubscriberA subscriberA = new SubscriberA();
        SubscriberB subscriberB = new SubscriberB();
        SubscriberC subscriberC = new SubscriberC();


        publisher.subscribe(subscriberA);
        publisher.subscribe(subscriberB);
        publisher.subscribe(subscriberC);

        try {
            Thread.sleep(20000L);
            System.out.println("Some of the users have opted out of subscriptions | after 4 subscriptions (check hardcoded time in Publisher class) ");
            publisher.unsubscribe(subscriberB);
            publisher.unsubscribe(subscriberC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
