package by.halaburda.andrei.l4;

public class testSinglton {
    private static final testSinglton ourInstance = new testSinglton();

    public static testSinglton getInstance() {

        return ourInstance;
    }

    private testSinglton() {
    }
}
