package Q3;

public class Test {
    public static void main(String[] args) {
        Book b1 = new Book(1,"Go for it",99.89);
        BookDao bd1 = new BookDao();
        Book b2 = new Book(3, "Hello", 99.66);
//        bd1.create(b1);
//        bd1.create(b2);
//        bd1.readBook();
//        bd1.update(100);
        bd1.delete(100);
        bd1.readBook();

    }
}
