package GB;

public class MyArraySizeException extends Exception{
    protected int yCrd;
    protected int xCrd;
    private final String MSG1;

    MyArraySizeException (String message, int yCrd, int xCrd){
        MSG1 = message;
        this.xCrd = xCrd;
        this.yCrd = yCrd;
    }

    void displayInfo(){ //работает корректно только для прямоугольных/квадратных массивов
        String msg2 = "Ваш массив: " + yCrd + "x" + xCrd;
        System.out.println(MSG1 + ", " + msg2);
    }
}
