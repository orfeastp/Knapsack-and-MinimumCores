package atomikoproject_2o;


/**
 *
 * @author Ορφέας Τσαρτσιανίδης
 * I make this class by myself. 
 */
public class MinimumCores
{
    int c1=0,c2=0,c7=0,c11=0;
    
    /**
     * 
     * @param cores
     * @param client 
     * This function estimates with consecutive checks the minimum sum of VMs/client.
     * Also, MinimumCores function prints to screen the result.
     */
    public  void MinimumCores(int cores, int client)
    {
        while (cores>0)
        {
            if (cores%11==0)
            {
               c11++;
               cores = cores - 11; 
            }
            else if(cores%7==0)
            {
                c7++;
                cores = cores - 7;
            }
            else if(cores%2==0)
            {
                c2++;
                cores = cores -2;
            }
            else if(cores%1==0)
            {
                c1++;
                cores = cores - 1;        
            }
            else if (cores>=11)
            {
               c11++;
               cores = cores - 11;
            }
            else if(cores<11 && cores>=7)
            {
                c7++;
                cores = cores - 7;
            }
            else if(cores<7 && cores>=2)
            {
                c2++;
                cores = cores -2;
            }
            else if(cores<2)
            {
                c1++;
                cores = cores - 1;        
            }
        }
        System.out.println("Client "+client+": "+c1+" 1-core, "+c2+" 2-core, "+c7+" 7-core and "+c11+" 11-core "+"VMs");
    }
}
