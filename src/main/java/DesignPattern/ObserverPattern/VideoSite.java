package DesignPattern.ObserverPattern;

import java.util.ArrayList;

/**
 * @ClassName VideoSite
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 20:21
 **/
public class VideoSite implements Subject {
    private ArrayList<Observer> userList;
    private ArrayList<String> videos;

    public VideoSite() {
        userList = new ArrayList<>();
        videos = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : userList) {
            observer.update(this);
        }
    }

    public void addVideos(String video) {
        this.videos.add(video);
        notifyObserver();
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

    public String toString(){
        return videos.toString();
    }
}
