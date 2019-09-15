package DesignPattern.ObserverPattern;

/**
 * @ClassName VideoFans
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 20:29
 **/
public class VideoFans implements Observer{

    private String name;

    public VideoFans(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        System.out.println(this.name + ", new videos are available! ");
        // print video list
        System.out.println(subject);
    }
}
