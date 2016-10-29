package sample3;

/**
 * Created by dark on 2016. 10. 29..
 */
public class Shop {

    public PC buyPc() {
        return new PC();
    }

    class PC {
        public String vendor = "Sunny";
        public Integer clockRate = 2333;
        public Integer ram = 406;
        public String os = "Linux";
    }
}
