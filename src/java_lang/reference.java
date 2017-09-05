package java_lang;

/**
 * Created by naco_siren on 8/21/17.
 */
public class reference {
    public static void main(String[] args) {
        Integer i1 = 3;
        func1(i1);
        func2(i1);
        return;
    }

    public static void func1(Integer i) {
        i = new Integer(5);
        return;
    }

    public static void func2(Integer i) {
        i += 100;
        return;
    }
}
