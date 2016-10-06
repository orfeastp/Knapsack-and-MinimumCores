package atomikoproject_2o;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
//import

/**
 *
 * @author Ορφέας Τσαρτσιανίδης
 * 
 */
public class AtomikoProject_2o {

    /**
     * @param args the command line arguments
     * The main function reads the input file and then uses the MinimumCores class to
     * estimate the minimum sum of VMs/client. Also, the main function uses
     * the Knapsack class to find the clients from whom the company can make most money.
     */
    public static void main(String[] args)throws IOException{
        
        String line;
        int i=0,w=0,num_cores=0;
        double v=0.0;
        boolean ins=false;
        ArrayList<Integer> weight = new ArrayList<Integer>();
        ArrayList<Double> values = new ArrayList<Double>();
        
        try (BufferedReader input = new BufferedReader(new FileReader("input.txt"));) 
	{                        
            while ((line = input.readLine()) != null) 
            {
                String token;
                StringTokenizer strTok = new StringTokenizer(line);
                token = strTok.nextToken();
                w = Integer.parseInt(token);
                if(i==0 && ins==false)
                {
                    num_cores= w;
                    ins=true;
                }
                else if(strTok.countTokens()<=2)
                {
                    weight.add(i,w);
                    token = strTok.nextToken();
                    v = Double.parseDouble(token);
                    double k = v * w;
                    values.add(i,k);
                    i++;
                }
            }
        }
        
        int s = weight.size();
        for(int j=0;j<s;j++)
        {
            MinimumCores a = new MinimumCores();
            a.MinimumCores(weight.get(j),j+1);
        }
        
        Knapsack b = new Knapsack(); 
        b.Knapsack(values,weight,num_cores);
        
    }
}
