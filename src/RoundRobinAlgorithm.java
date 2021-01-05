import java.util.Scanner;

/**
 * Programmer: Marissa Gonçalves
 * Due Date: November 13, 2018
 */

public class RoundRobinAlgorithm 
{
    
    //Initialize the needed variables for the algorithm
    private static int i, n, tq, temp;
    private static int count = 0;
    private static int swt = 0;
    private static int stat = 0;
    private static int sq = 0;
    private static float awt = (float) 0.0;
    private static float atat = (float) 0.0;
    private static final int[] st = new int[10];
    private static final int[] bt = new int[10];
    private static final int[] wt = new int[10];
    private static final int[] tat = new int[10];
    
    
    
    /**
     * Runs the Round Robin Algorithm
     * @param args The classic name defining a String array in the main class.
     */
    public static void main(String[] args) 
    {
        
       //Create a new scanner object to read the following inputs
       Scanner keyboard = new Scanner(System.in);
       
       
       //Display the title of the Round Robin algorithm
       System.out.println("ROUND ROBIN ALGORITHM");
       
       
      
       
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
           
           //Let the start time element equal to the initial burst time element
           st[i] = bt[i];
       }
       
     
   
       
       
      //Display a statement telling user to input a time quantum
      System.out.println("\nEnter time quantum: " );
       

      //Prompt the user to input the time quantum
      tq = keyboard.nextInt();
       
      
      //Skip a line
      System.out.println();
       
      
      
      
       //Based on this infinite while-loop, do the following procedure
       while(true)
       {
     
          //For every element, up to the inputted number of processes
          for(i = 0, count = 0; i < n; i++)
          {
              
              //The time quantum is stored in a temp variable
              temp = tq;
              
              //If the start time element is equal to 0, proceed with the following
              if(st[i] == 0)
              {
                  //Increment the count variable by 1
                  count++;
                  
                  //Proceed with the inifinite while-loop
                  continue;
               }
              
              
               //If the cloned burst time element is greater than the inputted time quantum
               if(st[i] > tq)
               {
                   //Let the start time element be subtracted with the time quantum
                   st[i] -= tq;
               }

               //Constrasting the previous if-statement, perform the following steps
               else
               {
                   //If the start time element is greater than or equal to 0, do the following
                   if(st[i] >= 0)
                   {
                      //Let the temp variable equal to the start time element
                      temp = st[i];
                      
                      //Set the start time element to 0
                      st[i] = 0;
                   }
               }   
               
                 //Allow the start time quantum variable to add itself with the temp variable
                 sq += temp;
                 
                 //Make the turnaround time element equal to the start time quantum value
                 tat[i] = sq;
               
          }
                 //If the number of proccesses is equal to the count variable, proceed the following
                 if(n == count)
                 {
                     //Break out of the infinite while-loop
                     break;
                 }
                 
       }
          
          
              //For every element, up to the inputted number of processes
              for(i = 0; i < n; i++)
              {
                  
                  //Make the waiting time element equal to the turnaround time element, subtracted with the burst time element
                  wt[i] = tat[i] - bt[i];
                  
                  //Add every element of the waiting time array to the total waiting time
                  swt += wt[i];
                  
                  //Add every element of the turnaround time array to the total turnaround time
                  stat += tat[i];
                  
              }
              
              
              //Calculate the average waiting time
              awt = (float) swt/n; 
              
              //Calculate the average turnaround time
              atat = (float) stat/n;
              
              
              
               //Display the titles of the recorded values: Process Number, Burst Time, Waiting Time and Turnaround Time
               System.out.println("pno\t bt\t wt\t tat");
               
               
               //For every element, up to the inputted number of processes
               for(i = 0; i < n; i++)
               { 
                    //Print the each of the elements from the process number, burst time, waiting time and turnaround time arrays
                    System.out.print((i+1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i] + "\n");
               }

              
               
               
               
            //Skip a line
            System.out.println();
            
            
            //Print the average waiting time with five decimal places
            System.out.printf("aw = %.5f \n", awt); 
            
            
            //Print the average turnaround time with six decimal places
            System.out.printf("at = %.6f \n", atat); 
     

            
            
       }
    
    
}
