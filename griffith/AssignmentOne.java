package griffith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Character selection
        String character = "";
        while (true) {
            System.out.println("Please select your character: kai or evilkai");
            character = scanner.nextLine().trim().toLowerCase();
            if (character.equals("kai") || character.equals("evilkai")) {
                break;
            } else {
                System.out.println("Invalid Input! Please enter 'kai' or 'evilkai'.");
            }
        }

        // Display selected character
        if (character.equals("kai")) {
            System.out.println("You have selected:");
            System.out.println(BLUE + getKaiArt() + RESET);
        } else {
            System.out.println("You have selected:");
            System.out.println(YELLOW + getEvilKaiArt() + RESET);
        }
        //Short narrative
        if (character.equals("kai")) {
            System.out.println(BLUE +
                    "Kai, the noble samurai, steps into the gambling hall.\n" +
                    "You fight with honor. No tricks. No shortcuts.\n" +
                    RESET);
        } else {
            System.out.println(YELLOW +
                    "EvilKai rises from the shadows...\n" +
                    "You bend the rules, but every sin has a price.\n" +
                    RESET);
        }

        // Main game loop for multiple rounds
        boolean playAgain = true;
        while (playAgain) {
            playGame(character, scanner);
            System.out.println("Would you like to play again? (yes/no)");
            String retry = scanner.nextLine().trim().toLowerCase();
            playAgain = retry.equals("yes");
        }

        // Game over message
        System.out.println(" _                        \r\n"
                + "| |    ___  ___  ___ _ __ \r\n"
                + "| |   / _ \\/ __|/ _ \\ '__|\r\n"
                + "| |__| (_) \\__ \\  __/ |   \r\n"
                + "|_____\\___/|___/\\___|_|   ");
        scanner.close();
    }

    private static void playGame(String character, Scanner scanner) {
    	int playerHP = 3;
    	int dealerHP = 3;
    	int round = 1;
        // Create and shuffle deck
    	while (playerHP > 0 && dealerHP > 0) {

    	    System.out.println("\n--- ROUND " + round + " ---");
    	    round++;

    	    List<String> deck = createDeck();
    	    Collections.shuffle(deck);
       

        // Deal initial cards
        List<String> playerCards = new ArrayList<>();
        List<String> dealerCards = new ArrayList<>();
        playerCards.add(drawCard(deck));
        playerCards.add(drawCard(deck));
        dealerCards.add(drawCard(deck));
        dealerCards.add(drawCard(deck));

        int playerTotal = calculateHandValue(playerCards);
        int dealerTotal = calculateHandValue(dealerCards);

        System.out.println("Your cards: " + playerCards + " | Total: " + playerTotal);
        System.out.println("Dealer's visible card: " + dealerCards.get(0));

        boolean playerBusted = false;
        boolean playerStood = false;
        int stealAttempts = 0;
        int maxSteals = character.equals("evilkai") ? (int) (Math.random() * 3) + 1 : 0;

        // Player's turn
        while (!playerBusted && !playerStood)
        {
            String action = "";
            if (character.equals("kai")) {
                System.out.print("Do you want to hit or stand? (hit/stand): ");
                action = scanner.nextLine().trim().toLowerCase();
            } else { // evilkai
                System.out.print("Select steal, hit, or stand: ");
                action = scanner.nextLine().trim().toLowerCase();
            }

            if (action.equals("hit")) {
                String newCard = drawCard(deck);
                playerCards.add(newCard);
                playerTotal = calculateHandValue(playerCards);
                System.out.println("You drew: " + newCard);
                System.out.println("Your cards: " + playerCards + " | Total: " + playerTotal);
                if (playerTotal > 21) {
                    System.out.println("You busted! Dealer wins.");
                    playerBusted = true;
                }
            } 
            else if (action.equals("stand")) {
                playerStood = true;
            } 
         else if (character.equals("evilkai") && action.equals("steal")) {
            if (stealAttempts < maxSteals) {
                stealAttempts++;
                String stolenCard = dealerCards.remove(0);
                playerCards.add(stolenCard);
                dealerTotal = calculateHandValue(dealerCards);
                playerTotal = calculateHandValue(playerCards);
                System.out.println("You stole: " + stolenCard);
                System.out.println("Your cards: " + playerCards + " | Total: " + playerTotal);
                double catchChance = 0.20 + (0.15 * stealAttempts);
                if (Math.random() < catchChance) {
                    System.out.println("You were caught stealing!");
                    playerHP--;
                    if (playerHP <= 0) {
                        System.out.println("EvilKai has fallen...");
                        return;
                    }
                } 
                else {
                    System.out.println("Steal successful. The shadows protect you.");
                }
            } 
            else {
                System.out.println("No more steal attempts!");
            }
        }
            else {
                System.out.println("Invalid action. Please try again.");
            }
        }
        if (playerBusted) {
            return; // Game over, dealer wins
        }

        // Dealer's turn
        System.out.println("Dealer's cards: " + dealerCards + " | Total: " + dealerTotal);
        while (dealerTotal < 17) {
            String newCard = drawCard(deck);
            dealerCards.add(newCard);
            dealerTotal = calculateHandValue(dealerCards);
            System.out.println("Dealer drew: " + newCard);
            System.out.println("Dealer's cards: " + dealerCards + " | Total: " + dealerTotal);
        }

        // Determine winner
        System.out.println("Final Results:");
        System.out.println("Your total: " + playerTotal);
        System.out.println("Dealer's total: " + dealerTotal);
        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            dealerHP--;
            System.out.println("You win this round!");
        } 
        else if (playerTotal < dealerTotal) {
            playerHP--;
            System.out.println("You lose this round!");
        } 
        else {
            System.out.println("Round tied. No damage dealt.");
        }
    	}
    }
    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        String[] suits = {"H", "D", "C", "S"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }
        return deck;
    }

    private static String drawCard(List<String> deck) {
        return deck.remove(0); // Since shuffled, remove from front
    }

    private static int calculateHandValue(List<String> cards) {
        int total = 0;
        int aces = 0;
        for (String card : cards) {
            String rank = card.substring(0, card.length() - 1); // Remove suit
            switch (rank) {
                case "A":
                    aces++;
                    total += 11;
                    break;
                case "K":
                case "Q":
                case "J":
                case "10":
                    total += 10;
                    break;
                default:
                    total += Integer.parseInt(rank);
            }
        }
        // Adjust for aces
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

    private static String getKaiArt() {
        return """
                                 ..                                
                                  +*                               
                                   ##:                             
                                    %%-                            
                                     %#:                           
                                     :@*.                          
                                      =#=                          
                                       *@:                         
                                       :%%.                        
                                        -%*                        
                                         *%-                       
                                         .%*.                      
                                          -%-                      
                                          .**.                     
                                           =%=                     
                                  .         *%:                    
                                  .+::====: -%+.                   
                                .+#%*%%%#**- %%-                   
                                *%%@@%%@%%##=+%+.                  
                               :%%%%%%%@%%@##=*%:                  
                               %%=-:::=*#*%%%*=%*.                 
                             =@%*-:::-#**##%@%:*%:                 
                             .:%%+**::=#+:=%%#.=@*                 
                               :*:::-:.=*=%**=.:#%:                
                              :-:-:::::::*#:    *%+                
                             --. -+::-:-**::  . *%*=:              
                           :=*%**%%@@%#@%%-:.. .=%-::              
                          .=*+=***=*@%#%%%**+*=::::-:.             
                          *%%**#+%%%%***#***#*=::::::.             
                         .*@#***%%%%%@%%@%##@@#=-:*%=.             
                       .:++%+*#%%@@@%%%%%%@@@@%==::%*.             
                       .:+*%%+%@@@@%%%%%@@@@@@@%#*=%%:             
                       :*#%@@%%%@@@@@@@@@%%%@#%%+=%%%=             
                     .*=*+%%*+=+****##%%@@@@@%**===%%+             
                   .-*%@@%*=====***#%%@%%@@**@**===%*===-          
                  -%%%%%%#***#%@@@@@%@%#@@@%%%%*==%%%%+===.        
                 .-------=%%###%#***=+-::=--=:+%*%%%%%%#+++        
                        -%%%###*-:::.==::-:-=##%%#%%%%@%**:        
                      .=%%###%@@@@@@@@@@@@@@@@%%#*#@%%%%*:         
                    :-=***#*#%%%@@@@@@@@@@@@@@@@%#*%@#-:::         
                  .:+******%%%%%@@@@@@@@@@@@@@@@%#**#===::         
                  -+=+****%%%%%%@@@@@@@@@@@@@@%%%%#%@#=:::-        
                .====****#%%##%@%%@@@@@@@@@@@@@%%@@%%@::==::       
              .-=--==***#%%%#%@%#%@@@@@@@@@@@%@%%@%@@*.--:.        
             =-----=++**%%#%%@%%%%%@@@@@@@@@%%%@%%@%%+.            
           .-------++**%#%%%@%##%%%@@@@@@@@%%#%@@@**%@**.          
          .-------=+**%#%##@%%%%%%%@@@@@@@@%@@@@@*====*%%:         
         .-------=++*%#%%%%%#%#%%%%%@@@@@@@@@@@@%=====*%%#.        
        :=-------=+*%%%##%%#%#%%%%%@@@@@@@@@@@@%*=====*%%%+        
        +-------=+#%%%#%%%%#%%%@@@@@#==%@@@@@%%%+=====%%%:         
                 .#@%%%%%%@@%%%@@@*.    %@@@%%##%#%%@@@@#:         
               .=%@@@@%@@%#%%%%@@%:     %@@@%%%%%%%%@%%%%+.        
              .+%%%%%%@@%%%%%%@@@+       *@@@@%%%%%%#%@%%%-        
              #%%%@@@@@@@@@@@@@@        .:@@@@@%%###%%@@@@%.       
              .+@@@@@@@@@@@@%%%@#        :%%%@%%@@@@@@@@@##:       
               .+%%%%%%%%%%@@@@=         .-*%@@@@@@%%%%%#::        
                -=+*%#**#@@*:.               .*%%%##*+==-          
               ...::--==+=.                   ==+==----::.         
               :-:.:==**=                      :======..:.         
               :::::-==                          =*=-:::-:         
              .::::-=:                           .-+=:::::.        
              :::::-:                             :===:...:        
              =:::=:                               ::++=*#*        
            :*%%%@:                                  *%%##%#-.     
          :*##%%#%-                                  =%%%##%%%+.   
          =*##***#=                                  :=+++=====-   
                                                                    
                                                                    
                """;
    }

    private static String getEvilKaiArt() {
        return """
                         :      :                           
                      +..-%%@@%*==                          
                  .- =+*%@%=*%=%@=:                         
                  -%%@@@@%*@%#@*%%*%                        
                :*#@@@*%@@@=@@#*+%@:                        
                =#=*=:%%=:@++@@+@@%#=::                     
                 @#@@##=%%@@@%@:@@@@=+*                     
                .:%@+:@*@%:**=@:%*#@@@-::                   
                 %+@%*%  @@@%@@%@@++%=  -                   
               *-:@@@:-   : -%@*%@@=@@-===:  .:-=.          
                %@%@@ @%. :@ %@%+=@@+@@%%*+=@%-**%          
              :=*=@@@@%@@@  #%@@@@@@%#@@@@@@@@@@@=:-        
              +%@@@=+@ :   @@@*@@%*@@@*=*@@%+=*@@#@:=*=:    
             %*=@@@%%@   @@@@@-=***#*%@@@@@@@@@-=@=@@=++    
            *#@@*=*+=@ .@%%*@@@@%@%%#**%%**@@@@*@%@==*#     
          **%@*%@*#*@@@@@****+=@+**%@#%#%@@*===*@@@@@@@=    
         ===+@ #=@@@@@@@@=***+=@=**%@+#%%+@=:  #@@@@@%+@.   
       @%=%+@@*@:.**#@@@@@%#*@@@+++%@***@##    =@%@@@@=@::  
      -===@@@@@@@@=.***+*+**@@@@@@@@***@@@@@%==:-%@@@@*::   
     #@@@@+*#@@@@@@@:-@###**@%%@@@=@*#*++#%#%@   @%@@@-%    
    %===%@@@@@@%  @#%@ =@@@@@@%@%**%##+%@@@@@@@@:%@@@=      
   ==%@@@@@=   @. #@@@@@-- =@@@%%*%**+%@@@@*+*+@=++@*       
   +*#*++#  @@          @@%=  @@@@%@@@@@@@@+#%%%@@ -:.::    
   @@**#%@ @.            =@@= @@@@@@@@@#*+*%%%%#++          
   +%@@@@* @%  @@@@@@@@@    @*-**      @@@@##*++@@          
  =++%@@+    @@@@@@@@@@@@@@@@#@@%  ...%% :@%%@@@@+#         
 #***@@@@@@@                      :  -%@% @%*@@@@@+=        
 @@#%@##%%% @@@: @@:    =@@*:==     @%  - @@@%%@@@%=        
%@@**+*%@@  @#   @@@@  @@@@@@@@@@@@@##@    @@#@@@@#*        
*#**@@     @%@@@ @@@@@@@@##@@%@@*%*@@**%@ @@#*****+*        
+=*%      %%%%@@@@@@@@@%%%%%%%%@+==@ %@: :+ @**+*##+        
         %%%%@%%@@@@%#%@%%%@%@%@@@@@@ @@@:%%   @@+*=        
         %%@%@%%@@*@%%%@@%%%%@%@@@%%%@@ @@. -@              
         %%@%@%%@@*@@%%@@%%@%@@%@@%%%%%  @@**+-             
         %%@%@%%@@#%@%%%@@#%@%%@%@@@%%%    @@:==            
        @#%%@@%%%@%%@@%%%@@%%@@@%@%@@@%     @%= ..          
        @#%%@@%%%@@#@@%%%%@@%%@%@%@@@%@@      @@=:%         
        @#@%@@%%%@@*@@@%@%%@@%%@@@@%@%%#@       @* :        
        @#@%@@%%%@@%%@@%%%%@@%%@@@@@%@@%#@       @*=--      
        %%@%@@%%#@@%#@@@%@@%@@%%@%%@@@%%%@%%      @@==*     
        %%@%@@%@%@@@#@@@@%%%%@@#%@@@%@@%%@@*#@      @%.-    
        @%%#@@%@#@@@%@@@@%@@%%@@%%%@@%@@%%@@%%%%     @@::   
        @%@%@@%@%@@@%%@@@@%@@%%@@%%%@@@@@%@@%%%%%%    @@:-= 
       %@%%%@@%@%%@@%%@@@@@%%@%%@@@#%@@%@%@@%@@@%%#@    @=-*
       @@@%%@@%%%%@@%%@@@@@@%@@%#@@@%%%@%%%@%@@@%@%%%    @= 
      %%#@%%@%%@@#@@@%%@@@@@%%@@%%@@@%%@@@%%@@@@@@@%%%%   @%
     %%%%@#%@@%@@%@@@%%@@@@@@%%@@%%@@@%%%@@@%%@@@@@%%%%%    
     %%%%@%@@@%@@%@@@%%@@@@@@@%@@@%%@@@@%%%@%@%@@%%@@@@%*   
    %%@@%@%@@@%@%%@@@%%@@@@@%@@%@@@%%@@@@%%%@@%%%%@@%%#     
   @%@@@%@@@@@%@@%%@@%%@@@@@@%@%%@@@@%@@@@%%%%%%@@@@%       
  @%%@@@@%%@@@%@@%%@@@%@@@@@@#@@%%@@@%%@@@@%#@@@@%%         
  %@%@@@@%@@@@%@@@%@@@%%@@@@@%%@@%@@@@@%@@@@@@%%@#          
 *%##%%@@%@@@%%@@@%@@@%@@@@@@%%%@@%@@@@@%#%@                
     %%#*%@%@@@@@@@@@@**%%@@@%#*#@@@@@@%                    
             %  .=-:       #@%                              
         @@@+      :               @@@ @@@@                 
             :@@:                                           
       =-:::=%*%@@@@@                                      
                """;
    }

}
