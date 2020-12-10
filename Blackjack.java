import java.util.Scanner;

	import java.util.Random;
	import java.util.Scanner;

	public class Blackjack {
		public static void main(String[] args) {
// WELCOME SCREEN
			System.out.println("Welcome to BlackJack!");
			System.out.println("-------------------------");
			System.out.println("");
			System.out.println("_____________    ____________");
			System.out.println("|K           |  |Q           |");
			System.out.println("|<3          |  |<>          |");
			System.out.println("|            |  |            |");
			System.out.println("|            |  |            |");
			System.out.println("| Welcome to |  | Blackjack! |");
			System.out.println("|            |  |            |");
			System.out.println("|         <3 |  |          <>|");
			System.out.println("|          K |  |           Q|");
			System.out.println("|____________|  |____________|");
			System.out.println("");
			
			Scanner keyboard = new Scanner(System.in);
			int numPlayers = 0;
			BlackjackMethods cards = new BlackjackMethods();
			int playCount = 0;
			int count = 1;
			
//ASK HOW MANY PLAYERS AND STORE THE VALUE IN AN INT
			do
			{
				String numberOfPlayers = "";
				System.out.println("How many players are playing? (1 or 2)");
				numberOfPlayers = keyboard.nextLine();
				if (numberOfPlayers.equals("1")) 
				{
					numPlayers = 1;
				}
				else if (numberOfPlayers.equals("2"))
				{
					numPlayers = 2;
				}
				else 
				{
					System.out.println("Invalid input. Please enter a 1 or a 2!");
				}
				System.out.println("-------------------------");
				System.out.println("");
			}
			while (numPlayers == 0);
			
			
//INITIALIZE EACH PLAYER'S BALANCE TO $1000 AND STORE IN AN ARRAY
			double[] balance = new double [numPlayers];
			for (int x = 1; x <= numPlayers; x++)
			{
				System.out.println("Player " + x + " Balance = $10000");
				balance[x-1] = 10000;
				System.out.println("");
				
			}
			System.out.println("-------------------------");
			System.out.println("");
			
//GAME STARTS			
			String playAgain = "yes";
			while(playAgain.equals("yes"))
			{
			int dealtCards = 0;
// ASK FOR EACH PLAYER'S BET
			double[] playerBet = new double [numPlayers];
			for (int x = 1; x <= numPlayers; x++)
			{
				boolean playerBetString2 = false;
				
				do 
				{
					String playerBetString = "";
					if(count > 0)
					System.out.println("Player " + x + ", please enter a bet between $2 and $500");
					playerBetString = keyboard.nextLine();
					if(playCount > 0)
					{
						count++;
					}
					BlackjackMethods playerBetString1 = new BlackjackMethods();
					playerBetString2 = playerBetString1.isInteger(playerBetString);
					
					if (playerBetString2 == true)
					{	
						int tempPlayerBet = Integer.parseInt(playerBetString);
	
						if (tempPlayerBet >= 2 && tempPlayerBet <= 500)
						{
							playerBet[x-1] = tempPlayerBet;
						}
						else
						{
							playerBetString2 = false;
						}
					}						
					System.out.println("");	
				}
				while (playerBetString2 == false);
			}
			
			System.out.println("-------------------------");
			System.out.println("");
							
//DECLARE AND INITIALIZE SUITS AND RANKS
				String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
				String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "10 (Jack)", "10 (Queen)", "10 (King)", "11 (Ace)"};
			   

//INITIALIZE DECK
			    int n = SUITS.length * RANKS.length;
			    String[] deck = new String[n];
			    for (int i = 0; i < RANKS.length; i++) 
			    {
			    	for (int j = 0; j < SUITS.length; j++) 
			    	{
			    		deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
			    	}
			    }

//SHUFFLE DECK
			     for (int i = 0; i < n; i++) 
			     {
			    	 int r = i + (int) (Math.random() * (n-i));
			    	 String temp = deck[r];
			         deck[r] = deck[i];
			         deck[i] = temp;
			     }
			  
// DECLARE AND INITIALIZE WITH "0" AN ARRAY OF ARRAYS TO HOLD EACH PLAYERS + DEALERS HANDS
			     String[] player1 = new String[11];
			     String[] player2 = new String[11];
			     String[] dealer = new String[11];
			     String[][] hands = new String[][] {player1, player2, dealer};
			     
			     for (int x = 0; x <= numPlayers; x++)
			     {
			    	 for (int k = 0; k < 11; k++)
			    	 {
			    		 hands[x][k] = "0";
			    	 }
			     }
			     
//ASSIGN A CARD FOR EACH HAND FROM THE TOP OF THE DECK
			     for (int t = 0; t <= numPlayers; t++)
			     {		    	 
			    	 hands[t][0] = deck[dealtCards++];
			    	 
			     } 
		     
//PRINT EACH HAND TO CONSOLE
			     for (int x = 1; x <= numPlayers; x++)
			     {
			    	 System.out.println("Player " + x + "'s First Card: ");
			    	 //cards.printCard(hands[x-1][0]);
			    	 cards.printCard2(hands, x-1, 0, numPlayers);
			    	 System.out.println("-------------------------");
					 
			     }
			     System.out.println("Dealer's First Card: ");
//Error checking System.out.println(hands[numPlayers][0]);
			     cards.printCard("Hidden");

// BREAK BEFORE SEEING THE SECOND CARD OF EACH HAND
			     System.out.println("-------------------------");
			     System.out.println("");
			     System.out.println("Enter anything to show next cards");
//SDEDBJ
			     String sheDidntEvenDoBlackjack = keyboard.next();
			     
//ASSIGNMENT + PRINT SECOND CARD OF EACH HAND TO THE CONSOLE    
			     for (int t = 0; t <= numPlayers; t++)
			     {
			    	 hands[t][1] = deck[dealtCards++];
			     } 
			     System.out.println("-------------------------"); 
			     System.out.println("");
//PRINT SECOND CARD TO CONSOLE
			     for (int x = 1; x <= numPlayers; x++)
			     {
			    	 System.out.println("Player " + x + "'s Second Card: ");
			    	 cards.printCard2(hands, x-1, 1, numPlayers);
			     }
			     System.out.println("Dealer's Second Card: ");
			     cards.printCard2(hands, numPlayers, 1, numPlayers);   
// CHANGE EACH STRING VALUE OF CARDS INTO INT VALUES
			     int[] player1handsvalue = new int[11];
			     int[] player2handsvalue = new int[11];
			     int[] dealerhandsvalue = new int[11];
			     int[][] handsvalues = new int[][] {player1handsvalue, player2handsvalue, dealerhandsvalue};
			     
			     for (int x = 0; x <= numPlayers; x++)
			     {
			    	String var = hands[x][0].substring(0,hands[x][0].indexOf(" "));
			    	handsvalues[x][0] = Integer.parseInt(var.trim());
			    	String var2 = hands[x][1].substring(0,hands[x][1].indexOf(" "));
			    	handsvalues[x][1] = Integer.parseInt(var2.trim());
			    	if( handsvalues[x][1] == 11 &&  handsvalues[x][0] == 11)
			    	 {
			    		handsvalues[x][1] = 1;
			    		System.out.println("Ace #2 is counted as 1");
			    	 }
			     } 

			     System.out.println("-------------------------");
			     System.out.println("");
			     
			     int [] totals = new int[numPlayers + 1];
			     totals[numPlayers] = handsvalues[numPlayers][0] + handsvalues[numPlayers][1];
			     if (totals[numPlayers] == 21)

//DEALER BLACKJACK CHECK	    	 
			     {
		    		 System.out.println("Dealer has blackjack.");
		    		 for(int r = 0; r<numPlayers; r++)
		    		 {
		    			 totals[r] = handsvalues[r][0] + handsvalues[r][1];
		    			 System.out.println("Player " + (r+1) + " Cards: " + hands[r][0] + " and " + hands[r][1]);	
		    			 System.out.println("Total: " + totals[r]);
		    			 if (totals[r] != 21)
		    			 {
		    				 balance[r] = balance[r] - playerBet[r];
		    				 System.out.println("Player " + (r+1) + " loses $" + playerBet[r]);
		    				 System.out.println("Balance: $" + balance[r]);
		    				 System.out.println("-------------------------");
		    			 }
		    			 else
		    			 {
		    				 System.out.println("Player " + (r+1) +" ties the dealer, keeps bet");
		    				 System.out.println("");
		    			 }
		    		 }
		    	 }
//PLAYER BLACKJACK CHECK
			     
			     int[] playerSkipped = new int[numPlayers];     
			     for(int p = 0; p < numPlayers; p++)
			     {
			    	 totals[p] = handsvalues[p][0] + handsvalues[p][1];
			    	 if (totals[p] == 21 && totals[numPlayers] != 21)
			    	 {
			    		 System.out.println("Player " + (p+1) + " has blackjack.");
			    		 playerSkipped[p] = 1;
			    		 playerBet[p] = playerBet[p] + playerBet[p]*1.5;
			    		 System.out.println("Wins $" + playerBet[p]);
			    		 System.out.println("-------------------------");
			    		 System.out.println("");
			    	 }
			     }
//PLAYER TURNS BEGIN
			     if(totals[numPlayers] != 21)
			     {
			    	 for (int x = 0; x <= numPlayers; x++)
				     { 
				    	 totals[x] = handsvalues[x][0] + handsvalues[x][1];
				    	 if (x != numPlayers && playerSkipped[x] != 1)
				    	 {
					    	 System.out.println("PLAYER " + (x+1) + " TURN: ");
					    	 System.out.println("");
					    	 System.out.print("Your Cards: " + hands[x][0] + " and ");
					    	 System.out.println(hands[x][1]);
					    	 System.out.print("Total: ");
					    	 
					    	 System.out.println(totals[x]);
					    	 System.out.println(" ");
				    	 }
				    	 else
				    	 {
				    		 if(x != numPlayers)
				    		 {
				    			 continue;
				    		 }
				    		 else
				    	 	 {
				    			 break;
				    		 }
				    	 }
//DOUBLE DOWN		
				    	 
				    	 String doubleDown = "";
			
						 while (!((totals[x] == 21) || (doubleDown.equals("yes")) || (doubleDown.equals("no"))))
							{
								System.out.println("Double Down? ('Yes' or 'No')");
								doubleDown = keyboard.next().toLowerCase();
								System.out.println("");
							}
				    	 
				    	 String hitOrStand = "";
				    	 
				    	 if (doubleDown.equals("yes"))
				    	 {
				    		 
				    		 playerBet[x] = playerBet[x]*2;
				    		 System.out.println("Your bet is doubled to $" + playerBet[x]);
				    		 System.out.println("-------------------------");
				    		 System.out.println("");
				    		 hitOrStand = "hit";
				    	 }
//HIT OR STAND			    	 	    	 
				    	 for(int e = 0; e<11;e++)
				    	 {
				    		 
					    	 while (!( hitOrStand.equals("hit") || hitOrStand.equals("stand")))
					    	 {
					    		 if(totals[x] == 21)
					    		 {
					    			 hitOrStand = "stand";
					    		 }
					    		 else
					    		 {
					    			 System.out.println("'Hit' or 'Stand'?");
					    			 hitOrStand = keyboard.next().toLowerCase();
					    			 System.out.println("");
					    		 }
					    		 
					    	 }
					    	 
					    	 if (hitOrStand.equals("hit"))
					    	 {
					    		 hands[x][e+2] = deck[dealtCards++];
					    	     String var = hands[x][e+2].substring(0,hands[x][e+2].indexOf(" "));
					    	     handsvalues[x][e+2] = Integer.parseInt(var.trim());
					    	    
					    	  
					    	     if(e == 0)
					    	     {
					    	    	 System.out.println("Player " + (x+1) + "'s Cards Are: " + hands[x][0] + ", "+ hands[x][1] + ", " + hands[x][2]);
					    	     }
					    	     else
					    	     {
					    	    	 System.out.println("New Card: " + hands[x][e+2]);
					    	     }
					    	     totals[x] = totals[x] + handsvalues[x][e+2];
					    	     
//ACE CHECK :(
					    	     
					    	    // totals[x] cards.aceCheck(handsvalues, e, x, totals);  
					    	     
					    	     if (totals[x] > 21)
					    	     {
					    	    	 totals[x] = cards.aceCheck(handsvalues, e, x, totals);
					    	    	 
					    	    	 if((handsvalues[x][e+2] != 11) && (handsvalues[x][1] != 11) && (handsvalues[x][0] != 11))
//BUST CHECK					    	    	 
					    	    	 {
						    	    	 if (totals[x] > 21)
					    	    		 {
						    	    		 System.out.println("New Total: " + totals[x] + " (BUST!)");
						    	    		 
						    	    		 System.out.println("Lost Bet: $" + playerBet[x]);
						    	    		 
					    	    		 
						    	    		 System.out.println("-------------------------");
						    	    		 System.out.println("");
						    	    		 break;
					    	    		 }
					    	    	 }
					    	     }
					    	     else
					    	     {
					    	    	 System.out.println("New Total: " + totals[x]);
					    	    	 System.out.println("-------------------------");
					    	     }
					    	     hitOrStand = "";
					    	     if (doubleDown.equals("yes"))
					    	     {
					    	    	 break;
					    	     }
					    	 }
					    	 if (hitOrStand.equals("stand") || totals[x] == 21)
					    	 {
					    		// System.out.println("-------------------------");
					    		 System.out.println("");
					    		 e = 11;
					    	 }
				     }
				}
			    int skip = 0;
			    if(numPlayers == 2)
			    {
			    	if(totals[0] > 21 && totals[1] > 21)
			    	{
			    		skip = 1;
			    		balance[0] = balance[0] - playerBet[0];
			    		balance[1] = balance[1] - playerBet[1];
			    		System.out.println("Player 1 balance: " + balance[0]);
			    		System.out.println("Player 2 balance: " + balance[1]);
			    	}
			    }
			    if(numPlayers == 1)
			    {
			    	if(totals[0] > 21)
			    	{	
			    		skip = 1;
			    		balance[0] = balance[0] - playerBet[0];
			    		System.out.println("Player 1 balance: " + balance[0]);
			    	}
			    }
//DEALER HAND
			   if(skip != 1)
			   {
					System.out.println("Dealer's Cards: " + hands[numPlayers][0] + ", " + hands[numPlayers][1]);
					System.out.println("Total: " + totals[numPlayers]);
					System.out.println("");
					System.out.println("-------------------------");
					System.out.println("");
					System.out.println("Enter anything to show next cards");
//FAS :(
					String FAS = keyboard.next();
					System.out.println("-------------------------");
					System.out.println("");
					if(totals[numPlayers] < 17)
					{
						while (totals[numPlayers]<17)
						{
							hands[numPlayers][2] = deck[dealtCards++];
				   	     	String var = hands[numPlayers][2].substring(0,hands[numPlayers][2].indexOf(" "));
				   	     	handsvalues[numPlayers][2] = Integer.parseInt(var.trim());
				   	     	totals[numPlayers] = totals[numPlayers]+handsvalues[numPlayers][2];
				   	        System.out.println("Dealer's Next Card: " + hands[numPlayers][2]);
//ACE CHECK
				   	        if (totals[numPlayers] > 21)
				   	        {
				   	        	totals[numPlayers] = cards.aceCheck(handsvalues, 0, numPlayers, totals);
				   	        	
//BUST CHECK
				    	    	if((handsvalues[numPlayers][2] != 11) && (handsvalues[numPlayers][1] != 11) && (handsvalues[numPlayers][0] != 11))
				    	    	 
				    	    	{
					    	    	 if (totals[numPlayers] > 21)
				    	    		 {
					    	    		 System.out.println("New Total: " + totals[numPlayers] + " (BUST!)");
					    	    		 System.out.println("-------------------------");
					    	    		 System.out.println("");
					    	    		 break;
				    	    		 }
				    	    	}
				    	     }
				   	        if (totals[numPlayers] > 21)
				   	     	{
				   	     	System.out.println("New Total: " + totals[numPlayers] + "(BUST)");
				   	     	}
				   	     	else
				   	     	{
				   	     		System.out.println("New Total: " + totals[numPlayers]);
				   	     	}
						}
					}
			   }
			   
//DETERMINE A WINNER
			   if(skip != 1)
			   {
				   if(totals[numPlayers] >= 17)
					{
						if(totals[numPlayers] <= 21)
						{
							System.out.println("Dealer Stays at " + totals[numPlayers]);
							System.out.println("");
							int[] winners = new int[numPlayers];
							String playerWinners = "no";
							for (int g = 0; g < numPlayers; g++)
							{
								if (totals[g] > totals[numPlayers] && totals[g] <= 21)
								{
									winners[g] = 1;
									playerWinners = "yes";
								}
								if(winners[g] == 1 && totals[g] != totals[numPlayers])
								{
									System.out.println("Player " + (g+1) + " wins $" + playerBet[g]);
									balance[g] = balance[g] + playerBet[g];
									System.out.println("Balance: $" + balance[g]);
									System.out.println("");
								}
								if(winners[g] == 0 && totals[g] != totals[numPlayers])
								{
									System.out.println("Player " + (g+1) + " loses $" + playerBet[g]);
									balance[g] = balance[g] - playerBet[g];
									System.out.println("Balance: $" + balance[g]);
									System.out.println("");
								}
								if(totals[g] == totals[numPlayers] && totals[g] <=21)
								{
									System.out.println("Player " + (g+1) + " ties with Dealer");
									System.out.println("Player " + (g+1) + " keeps $" + playerBet[g]);
									System.out.println("Balance: $" + balance[g]);
									System.out.println("");
								}
							}
						}
						else
						{
							System.out.println("Dealer busts");
							System.out.println("");
							for (int u = 0; u < numPlayers; u++)
							{
								if(totals[u] <=21)
								{
									System.out.println("Player " + (u+1) + " wins $" + playerBet[u]);
									balance[u] = balance[u] + playerBet[u];
									System.out.println("Balance: $" + balance[u]);
									System.out.println("");
								}
								else
								{
									System.out.println("Player" + (u+1) + " loses $" + playerBet[u]);
									balance[u] = balance[u] - playerBet[u];
									System.out.println("Balance: $" + balance[u]);
									System.out.println("");
								}
							}
						}
					}
			   }
			  
			}
//PLAY AGAIN?	 
			     count = 0;
			     System.out.println("-------------------------");
			     System.out.println("");
			     boolean allowPlayAgain = true;
			     for(int w = 0; w < numPlayers; w++)
			     {
			    	 if (balance[w] < 2)
			    	 {
			    		 allowPlayAgain = false;
			    	 }
			     }
			     if(allowPlayAgain == true)
			     {
			    	 do
				     {
				    	 System.out.println("Play Again? ('yes' or 'no')");
				    	 playAgain = keyboard.next().toLowerCase();
				    	 if (playAgain.equals("yes"))
				    	 {
				    		 playCount++;
				    	 }
				    	 else
				    	 {
				    		 System.out.print("Thanks for playing!");
				    	 }
				     }
				     while
				    	 (!(playAgain.equals("yes") || playAgain.equals("no")));
			     }
			     else
			     {
			    	 System.out.println("No more balance. Thanks for playing, addict!");
			    	 playAgain = "No";
			     }
			     
			     
		}
		
	}
			
		     
}
	

