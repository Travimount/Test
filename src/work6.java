class Bug {
    private int position;
    private boolean facingRight;

    public Bug(int initialPosition) {
        position = initialPosition;
        facingRight = true; // 初始时虫子向右移动
    }

    public void turn() {
        facingRight = !facingRight; // 改变方向
    }

    public void move() {
        if (facingRight) {
            position++; // 向右移动
        } else {
            position--; // 向左移动
        }
    }

    public int getPosition() {
        return position;
    }
}

public class work6{
    public static void main(String[] args) {
        Bug bug = new Bug(0); // 初始位置为0

        // 让虫子移动并打印其位置
        bug.move();
        System.out.println("Position: " + bug.getPosition()); // 应该是1

        bug.turn();
        bug.move();
        System.out.println("Position: " + bug.getPosition()); // 应该是0

        bug.move();
        System.out.println("Position: " + bug.getPosition()); // 应该是-1

        bug.turn();
        bug.move();
        System.out.println("Position: " + bug.getPosition()); // 应该是0
    }
}
