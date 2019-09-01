package Builder;

/**
 * @ClassName BuilderTest
 * @Dessription 建造者模式
 * @Author 杨丰畅
 * @Date 2019/9/1 16:05
 **/
public class BuilderTest {
    private Integer id;
    private Integer password;
    private String avatar;

    private BuilderTest(Builder builder) {
        this.id = builder.id;
        this.password = builder.password;
        this.avatar = builder.avatar;
    }


    public static class Builder {
        private Integer id;
        private Integer password;
        private String avatar;

        public Builder Builder() {
            return this;
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setPassword(Integer password) {
            this.password = password;
            return this;
        }

        public Builder setAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public BuilderTest build() {
            return new BuilderTest(this);
        }

    }

}
