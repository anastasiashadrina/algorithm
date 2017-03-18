/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author ANASTASIA
 */
public class Algorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Integer Prices[] = {75, 133, 110, 85, 105, 45, 83, 63, 101, 112, 94, 106, 101, 79, 54};
        
        // Print input array
        
        System.out.print("Input price array: ");
        for (int i = 0;
             i < Prices.length;
             ++i) {
            
            System.out.print(Prices[i].toString());
            if (i + 1 < Prices.length) {
                System.out.print(", ");
            }
        }
        System.out.print("\n\n");
        
        
        // Calculate delta array
        
        Integer D[] = new Integer[Prices.length - 1];
        for (int k = 0;
             k < Prices.length - 1;
             ++k) 
        {
            D[k] = Prices[k + 1] - Prices[k];
        }
       
        
        // Algorithm "recurrent"
        
        Integer bestBeginn = 0;
        Integer bestEnd = 0;
        Integer bestS = 0;
        
        Integer Begin = -1;
        Integer End = 0; 
        Integer Sum = 0;
        
        for (int k = 0;
             k < Prices.length - 1;
             ++k) {
            Integer d = D[k];
            
            if (Begin == -1) {
                Begin = k;
                End = k + 1;
                Sum = d;
            } else {
                ++End;
                Sum += d;
            }
            
            if (Sum <= 0) {
                // Degenerate
                Begin = -1;
                End = 0;
                Sum = 0;
            } else if (Sum > bestS) {
                bestBeginn = Begin;
                bestEnd = End;
                bestS = Sum;
            }
            
        }
        
        // Print results
        
        if (bestS == 0) {
            System.out.print("It is better not to buy anything :-(\n\n");
        } else {
            System.out.print("Purchase at day #" + bestBeginn.toString() +
                    " ($" + Prices[bestBeginn].toString() + ")" +
                    " and sell at day #" + bestEnd.toString() +
                    " ($" + Prices[bestEnd].toString() + ")" + "\n");
            System.out.print("You will earn $" + bestS.toString() + "\n");
        }
    }
    
}
