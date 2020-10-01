public class Hanoi {
    private int n;

    public Hanoi(int n) {
        this.n = n;
    }

    private void print(int n, char from, char to) {
        System.out.println(n + "를 " + from + "에서 " + to + "로 이동");
    }

    private void hanoi(int n, char from, char by, char to) {
        if (n == 1) {
            print(n, from, to);
        } else {
            hanoi(n - 1, from, to, by);
            print(n, from, to);
            hanoi(n - 1, by, from, to);
        }
    }

    public void run() {
        hanoi(this.n, 'A', 'B', 'C');
    }
}