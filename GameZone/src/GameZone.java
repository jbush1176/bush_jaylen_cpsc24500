import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.Random;

public class GameZone{

    //Methods that contain the 'Games'
	//Jaylen A. Bush w/ tutor help
	//Tutor is a co-worker at one of my internships.
	//tutor helped me break down what everything meant,
	//I hope this looks good. I will ask you more questions, Dr. Klump.

    //Twenty One, how to start any program
    static void twentyOne() {

        //declarations
        int total;
        int dealer;
        int[] cards = new int[]{ 1,2,3,4,5,6,7,8,9,10,11};
        int[] dealerCards = new int[]{13,14,15,16,17,18,19,20};

        int rnd = new Random().nextInt(cards.length);
        System.out.println("You drew "+cards[rnd]+".");
        total = cards[rnd];
        System.out.println("Your current total is "+total+".");
        System.out.println("Do you want to draw another card?");
        Scanner yn = new Scanner(System.in);
        String str = yn.next();
        char ch = str.charAt(0);
        
        // Here, the program cuts the game and brings a card 
        // down from the dealer's deck to go against yours.
        
        if (ch == 'n'){
        	
            int rndDealer = new Random().nextInt(dealerCards.length);
            dealer = dealerCards[rndDealer];
            System.out.println("The computer drew "+dealerCards[rndDealer]+".");

            if(dealer > total){
                System.out.println("You lost.");
            } else if (dealer <= total){
                System.out.println("You won!");
            }
            return;
        }
        // draw a card again, go through the program again.
        if (ch == 'y') {
            rnd = new Random().nextInt(cards.length);
            System.out.println("You drew "+rnd+".");
            total = total + rnd;
            System.out.println("Your current total is "+total+".");
            System.out.println("Do you want to draw another card?");
            yn = new Scanner(System.in);
            str = yn.next();
            ch = str.charAt(0);

            if (ch == 'n'){

                int rndDealer = new Random().nextInt(dealerCards.length);
                dealer = dealerCards[rndDealer];
                System.out.println("The computer drew "+dealerCards[rndDealer]+".");

                if(dealer > total){
                    System.out.println("You lost.");
                } else if (dealer <= total){
                    System.out.println("You won!");
                }
                return;
            }

            if (total == 21){
                System.out.println("You won!");
            } else if (total > 21){
                System.out.println("You lost.");
            }
            
            for (total = total; total < 21;) {

                rnd = new Random().nextInt(cards.length);
                System.out.println("You drew "+rnd+".");
                total = total + rnd;
                System.out.println("Your current total is "+total+".");
                if (total == 21){
                    System.out.println("You Won!");
                    return;
                } else if (total > 21){
                    System.out.println("You lost.");
                    return;
                }
                System.out.println("Do you want to draw another card?");
                yn = new Scanner(System.in);
                str = yn.next();
                ch = str.charAt(0);

                if (ch == 'n'){

                    int rndDealer = new Random().nextInt(dealerCards.length);
                    dealer = dealerCards[rndDealer];
                    System.out.println("The computer drew "+dealerCards[rndDealer]+".");

                    if(dealer > total){
                        System.out.println("You lost.");
                    } else if (dealer <= total){
                        System.out.println("You won!");
                    }
                    return;
                }

                if (total == 21){
                    System.out.println("You won!");
                } else if (total > 21){
                    System.out.println("You lost.");
                }
            }
            }
        }

    //Rock Paper Scissors Game code called "RoShamBo"
    //Had the code randomly generate the rock,paper,or scissors.
    //just push the button 
    static void RoShamBo(){

        Random rand = new Random();

        int player = rand.nextInt(3);
        int computer = rand.nextInt(3);
        String computerMove="void";
        String playerMove="void";

        if (computer == 0){
            computerMove = "Scissors";
        } else if (computer == 1){
            computerMove = "Rock";
        } else if (computer == 2){
            computerMove="Paper";
        }

        if (player == 0){
            playerMove = "Scissors";
        } else if (player == 1){
            playerMove = "Rock";
        } else if (player == 2){
            playerMove="Paper";
        }

        System.out.println("You played "+playerMove+" and the computer played "+computerMove+".");

        if (player == computer){
            System.out.println("It was a tie.");
        } else if (player == 0 && computer == 1){
            System.out.println("You lost.");
        } else if (player == 1 && computer == 2){
            System.out.println("You lost.");
        } else if (player == 2 && computer == 0){
            System.out.println("You lost.");
        } else {
            System.out.println("You Won!");
        }
    }
  

    //Main program to run
     public static void main(String []args){
         

        //declarations
         Scanner sc = new Scanner(System.in);
         int gameChoice;
         
         
         //Terminal output, main menu of the game
         System.out.println("******************************************");
         System.out.println("*        Welcome to the Game Zone        *");
         System.out.println("******************************************");

         //for loop that waits for 3 to exit the whole game
        for (gameChoice=0; gameChoice != 3;) {

        System.out.println("What would you like to play?");
        System.out.println("1. Twenty-one");
        System.out.println("2. Rock Papaer Scissors");
        System.out.println("3. Neither - I'm done!");
        
        System.out.println("Please enter the number of your choice: ");
        gameChoice = sc.nextInt();

        if (gameChoice == 1) {
            twentyOne();
        } else if (gameChoice == 2) {
            RoShamBo();
        } else if (gameChoice == 3) {
            System.out.println("Thank you for playing.");
            return;
        } else if (gameChoice != 1 || gameChoice != 2 || gameChoice != 3){
            System.out.println("Not a valid choice.");
        }
        
    }
        
     }

}