package basic;

import java.util.Calendar;

public class BaseMain {
    public static void main(String[] args){
        BasicJavaProgram basicJavaProgram = new BasicJavaProgram();
        basicJavaProgram.setA(10);
        System.out.println(basicJavaProgram.getA());
        System.out.println(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
    }
}
