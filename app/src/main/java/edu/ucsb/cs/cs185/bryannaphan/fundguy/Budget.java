package edu.ucsb.cs.cs185.bryannaphan.fundguy;

/**
 * Created by Danielle on 3/20/2017.
 */

public class Budget {
    float budget = 0;
    private static Budget instance = new Budget();
    private BudgetListener listener;

    public static Budget getInstance(){
        if (instance == null){
            instance = new Budget();
        }
        return instance;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float amount){
        this.budget = amount;
        //listener.onChange();
    }

    public interface BudgetListener {
        public void onChange();
    }

}
