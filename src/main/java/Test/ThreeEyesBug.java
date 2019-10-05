package Test;

import java.util.Optional;

public class ThreeEyesBug {
    public static void main(String[] args) {
        Integer aa = 10;
        Integer cc = null;
        int c;
        c = Optional.ofNullable(cc).orElse(aa);
        c = cc == null ? cc : aa;
    }
}
