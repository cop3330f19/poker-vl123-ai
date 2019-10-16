/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.Arrays;

/**
 *
 * @author vlawrence6491
 */
public class PokerController {
    
        @FXML private TextField rank1;
	@FXML private TextField suit1;
	
	@FXML private TextField rank2;
	@FXML private TextField suit2;
	
	@FXML private TextField rank3;
	@FXML private TextField suit3;
	
	@FXML private TextField rank4;
	@FXML private TextField suit4;
	
	@FXML private TextField rank5;
	@FXML private TextField suit5;
 
	@FXML private TextField Result;
        
         int [][] poker = new int[4][13];
      
  
String[] hand = {"FLUSH", "FOUR OF A KIND", "THREE OF A KIND", "FULL HOUSE", "STRAIGHT", "STRAIGHT FLUSH", "TWO PAIR","PAIR"};
      
      int dflush =0;
      int hflush=0;
      int cflush=0;
      int sflush=0;
    int[] rankCount= new int [13];
        
    public void displayHand(ActionEvent event) 
    {
        populateArray(suit1.getText().charAt(0), Integer.parseInt(rank1.getText()));
        populateArray(suit2.getText().charAt(0), Integer.parseInt(rank2.getText()));
        populateArray(suit3.getText().charAt(0), Integer.parseInt(rank3.getText()));
        populateArray(suit4.getText().charAt(0), Integer.parseInt(rank4.getText()));
        populateArray(suit5.getText().charAt(0), Integer.parseInt(rank5.getText()));

         for (int i =0; i< 13; i++)
            { 
                       straight(rankCount);
                       flush(dflush,hflush,cflush,sflush);
                       fourKind(rankCount);
                       threeKind(rankCount);
                       twoPair(rankCount);
                       Pair(rankCount);
                }
    
    //straightflush
    
         if (straight(rankCount)== true && flush(dflush,hflush,cflush,sflush) == true)    
    {
        Result.setText(hand[5]);
    }         
         else  if (straight(rankCount)== true && !flush(dflush,hflush,cflush,sflush))    
    {
        Result.setText(hand[4]);
    }         
    
    //flush
         else if (!straight(rankCount)&& flush(dflush,hflush,cflush,sflush)== true)  
                  {
                      Result.setText(hand[0]);
    }
    
    // full House
    
         else if (threeKind(rankCount)== true && Pair(rankCount)== true)
    {
        Result.setText(hand[3]);
        
    }
        
    //fourKind                
         else if (fourKind(rankCount))  
                  {
                      Result.setText(hand[1]);
                }
      //threeKind 
               
         else if (threeKind(rankCount))  
                  {
                      Result.setText(hand[2]);
                }
    //twoPair
         else if (twoPair(rankCount))  
                  {
                      Result.setText(hand[6]);
                      
                } 
     //Pair 
         else if (Pair(rankCount))  
                  {
                      Result.setText(hand[7]);
                } 
         else{
             Result.setText("You have nothing");
         }
    }
    
    private void populateArray(char suit, int value){
         if (suit == 'D')
            {
                poker[0][value-1] = 1; 
                dflush++;
                rankCount[value-1]++;
            }
            
            if (suit == 'H')
            {
                poker[1][value-1] = 1; 
                rankCount[value-1]++;
                hflush++;
            }
            
            if (suit == 'C')
            {
                poker[2][value-1] = 1; 
                rankCount[value-1]++;
                cflush++;
            }
            
            if (suit == 'S')
            {
                poker[3][value-1] = 1; 
                rankCount[value-1]++;
                sflush++;
            }
    }
        
    public static boolean straight(int rankCount[]) 
     {
          boolean isStraight = false;
         
         for (int i =0; i< 13; i++)
         {
         if (rankCount[i]==1 && rankCount[i+1]==1 && rankCount[i+2]==1 && rankCount[i+3]==1 && rankCount[i+4]==1)
                    {
                        isStraight = true;
                    }
                    
         if (rankCount[i]==1 && rankCount[i-1]==1 && rankCount[i-2]==1 && rankCount[i-3]==1 && rankCount[i-4]==1)
                    {
                       isStraight= true;
                    }
         }
         
         return isStraight;
     }

    public static boolean flush(int dflush, int hflush, int cflush, int sflush)
  {
     boolean isFlush = false;
            
       if ( dflush==5 || hflush == 5 ||cflush == 5 ||sflush == 5)
              {
           isFlush = true;
          }
        
        return isFlush;
  }
    
    
     public static boolean fourKind(int rankCount[]) 
     { 
         boolean isFour = false;
          for (int i =0; i< 13; i++)
         {
          if (rankCount[i]== 4)    
                 {
                    isFour = true;
                 }
          }
         return isFour;
     }
    
    public static boolean threeKind(int rankCount[]) 
     { 
         boolean isThree = false;
          for (int i =0; i< 13; i++)
         {
          if (rankCount[i]== 3)    
                 {
                    isThree = true;
                 }
          }
         return isThree;
     }
    
    public static boolean twoPair(int rankCount[]) 
     {  
         int pair =0;
         boolean isTwo = false;
          for (int i =0; i< 13; i++)
         {
          if (rankCount[i]==2)
            {
                pair++;
            }
          }
        if (pair == 2)
        {
            isTwo = true;
        }
         return isTwo;
     }
    
    public static boolean Pair(int rankCount[]) 
     { 
         boolean isPair = false;
          for (int i =0; i< 13; i++)
         {
          if (rankCount[i]==2)
            {
                isPair =true;
            }
          }
         return isPair;
     }
}
