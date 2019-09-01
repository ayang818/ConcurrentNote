package Builder;

/**
 * @ClassName BuilderIt
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/1 16:14
 **/
public class BuilderIt {
    public static void main(String[] args) {
        BuilderTest builderTest = new BuilderTest.Builder().setId(1).setPassword(2).setAvatar("111").build();
    }
}
