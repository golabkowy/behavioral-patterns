package Observer.subscribers;

public interface Subscriber {
    public void update();

    public void update(String info);
}
