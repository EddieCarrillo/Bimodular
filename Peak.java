import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;



public class Peak{

public static void main(String[] args){

   //This changes size of bimodular array 
    int bimod_size = 100000;  
    //Range of random values
    int random_range = 1000000;

    System.out.println("bimodular array size: " + bimod_size);

    Random rand = new Random();
    //Pick a random value for I or change it if you want to test for certain interval
    int I = ThreadLocalRandom.current().nextInt(1, bimod_size-1);
    int[] increasing = new int[I];
    int[] decreasing = new int[bimod_size - I];
    int[] uniqueness_inc = new int[random_range];
    int[] uniqueness_dec = new int[random_range];
    //Init each value to -1
    for (int i = 0; i < uniqueness_inc.length; i++){
        uniqueness_inc[i] = -1;
        uniqueness_dec[i] = -1;
    }
    int counter = 0;
    while (counter < increasing.length){
       int nextInt = rand.nextInt(random_range);
       if (uniqueness_inc[nextInt] != -1){
           //System.out.println(nextInt + " was already in the list!");
       }else{
       //A unique number (to satisfy strict inequality constraint)
       increasing[counter] = nextInt;
       uniqueness_inc[nextInt] = 1;
       counter++;
       }
    }

    Arrays.sort(increasing);
    counter = 0;
        while (counter < decreasing.length){
        int nextInt = rand.nextInt(random_range);
        if (uniqueness_dec[nextInt] != -1 ){//Make sure max of increasing value is not duplicated
           //System.out.println(nextInt + " was already in the list");
        }else if (nextInt == increasing[increasing.length-1]){ //Make sure we don't duplicate max values
            //System.out.println("We don't duplicate max values..... " + nextInt ); 
        
        }else{
        decreasing[counter] = nextInt;
        uniqueness_dec[nextInt] = 1;
        counter++;
    }
        
}
    //Sort the decreasing part of the list
    Arrays.sort(decreasing);
     

    int[] bimodular = new int[increasing.length + decreasing.length];
    for (int i = 0; i < increasing.length; i++){
        bimodular[i] = increasing[i];
    }
    int inc_offset = increasing.length;
    for (int i = 0; i < decreasing.length; i++){
        bimodular[inc_offset + i] = decreasing[decreasing.length-1 -i];
    }
    

    for (int i = 0; i < bimodular.length; i++){
        System.out.print(bimodular[i] + " ");
    }

    int solution;
    int dec_max = decreasing[decreasing.length -1 ];
    //System.out.println("dec_max: " + dec_max);
    int inc_max = increasing[increasing.length-1];
    //System.out.println("inc_max: " +  inc_max);
    if (inc_max > dec_max){
        solution = increasing.length-1;
    }else{
        solution = increasing.length;
    }

    int alg_sol = findPeak(bimodular, 0, bimodular.length);
    System.out.println("\nSolution to problem: \nMax value: " + bimodular[solution] + "\n Index: " + (solution));
    System.out.println("Algorithm solution:\n" + "Max Value: " + bimodular[alg_sol] + "\n Index: " + alg_sol);
    

}
    /*@param bimod: A bimodular array with constraints seen in HW sheet
     *@param l_lim: Current lower lim of array to do search on
     *@param u_lim: Current upper lim of array to do search on
     *
     * */
     public static int findPeak(int[] bimod, int l_lim, int u_lim){
         //Algorithm goes here
         //if (u_lim == l_lim) return l_lim;
         if (u_lim - l_lim == 2) return l_lim + 1;
         //if (u_lim - l_lim == 1) return l_lim;
        // Similar to bin search just pick middle each time
         int guess = (l_lim + u_lim) / 2;
         if (bimod[guess] < bimod[guess + 1]){//If increasing 
             //Update the lower limit
             return findPeak(bimod,guess, u_lim);
         
         }else{//If decreasing
             //Update the upper limit
             return findPeak(bimod, l_lim, guess+1);
         }
            

     }
    
    




}
