import java.util.Scanner;

/**
 * Programmer: Marissa Gonçalves
 * Due Date: November 13, 2018
 */

public class ShortestJobNextAlgorithm 
{
  
    //Initialize the needed variables for the algorithm
    private static int i, j, n, t;
    private static float aw, at;
    private static int w1 = 0;
    private static int t1 = 0;
    private static final int[] bt = new int[10];
    private static final int[] wt = new int[10];
    private static final int[] tt = new int[10];
    
    
    
     /**
     * Runs the Shortest Job Next (SJN) Algorithm
     * @param args The classic name defining a String array in the main class.
     */
    public static void main(String[] args) 
    {
        
       //Create a new scanner object to read the following inputs
       Scanner keyboard = new Scanner(System.in);
       
       
       //Display the title of the SJN algorithm
       System.out.println("SHORTEST JOB NEXT (SJN) ALGORITHM");
       
   
       
       
       //Display a statement telling user to input the number of processes
       System.out.println("\nEnter no. of processes: " );
       

       //Prompt the user to input the number of processes
       n = keyboard.nextInt();
       
      
    
       
       //Display a statement telling user to input the burst time of processes
       System.out.println("\nEnter the burst time of processes: " );
       
       
       
       //For every element, up to the inputted number of processes
       for(i = 0; i < n; i++)
       {
           //Prompt the user to input a value of burst time
           bt[i] = keyboard.nextInt();
       }
       
     
       //Skip a line
       System.out.println();
       
       
       
       
       //For every element, up to the inputted number of processes
       for(i = 0; i < n; i++)
       {
           //For every element, from the current for-loop variable, up to the inputted number of processes
           for(j = i; j < n; j++)
           {
              
              //If one burst time element is greater than the other burst time element, do the following ascending order sorting procedure
              if (bt[i] > bt[j]) 
              {
                 //Place the first burst time element into a storage variable, before the equality
                 t = bt[i];
                 
                 //Let the first burst time element equal to the other burst time element
                 bt[i] = bt[j];
                 
                 //Place the second burst time element into the same storage variable, after the equality
                 bt[j] = t;
              }
        
              
            }
           
        }

      
       

       
       //For every element, up to the inputted number of processes
       for(i = 0; i < n; i++)
       {
           
           //The first index of the waiting time array is 0
           wt[0] = 0;
            
           //Calculate the waiting time for each process
           wt[i+1] = bt[i] + wt[i];
           
           //Add every element of the waiting time array to the total waiting time variable
           w1 += wt[i];
           
           //The first index of the turnaround time array is equal to the first index of the burst time array
           tt[0] = bt[0];
           
           //Calculate the turnaround time for each process
           tt[i+1] = tt[i] + bt[i+1];
           
           //Add every element of the turnaround time array to the total turnaround time variable
           t1 += tt[i];
           
       }
       
       
           //Calculate the average waiting time
           aw = (float) w1/n;
       
           //Calculate the average turnaround time
           at = (float) t1/n;
           
           
           
           
           

           //Display the titles of the recorded values: Burst Time, Waiting Time and Turnaround Time
           System.out.println("bt\t wt\t tt");
           
           
           
            //For every element, up to the inputted number of processes
            for(i = 0; i < n; i++)
            {
                //Print the each of the elements from the burst time, waiting time and turnaround time arrays
                System.out.print(bt[i] + "\t" + wt[i] + "\t" + tt[i] + "\n");
            }
            

            
            //Skip a line
            System.out.println();
            
            
            //Print the average waiting time with two decimal places
            System.out.printf("aw = %.2f \n", aw); 
            
            
            //Print the average turnaround time with two decimal places
            System.out.printf("at = %.2f \n", at); 
        
        
        
        
    }
    
}
