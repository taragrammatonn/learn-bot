package easy;

public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("dog eating");
    }

    @Override
    public void makeSound() {
        System.out.println("bark");
    }
}
