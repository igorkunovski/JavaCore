package gb.lesson1.logic;

/**
 *Class sample.logic.Decorator format inserted data into returned string
 */

public class Decorator {

    /**
     * @param name - name of the person
     * @param age  - age of the person
     * @return - decorated returned String of persona name and age
     **/
    public static String decorate(String name, int age){
        /*
         * method with logic of decoration
         **/
        return String.format("Hello %s. Your age is: %d. ", name, age);
    }
}
