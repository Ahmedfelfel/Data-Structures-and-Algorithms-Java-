import java.util.ArrayList;

public class Knapsack {
    private final ArrayList<Item> items;
    /* TODO: declare a memoization table */
        int [][]memo;

    private int solve(int i, int capacity) {
    /* TODO: implement the algorithm just as in the task description */
        if (memo==null)
        {
            memo=new int[items.size()][capacity+1];
            memo = new int[items.size()][capacity + 1];
            for (int j = 0; j < items.size(); j++) {
                for (int c = 0; c <= capacity; c++) {
                    memo[j][c] = -1;
                }
            }


        }
        if (i<0 || capacity <=0)
            return 0;
        else if(items.get(i).weight>capacity)
        {
            if(memo[i][capacity]==-1)
                memo[i][capacity]=solve(i-1,capacity);
            return memo[i][capacity];
        }
        else
        if(memo[i][capacity]==-1)
            memo[i][capacity]=Math.max(items.get(i).value+solve(i-1,capacity-items.get(i).weight),solve(i-1,capacity));
        return memo[i][capacity];
    }

    // DO NOT TOUCH - This method is prepared for you to enable adding a new item
    public void addItem(String name, int weight, int value) {
        items.add(new Item(name,weight,value));
    }

    // empty constructor
    public Knapsack() {
        items = new ArrayList<>();
    }

    // DO NOT TOUCH - This method is prepared to give access to internal methods while protecting data
    public int solve(int capacity) {
        return solve(items.size() - 1, capacity);
    }

    private static final class Item {

    /* TODO: define an item object class */
            String name;
            int weight;
            int value;
            public Item(String name,int weight,int value)
            {
                this.name=name;
                this.weight=weight;
                this.value=value;
            }
    }
}