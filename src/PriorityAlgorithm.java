import java.util.Scanner;

/**
 * Programmer: Marissa Gonçalves
 * Due Date: November 13, 2018
 */

public class PriorityAlgorithm 
{

    //Initialize the needed variables for the algorithm
    private static int i, j, n, s;
    private static int w1 = 0;
    private static int t1 = 0;
    private static float aw = (float) 0.0;
    private static float at = (float) 0.0;
    private static final int[] prior = new int[10];
    private static final int[] pno = new int[10];
    private static final int[] bt = new int[10];
    private static final int[] wt = new int[10];
    private static final int[] tt = new int[10];
    
    
    
    /**
     * Runs the Priority Algorithm
     * @param args The classic name defining a String array in the main class.
     */
    public static void main(String[] args) 
    {
        
       
       //Create a new scanner object to read the following inputs
       Scanner keyboard = new Scanner(System.in);
       
       
       //Display the title of the Priority algorithm
       System.out.println("PRIORITY ALGORITHM");
       
    
       
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
           
           //Let the process number element equal the incrementing variable, plus 1
           pno[i] = i + 1;
       }
       
       
       
       
      //Display a statement telling user to input the priority of processes
      System.out.println("\nEnter the priority of processes: " );
       

       //For every element, up to the inputted number of processes
       for(i = 0; i < n; i++)
       {
           //Prompt the user to input a number of burst time
           prior[i] = keyboard.nextInt();
           
           //Let the process number element equal the incrementing variable, plus 1
           pno[i] = i + 1;
       }
       
      
      //Skip a line
      System.out.println();
       
      
      
      
      
      //For every element, up to the inputted number of processes
      for(i = 0; i < n; i++)
      {
          //For every element, from the current for-loop variable, up to the inputted number of processes
          for(j = 0; j < n; j++)
          {
              
              //If one priority element is less than the other priority element, do the following ascending order sorting procedure
              if (prior[i] < prior[j])
              {
                 
                 //Place the first priority element into a storage variable, before the equality
                 s = prior[i];
                 
                 //Let the first priority element equal to the other priority element
                 prior[i] = prior[j];
                 
                 //Place the second priority element into the same storage variable, after the equality
                 prior[j] = s;
                 
                 
                 
                 //Place the first burst time element into a storage variable, before the equality
                 s = bt[i];
                 
                 //Let the first burst time element equal to the other burst time element
                 bt[i] = bt[j];
                 
                 //Place the second burst time element into the same storage variable, after the equality
                 bt[j] = s;
                 
                 
                 
                 //Place the first process number element into a storage variable, before the equality
                 s = pno[i];
                 
                 //Let the first process number element equal to the other process number element
                 pno[i] = pno[j];
                 
                 //Place the second process number element into the same storage variable, after the equality
                 pno[j] = s;
                 
               }
           }
       }
      
      
      
      
       //For every element, up to the inputted number of processes
       for(i = 0; i < n; i++)
       {
           
           //The first index of the waiting time array is 0
           wt[0] = 0;
           
           //The first index of the turnaround time array is equal to the first index of the burst time array
           tt[0] = bt[0];
           
           //Calculate the waiting time for each process
           wt[i+1] = bt[i] + wt[i];
           
           //Calculate the turnaround time for each process
           tt[i+1] = tt[i] + bt[i+1];
           
           //Add every element of the waiting time array to the total waiting time variable
           w1 += wt[i];
          
           //Add every element of the turnaround time array to the total turnaround time variable
           t1 += tt[i];
       
        }
      
       
        //Calculate the average waiting time
        aw = (float) w1/n;
        
        //Calculate the average turnaround time
        at = (float) t1/n;
      

        
        
        //Display the titles of the recorded values: Process Number, Burst Time, Priority Value, Waiting Time and Turnaround Time     
        System.out.println("pno\t bt\t prior\t wt\t tt\t ");
               
         
        
        //For every element, up to the inputted number of processes
        for(i = 0; i < n; i++)
        { 
            //Print the each of the elements from the process number, burst time, priority value, waiting time and turnaround time arrays
            System.out.print(pno[i] + "\t" + bt[i] + "\t" + prior[i] + "\t" + wt[i] + "\t" + tt[i] + "\n");
        }
   
               
            //Skip a line
            System.out.println();
            
            
            //Print the average waiting time with six decimal places
            System.out.printf("aw = %.6f \n", aw); 
            
            
            //Print the average turnaround time with six decimal places
            System.out.printf("at = %.6f \n", at); 
     
  
            
     
            
       }
    
}
