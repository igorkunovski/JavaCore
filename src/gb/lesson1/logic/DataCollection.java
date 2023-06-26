package gb.lesson1.logic;

import java.util.Scanner;

/**
 * Class offers to insert data from User via Scanner.
 */

public class DataCollection {

    Scanner sc = new Scanner(System.in);

    public void run(){

        /*
         * method holds required message for User,
         * checks for inserted data correction and if correct, uses decorator.
         */

        String name = setData("Insert Your name: ");
        String age_str = setData("Insert Your age: ");

        try {

            int age = Integer.parseInt(age_str);
            System.out.println(Decorator.decorate(name, age));

        }catch (NumberFormatException e){
            System.out.println("Not a number!");
        }
    }

    /**
     *
     * @param msg - message asking for required data
     * @return - String of inserted data from User
     **/
    private String setData(String msg) {

        /*
         * method prints inserted message from user to console and
         * returns this as String
         */
        System.out.println(msg);
        return sc.nextLine();
    }
}
