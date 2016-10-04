/**
 * Created by Pin on 27-Sep-16.
 */
public class EatableAnimals {
    public static void main(String[] args) {
        System.out.println(cook (new Chicken()));
        System.out.println(cook (new Duck()));
//        System.out.println(cook (new Dog())); // Dog has no characteristic of being Eatable
    }
    /* //can use Eatable as a data type as well even
    though it is an interface */

    public static String cook(Eatable c){
        return "cook it: " +c.howToEat();
    }
}
//-----INTERFACES-----------------------
interface Eatable{
    public abstract String howToEat();
}
//--------------------------------------

class Animal{

}

class Chicken extends Animal implements Eatable{
    @Override
    public String howToEat() {
        return "FRY THE CHICKEN";
    }
}

class Duck extends Animal implements Eatable{
    @Override
    public String howToEat() {
        return "BOIL THE DUCK";
    }
}
class Dog extends Animal { // Dog is not eatable!!!

}

class Chocolate implements Eatable{
    @Override
    public String howToEat() {
        return "Mmm Chocolate yeaaa";
    }
}