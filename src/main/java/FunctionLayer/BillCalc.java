package FunctionLayer;

public class BillCalc {

    public Bill createBill(Order order) {
        int length = order.getLength();
        int width = order.getWidth();
        int posts = this.calcPost(length);
        int brackets = this.calcbrackets(posts);
        int screws = this.calscrews(brackets);

        Bill bill = new Bill(screws, posts, brackets);

        return bill;

    }

    private int calcPost(int length) {
        int posts = 0;
        int test = length / 250;

        if (test < 1) {
            posts = 4;
            return posts;
        } else if (test > 1) {
            posts=4;
            while (test != 0) {
                posts += 2;
                test--;
            }
        }

        return posts;
    }

    private int calscrews(int brackets) {
        int screws = brackets * 6;
        return screws;
    }

    private int calcbrackets(int posts) {

        int brackets = posts;
        return brackets;
    }

}
