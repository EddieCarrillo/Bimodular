import java.util.Random;
import java.util.Arrays;


public class Peak{

public static void main(String[] args){
    System.out.println("This is a mock program!");
    int[] increasing = new int[10];
    int[] decreasing = new int[10];
    int[] uniqueness_inc = new int[10000];
    int[] uniqueness_dec = new int[10000];
    Random rand = new Random();
    //Init each value to -1
    for (int i = 0; i < uniqueness_inc.length; i++){
        uniqueness_inc[i] = -1;
        uniqueness_dec[i] = -1;
    }
    int counter = 0;
    while (counter < increasing.length){
       int nextInt = rand.nextInt(100);
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
        int nextInt = rand.nextInt(100);
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


}
    
    




}