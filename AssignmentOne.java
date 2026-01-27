package griffith;
import java.util.Random;
import java.util.Scanner;

public class AssignmentOne {
	public static final String RESET = "\033[0m";
	public static final String YELLOW = "\033[0;33m";
	public static final String BLUE = "\033[0;34m";
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Please select your character kai and evilkai");
		String character=scanner.nextLine();


		String Kai = """
				                                 ..                                 \r
				                                  +*                                \r
				                                   ##:                              \r
				                                    %%-                             \r
				                                     %#:                            \r
				                                     :@*.                           \r
				                                      =#=                           \r
				                                       *@:                          \r
				                                       :%%.                         \r
				                                        -%*                         \r
				                                         *%-                        \r
				                                         .%*.                       \r
				                                          -%-                       \r
				                                          .**.                      \r
				                                           =%=                      \r
				                                  .         *%:                     \r
				                                  .+::====: -%+.                    \r
				                                .+#%*%%%#**- %%-                    \r
				                                *%%@@%%@%%##=+%+.                   \r
				                               :%%%%%%%@%%@##=*%:                   \r
				                               %%=-:::=*#*%%%*=%*.                  \r
				                             =@%*-:::-#**##%@%:*%:                  \r
				                             .:%%+**::=#+:=%%#.=@*                  \r
				                               :*:::-:.=*=%**=.:#%:                 \r
				                              :-:-:::::::*#:    *%+                 \r
				                             --. -+::-:-**::  . *%*=:               \r
				                           :=*%**%%@@%#@%%-:.. .=%-::               \r
				                          .=*+=***=*@%#%%%**+*=::::-:.              \r
				                          *%%**#+%%%%***#***#*=::::::.              \r
				                         .*@#***%%%%%@%%@%##@@#=-:*%=.              \r
				                       .:++%+*#%%@@@%%%%%%@@@@%==::%*.              \r
				                       .:+*%%+%@@@@%%%%%@@@@@@@%#*=%%:              \r
				                       :*#%@@%%%@@@@@@@@@%%%@#%%+=%%%=              \r
				                     .*=*+%%*+=+****##%%@@@@@%**===%%+              \r
				                   .-*%@@%*=====***#%%@%%@@**@**===%*===-           \r
				                  -%%%%%%#***#%@@@@@%@%#@@@%%%%*==%%%%+===.         \r
				                 .-------=%%###%#***=+-::=--=:+%*%%%%%%#+++         \r
				                        -%%%###*-:::.==::-:-=##%%#%%%%@%**:         \r
				                      .=%%###%@@@@@@@@@@@@@@@@%%#*#@%%%%*:          \r
				                    :-=***#*#%%%@@@@@@@@@@@@@@@@%#*%@#-:::          \r
				                  .:+******%%%%%@@@@@@@@@@@@@@@@%#**#===::          \r
				                  -+=+****%%%%%%@@@@@@@@@@@@@@%%%%#%@#=:::-         \r
				                .====****#%%##%@%%@@@@@@@@@@@@@%%@@%%@::==::        \r
				              .-=--==***#%%%#%@%#%@@@@@@@@@@@%@%%@%@@*.--:.         \r
				             =-----=++**%%#%%@%%%%%@@@@@@@@@%%%@%%@%%+.             \r
				           .-------++**%#%%%@%##%%%@@@@@@@@%%#%@@@**%@**.           \r
				          .-------=+**%#%##@%%%%%%%@@@@@@@@%@@@@@*====*%%:          \r
				         .-------=++*%#%%%%%#%#%%%%%@@@@@@@@@@@@%=====*%%#.         \r
				        :=-------=+*%%%##%%#%#%%%%%@@@@@@@@@@@@%*=====*%%%+         \r
				        +-------=+#%%%#%%%%#%%%@@@@@#==%@@@@@%%%+=====%%%:          \r
				                 .#@%%%%%%@@%%%@@@*.    %@@@%%##%#%%@@@@#:          \r
				               .=%@@@@%@@%#%%%%@@%:     %@@@%%%%%%%%@%%%%+.         \r
				              .+%%%%%%@@%%%%%%@@@+       *@@@@%%%%%%#%@%%%-         \r
				              #%%%@@@@@@@@@@@@@@        .:@@@@@%%###%%@@@@%.        \r
				              .+@@@@@@@@@@@@%%%@#        :%%%@%%@@@@@@@@@##:        \r
				               .+%%%%%%%%%%@@@@=         .-*%@@@@@@%%%%%#::         \r
				                -=+*%#**#@@*:.               .*%%%##*+==-           \r
				               ...::--==+=.                   ==+==----::.          \r
				               :-:.:==**=                      :======..:.          \r
				               :::::-==                          =*=-:::-:          \r
				              .::::-=:                           .-+=:::::.         \r
				              :::::-:                             :===:...:         \r
				              =:::=:                               ::++=*#*         \r
				            :*%%%@:                                  *%%##%#-.      \r
				          :*##%%#%-                                  =%%%##%%%+.    \r
				          =*##***#=                                  :=+++=====-    \r
				                                                                    \r
				                                                                    \
				""";
		String evilkai = """
				                         :      :                            \r
				                      +..-%%@@%*==                           \r
				                  .- =+*%@%=*%=%@=:                          \r
				                  -%%@@@@%*@%#@*%%*%                         \r
				                :*#@@@*%@@@=@@#*+%@:                         \r
				                =#=*=:%%=:@++@@+@@%#=::                      \r
				                 @#@@##=%%@@@%@:@@@@=+*                      \r
				                .:%@+:@*@%:**=@:%*#@@@-::                    \r
				                 %+@%*%  @@@%@@%@@++%=  -                    \r
				               *-:@@@:-   : -%@*%@@=@@-===:  .:-=.           \r
				                %@%@@ @%. :@ %@%+=@@+@@%%*+=@%-**%           \r
				              :=*=@@@@%@@@  #%@@@@@@%#@@@@@@@@@@@=:-         \r
				              +%@@@=+@ :   @@@*@@%*@@@*=*@@%+=*@@#@:=*=:     \r
				             %*=@@@%%@   @@@@@-=***#*%@@@@@@@@@-=@=@@=++     \r
				            *#@@*=*+=@ .@%%*@@@@%@%%#**%%**@@@@*@%@==*#      \r
				          **%@*%@*#*@@@@@****+=@+**%@#%#%@@*===*@@@@@@@=     \r
				         ===+@ #=@@@@@@@@=***+=@=**%@+#%%+@=:  #@@@@@%+@.    \r
				       @%=%+@@*@:.**#@@@@@%#*@@@+++%@***@##    =@%@@@@=@::   \r
				      -===@@@@@@@@=.***+*+**@@@@@@@@***@@@@@%==:-%@@@@*::    \r
				     #@@@@+*#@@@@@@@:-@###**@%%@@@=@*#*++#%#%@   @%@@@-%     \r
				    %===%@@@@@@%  @#%@ =@@@@@@%@%**%##+%@@@@@@@@:%@@@=       \r
				   ==%@@@@@=   @. #@@@@@-- =@@@%%*%**+%@@@@*+*+@=++@*        \r
				   +*#*++#  @@          @@%=  @@@@%@@@@@@@@+#%%%@@ -:.::     \r
				   @@**#%@ @.            =@@= @@@@@@@@@#*+*%%%%#++           \r
				   +%@@@@* @%  @@@@@@@@@    @*-**      @@@@##*++@@           \r
				  =++%@@+    @@@@@@@@@@@@@@@@#@@%  ...%% :@%%@@@@+#          \r
				 #***@@@@@@@                      :  -%@% @%*@@@@@+=         \r
				 @@#%@##%%% @@@: @@:    =@@*:==     @%  - @@@%%@@@%=         \r
				%@@**+*%@@  @#   @@@@  @@@@@@@@@@@@@##@    @@#@@@@#*         \r
				*#**@@     @%@@@ @@@@@@@@##@@%@@*%*@@**%@ @@#*****+*         \r
				+=*%      %%%%@@@@@@@@@%%%%%%%%@+==@ %@: :+ @**+*##+         \r
				         %%%%@%%@@@@%#%@%%%@%@%@@@@@@ @@@:%%   @@+*=         \r
				         %%@%@%%@@*@%%%@@%%%%@%@@@%%%@@ @@. -@               \r
				         %%@%@%%@@*@@%%@@%%@%@@%@@%%%%%  @@**+-              \r
				         %%@%@%%@@#%@%%%@@#%@%%@%@@@%%%    @@:==             \r
				        @#%%@@%%%@%%@@%%%@@%%@@@%@%@@@%     @%= ..           \r
				        @#%%@@%%%@@#@@%%%%@@%%@%@%@@@%@@      @@=:%          \r
				        @#@%@@%%%@@*@@@%@%%@@%%@@@@%@%%#@       @* :         \r
				        @#@%@@%%%@@%%@@%%%%@@%%@@@@@%@@%#@       @*=--       \r
				        %%@%@@%%#@@%#@@@%@@%@@%%@%%@@@%%%@%%      @@==*      \r
				        %%@%@@%@%@@@#@@@@%%%%@@#%@@@%@@%%@@*#@      @%.-     \r
				        @%%#@@%@#@@@%@@@@%@@%%@@%%%@@%@@%%@@%%%%     @@::    \r
				        @%@%@@%@%@@@%%@@@@%@@%%@@%%%@@@@@%@@%%%%%%    @@:-=  \r
				       %@%%%@@%@%%@@%%@@@@@%%@%%@@@#%@@%@%@@%@@@%%#@    @=-* \r
				       @@@%%@@%%%%@@%%@@@@@@%@@%#@@@%%%@%%%@%@@@%@%%%    @=  \r
				      %%#@%%@%%@@#@@@%%@@@@@%%@@%%@@@%%@@@%%@@@@@@@%%%%   @% \r
				     %%%%@#%@@%@@%@@@%%@@@@@@%%@@%%@@@%%%@@@%%@@@@@%%%%%     \r
				     %%%%@%@@@%@@%@@@%%@@@@@@@%@@@%%@@@@%%%@%@%@@%%@@@@%*    \r
				    %%@@%@%@@@%@%%@@@%%@@@@@%@@%@@@%%@@@@%%%@@%%%%@@%%#      \r
				   @%@@@%@@@@@%@@%%@@%%@@@@@@%@%%@@@@%@@@@%%%%%%@@@@%        \r
				  @%%@@@@%%@@@%@@%%@@@%@@@@@@#@@%%@@@%%@@@@%#@@@@%%          \r
				  %@%@@@@%@@@@%@@@%@@@%%@@@@@%%@@%@@@@@%@@@@@@%%@#           \r
				 *%##%%@@%@@@%%@@@%@@@%@@@@@@%%%@@%@@@@@%#%@                 \r
				     %%#*%@%@@@@@@@@@@**%%@@@%#*#@@@@@@%                     \r
				             %  .=-:       #@%                               \r
				         @@@+      :               @@@ @@@@                  \r
				             :@@:                                            \r
				       =-:::=%*%@@@@@                                       \s""";

		while(true)
		{
			if (character.equalsIgnoreCase("kai"))
			{
				System.out.println("you have selected");
				System.out.println(BLUE+Kai+RESET);
				break;
			} 
			else if (character.equalsIgnoreCase("evilkai")) {
				System.out.println("you have selected");
				System.out.println(YELLOW+evilkai+RESET);
				break;
			}
			else
			{
				System.out.println("Invalid Input! Please enter kai or eveilkai.");
				character = scanner.next();
			}


		}


		// Define the deck (simplified version with face cards as 10 and Ace as 11 or 1)
		String[] deck = {
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", // Hearts
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", // Diamonds
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", // Clubs
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"  // Spades
		};

		// Shuffling the deck
		shuffleDeck(deck);

		// Dealing two cards to the player and dealer
		String playercard1 = drawcard(deck);
		String playercard2 = drawcard(deck);
		String dealercard1 = drawcard(deck);
		String dealercard2 = drawcard(deck);
		int playertotal = calculatecardvalue(playercard1) + calculatecardvalue(playercard2);
		int dealertotal = calculatecardvalue(dealercard1) + calculatecardvalue(dealercard2);
		System.out.println("Your cards: " + playercard1 + " and " + playercard2 + " | Total: " + playertotal);
		System.out.println("Dealer's visible card: " + dealercard1);
		// Playing as Kai(player turn)
		while (character.equalsIgnoreCase("Kai"))
		{
			dealertotal=0;
			System.out.print("Do you want to hit or stand? hit/stand ");
			String action = scanner.nextLine();
			if (action.equalsIgnoreCase("hit")) 
			{
				String newcard = drawcard(deck);
				playertotal += calculatecardvalue(newcard);
				System.out.println("You drew: " + newcard);
				System.out.println("Your total: " + playertotal);
				if (playertotal > 21) 
				{
					System.out.println("You busted! Dealer wins.");
					System.out.println("Would you like to try again? type yes if you dare");
					String retry = scanner.nextLine();
					if (retry.equalsIgnoreCase("yes"))
					{
						continue;
					} 
					else 
					{
						System.out.println(" _                        \r\n"
								+ "| |    ___  ___  ___ _ __ \r\n"
								+ "| |   / _ \\/ __|/ _ \\ '__|\r\n"
								+ "| |__| (_) \\__ \\  __/ |   \r\n"
								+ "|_____\\___/|___/\\___|_|   ");
						break;
					}
				}
			}

			else if(action.equalsIgnoreCase("stand"))
			{
				while (dealertotal < 17) 
				{
					String newcard = drawcard(deck);  
					dealertotal += calculatecardvalue(newcard);
					System.out.println("Dealer drew: " + newcard);

				}
				System.out.println("Dealer's total: " + dealertotal);
			}
			else 
			{
				break;
			}
			// Determining the winner
			if ((dealertotal > 21 || playertotal > dealertotal)) 
			{
				System.out.println("You win! As a noble samurai");
			} 
			else if (dealertotal == playertotal) 
			{
				System.out.println("It's a tie!");
			} 
			else
			{
				System.out.println("Dealer wins!Better luck next time.You can never become a samurai");
			}
		}
		//Playing as Evil kai
		while (character.equalsIgnoreCase("EvilKai"))
		{ 
			dealertotal=0;
			int stealingused = 0;
			int attemptlimit=(int)(Math.random()*3)+1;
			System.out.print("Select steal or hit or stand ");
			String action = scanner.nextLine();
			//steal dealers card
			if (action.equalsIgnoreCase("steal"))
			{
				if(stealingused<attemptlimit)
				{
					String stolencard = dealercard1;  
					dealertotal -= calculatecardvalue(stolencard);
					playertotal += calculatecardvalue(stolencard);

					System.out.println("You stole the dealer's card: " + stolencard);
					System.out.println("Your new total: " + playertotal + " | Dealer's total: " + dealertotal);
					stealingused++;
					// Chance of getting caught increases each time
					if (Math.random() < 0.25 * stealingused) 
					{
						System.out.println("You've been caught stealing! Evil Kai is banished. Dealer wins!");
						break;
					}
				} 
			}
			else if(action.equalsIgnoreCase("hit"))
			{
				String newcard = drawcard(deck);
				playertotal += calculatecardvalue(newcard);
				System.out.println("You drew: " + newcard);
				System.out.println("Your total: " + playertotal);
				if (playertotal > 21) 
				{
					System.out.println("You busted! Dealer wins.");  
					break;
				}
			}
			else
			{
				    while (dealertotal < 17) 
				{
					String newcard = drawcard(deck);  
					dealertotal += calculatecardvalue(newcard);
					System.out.println("Dealer drew: " + newcard);

				}
				System.out.println("Dealer's total: " + dealertotal);
			}
			// Determines the winner
			if ((dealertotal > 21 || playertotal > dealertotal) ) 
			{
				System.out.println("You win!However, you chose the option to use evilkai's powers to steal. this was a test and you failed.");
				break;
			} 
			else if (dealertotal == playertotal) 
			{
				System.out.println("It's a tie!");
			} else
			{
				System.out.println("Dealer wins!");
			}

		}

	}
	// Method to shuffle the deck
	public static void shuffleDeck(String[] deck) 
	{
		Random card = new Random();
		for (int i = 0; i < deck.length; i++) 
		{
			int j = card.nextInt(deck.length);
			String temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
	}
	/* Method to draw a card from the deck 
	 * picks a random card and removes it
	 */
	public static String drawcard(String[] deck)
	{
		Random card = new Random();
		int cardindex = card.nextInt(deck.length);
		// Keep looping to ensure card is not null
		while (true) 
		{
			// check if card has not been removed
			if (deck[cardindex] != null)
			{
				// stores the card
				String card1 = deck[cardindex];
				// Removes the card by setting it to null 
				deck[cardindex] = null;
				// returns the card
				return card1;
			} 
			else 
			{
				//gets a new card
				cardindex = card.nextInt(deck.length);
			}
		}
	}
	// Method to calculate the card value
	public static int calculatecardvalue(String card1) 
	{
		switch (card1)
		{
		case "A":
			return 11;  // Ace is worth 11 (can be adjusted later to 1)
		case "K": return 10;
		case "Q": return 10;
		case "J": return 10;
		case "10":
			return 10;  // Face cards and 10 are worth 10
		default:
			return Integer.parseInt(card1);  // Number cards (2-9)
		}

	}

}