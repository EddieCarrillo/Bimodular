import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;



public class Peak{

public static void main(String[] args){

    System.out.println("Modular list size: 20");
   //This changes size of bimodular array 
    int bimod_size = 20; 
    //Range of random values
    int random_range = 100;


    Random rand = new Random();
    //Pick a random value for I
    int I = ThreadLocalRandom.current().nextInt(1, bimod_size-1);
    int[] increasing = new int[I];
    int[] decreasing = new int[bimod_size - I];
    int[] uniqueness_inc = new int[10000];
    int[] uniqueness_dec = new int[10000];
    //Init each value to -1
    for (int i = 0; i < uniqueness_inc.length; i++){
        uniqueness_inc[i] = -1;
        uniqueness_dec[i] = -1;
    }
    int counter = 0;
    while (counter < increasing.length){
       int nextInt = rand.nextInt(random_range);
       if (uniqueness_inc[nextInt] != -1){
           System.out.println(nextInt + " was already in the list!");
       }else{
       //A unique number (to satisfy strict inequality constraint)
       increasing[counter] = nextInt;
       uniqueness_inc[nextInt] = 1;
       counter++;
       }
    }

    counter = 0;
        while (counter < decreasing.length){
        int nextInt = rand.nextInt(random_range);
        if (uniqueness_dec[nextInt] != -1){
           System.out.println(nextInt + " was already in the list");
        }else{
        decreasing[counter] = nextInt;
        uniqueness_dec[nextInt] = 1;
        counter++;
    }
        
}

    //Sort the increasing part of the list
    Arrays.sort(increasing);
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
    int alg_sol = findPeak(bimodular, 1, bimodular.length-1);
    System.out.println("\nSolution to problem: \nMax value: " + bimodular[I] + "\n Index: " + I);
    System.out.println("Algorithm solution:\n" + "Max Value: " + bimodular[alg_sol] + "\n Index: " + 0);
    

}
    /*@param bimod: A bimodular array with constraints seen in HW sheet
     *@param l_lim: Current lower lim of array to do search on
     *@param u_lim: Current upper lim of array to do search on
     *
     * */
     public static int findPeak(int[] bimod, int l_lim, int u_lim){
         //Algorithm goes here
         return 0;
     }
    
    




}
