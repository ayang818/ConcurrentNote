package DesignPattern.ObserverPattern;

/**
 * @ClassName Subject
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 20:18
 **/
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
