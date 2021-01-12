package Observer;

import Observer.subscribers.Subscriber;

import java.util.LinkedList;

public class Publisher {

    private final LinkedList<Subscriber> subscribersList = new LinkedList<>();

    public Publisher() {
        System.out.println("Publisher Ready");
        this.simulateApp();
    }

    public void subscribe(Subscriber subscriber) {
        this.subscribersList.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        this.subscribersList.remove(subscriber);
    }

    public void notifySubscribers() {
        this.subscribersList.forEach(sub -> {
            sub.update("new edition available!");
        });
    }

    // It can be also some part of application, for example UI. Users can be notified after some changes, Publisher class is proxy only, it keeps info about subscribers / listeners and sends events when its is required.
    private void simulateApp() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Notification sent to all subscribers");
                    this.notifySubscribers();
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        );

        t.start();
    }

}
