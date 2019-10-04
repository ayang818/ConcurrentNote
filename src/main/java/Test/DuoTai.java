package Test;

public class DuoTai extends  Girl{
    @Override
    public Integer getPublicInt() {
        return super.getPublicInt();
    }


    public static Integer getStaticInt() {
        return 2;
    }

    public static void main(String[] args) {
        Girl duoTai = new DuoTai();
        Integer publicInt = duoTai.getPublicInt();
        System.out.println(publicInt);
        System.out.println(DuoTai.num);
        System.out.println(getStaticInt());
        System.out.println(duoTai.getStaticInt());
    }
}

class Girl {
    public static Integer num = 2;

    private Integer getInt() {
        return num;
    }

    public static Integer getStaticInt() {
        return 1;
    }

    public Integer getPublicInt() {
        return num;
    }
}
