package GB;
//решил попробовать такой дебильный вариант
public final class MyArrayDataException extends MyArraySizeException{
            //благодаря такому наследованию, всего один throws в методе sumArrayElements
    MyArrayDataException (String message, int i , int j){
        super(message, i, j);
    }

    @Override
    void displayInfo() {
        System.out.println("Обнаружен не числовой элемент на позиции: " + "[" + yCrd + "][" + xCrd + "]");
    }
}
