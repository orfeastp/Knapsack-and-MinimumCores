package atomikoproject_2o;

import java.util.ArrayList;

/**
 *
 * @author Ορφέας Τσαρτσιανίδης
 * I took the philosophy of Knapsack class by this web-site:
 * http://www.sanfoundry.com/java-program-solve-knapsack-problem-using-dp/
 * 
 */
public class Knapsack {
    
    static double max(double a, double b) 
    { 
        return (a > b)? a : b; 
    }
    
    /**
     * 
     * @param values
     * @param weight
     * @param W 
     * This function implements the knapsack algorithm and 
     * finds the clients from whom the company can make more money.
     * Also, MinimumCores function prints to screen the result.
     */
    public void Knapsack(ArrayList<Double> values, ArrayList<Integer> weight, int W)
    {
        
        int i,w,f;
        int n = weight.size();
        double [][]K = new double[n+1][W+1];
        int[] take = new int[n+1];
        
 
	// Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (weight.get(i-1)<= w)
                {
                    K[i][w] = max(values.get(i-1) + K[i-1][w-weight.get(i-1)],  K[i-1][w]);
                }
                else
                    K[i][w] = K[i-1][w];
            }
        }

        int num_clients = 0;
        double total_amount=0.0;
        while(n>0)
        {
            if(W>=weight.get(n-1))
            {
                if(K[n][W]>K[n-1][W])
                {
                    take[n]=1;
                    total_amount+=values.get(n-1);
                    W -= weight.get(n-1);
                    n--;
                    num_clients++;
                }
                else
                {
                    take[n]=0;
                    n--;
                }
            }
            else
            {
                n--;
            }
        }
        
        n = weight.size();
        String show="Clients accepted: ";
        for(f=1;f<=n;f++)
        {
            if(take[f]==1)
            {
                if(num_clients>1)
                {
                    show = show+f+",";
                    num_clients--;
                }
                else
                {
                    show = show+f;
                }
            }
        }
        System.out.println();
        System.out.println(show);
        System.out.println("Total amount: "+total_amount);
    }
}
