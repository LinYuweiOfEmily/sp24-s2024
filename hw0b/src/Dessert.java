public class Dessert {
    private int flavor;
    private int price;
    private static int numDessert;

    public Dessert(int flavor, int price) {
        numDessert += 1;
        this.flavor = flavor;
        this.price = price;
    }

    public void printDessert(){
        System.out.println(flavor+" "+price+" "+numDessert);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
