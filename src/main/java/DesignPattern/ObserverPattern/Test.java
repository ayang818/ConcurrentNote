package DesignPattern.ObserverPattern;

/**
 * @ClassName Test
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 20:32
 **/
public class Test {
    public static void main(String[] args) {
        VideoSite vs = new VideoSite();
        vs.registerObserver(new VideoFans("LiLei"));
        vs.registerObserver(new VideoFans("HanMeimei"));
        vs.registerObserver(new VideoFans("XiaoMing"));

        // add videos
        vs.addVideos("Video 1");
    }
}
