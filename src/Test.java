public class Test {

    @Save
    private int a = 1;
    private int b = 2;

    @Save
    private String s = "somtheing";
    private String c = "something2";


    public Test(int a, String s) {
        this.a = a;
        this.s = s;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
