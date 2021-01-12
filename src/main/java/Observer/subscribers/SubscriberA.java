package Observer.subscribers;

public class SubscriberA implements Subscriber {
    @Override
    public void update() {

    }

    @Override
    public void update(String info) {
        System.out.println("Oh wonderful, I received notification, SubscriberA");
    }
}
