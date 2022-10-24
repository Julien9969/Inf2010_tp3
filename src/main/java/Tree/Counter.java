package Tree;




public class Counter {

    public enum op {
        SEARCH(0), INSERT(1);
        private final int cte;

        op(int val) {
            this.cte = val;
        }
    }

    int[] count;
    public Counter() {
        this.count = new int[]{0, 0};
    }

    public void increments(op type) {
        this.count[type.cte] ++;
    }

    public int getCountSearch(op type) {
        return this.count[type.cte];
    }

    public void reset() {
        this.count[op.INSERT.cte] = 0;
        this.count[op.SEARCH.cte] = 0;
    }

}
