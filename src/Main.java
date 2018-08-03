public class Main {

    public static void main(String[] args) {
        String[] values = {"val1", "val2", "val3", "val4"};
        LList list = new LList(values);

        list.print();
        list.printIter();

        assert(list.find("val1"));
        assert(!list.find("val5"));
    }
}
