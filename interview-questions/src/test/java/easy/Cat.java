package easy;

public class Cat implements Animal {

    public static final String COMPANY_NAME = "MY BEST COMPANY";
    public String getCompanyName = "Company";

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    public void test() {
        System.out.println("3");
    }

    @Override
    public void eat() {
        System.out.println("cat eating");
    }

    @Override
    public void makeSound() {
        System.out.println("meow");
    }
}
