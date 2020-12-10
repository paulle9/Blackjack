
public class BlackjackMethods {
	
/* METHOD #1: isInteger
 * PARAMETER: String
 * RETURN: boolean
 * PURPOSE: to ensure that when the user enters a player bet, that the type of that value is 
 * an integer. If it's an integer, the method will parse the number from the string
 * to convert it into an integer. It will then assign the integer to the appropriate player bet.
 */
	public boolean isInteger (String playerBetString) {
		try {
			Integer.parseInt(playerBetString);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	
/* METHOD #2: printCard
 * PARAMETER: String
 * RETURN: void
 * PURPOSE: print the dealer's first card as "hidden" to the console
 */
	public void printCard (String card)
	{
		 System.out.println("");
		 System.out.println("__________________________");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|         Hidden          |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|                         |");
		 System.out.println("|_________________________|");
		 System.out.println("");
	}
	
/* METHOD #3: printCard2
 * PARAMETER: String 2D array, int, int, int
 * RETURN: void
 * PURPOSE: print the player's card, as well as the dealer's second card, to the console.
 * The method accounts for the card's (1) suit and (2) value. It prints both to the console
 * and prints the text version of the card underneath the visual representation of the card.
 */
	
	public void printCard2 (String[][] hands, int x, int indx, int numPlayers)
	{
		String var = hands[x][indx].substring(0,hands[x][indx].indexOf(" "));

    	if(var.equals("10") || var.equals("11"))
    	{
    		var = hands[x][indx].substring(4,5);
    		if(var.equals("f"))
    		{
    			var = "10";
    		}
    	}
    	
    	String suit = hands[x][indx].substring(hands[x][indx].length()-2);
    	String icon = "";
    	if(suit.equals("ts"))
    	{
    		icon = "<3";
    	}
    	if(suit.equals("ds"))
    	{
    		icon = "<>";
    	}
    	if(suit.equals("bs"))
    	{
    		icon = "o8-";
    	}
    	if(suit.equals("es"))
    	{
    		icon = "<3<";
    	}
		System.out.println("");
		System.out.println("__________________________");
		if(var.equals("10"))
		{
			System.out.println("|" + var + "                     " + var + "|");
		}
		else
		{
			System.out.println("|" + var + "                       " + var + "|");
		}
		
		if (icon.equals("<>") || icon.equals("<3"))
		{
			System.out.println("|" + icon + "                     " + icon + "|");
		}
		else
		{
			System.out.println("|" + icon + "                   " + icon + "|");
		}
		
		System.out.println("|                         |");
		System.out.println("|                         |");
		System.out.println("|                         |");
		System.out.println("|                         |");
		System.out.println("|                         |");
		System.out.println("|                         |");
		System.out.println("|                         |");
		System.out.println("|                         |");
		if (icon.equals("<>") || icon.equals("<3"))
		{
			System.out.println("|" + icon + "                     " + icon + "|");
		}
		else
		{
			System.out.println("|" + icon + "                   " + icon + "|");
		}
		if(var.equals("10"))
		{
			System.out.println("|" + var + "                     " + var + "|");
		}
		else
		{
			System.out.println("|" + var + "                       " + var + "|");
		}
		System.out.println("|_________________________|");
		System.out.println("");
		System.out.println(hands[x][indx]);
		if (x != numPlayers)
		{
			if(indx != 0)
			{
				System.out.println("-------------------------");
			}
		}

		System.out.println("");
	}
	
/* METHOD #4: aceCheck
 * PARAMETER: int 2D array, int, int, int
 * RETURN: int
 * PURPOSE: changes the values of the Ace card from 11 to 1 if having the value of 11 would 
 * cause the player to go over 21. The method will reassign the value of the ace card to 1 
 * where needed.
 */
	public int aceCheck(int[][] handsvalues, int e, int x, int[] totals)
	{
		if(handsvalues[x][e+2] == 11)
   	 	{
   		 handsvalues[x][e+2] = 1;
   		 totals[x] = totals[x] + handsvalues[x][e+2] - 11;
   		 System.out.println("Card #" + (e+3) + " is counted as 1");
   		 System.out.println("");
   		 System.out.println("New Total: " + totals[x]);
   		 System.out.println("-------------------------");
   		 System.out.println("");
   		 return totals[x];
   	 	}
   	 if ((handsvalues[x][1] == 11))
   	 	{
   		 handsvalues[x][1] = 1;
   		 totals[x] = totals[x] + handsvalues[x][1] - 11;
   		 System.out.println("Card #2 is counted as 1");
   		 System.out.println("");
   		 System.out.println("New Total: " + totals[x]);
   		 System.out.println("-------------------------");
   		 System.out.println("");
   		 return totals[x];
   	 	}
   	 if ((handsvalues[x][0] == 11))
   	 	{
   		 handsvalues[x][0] = 1;
   		 totals[x] = totals[x] + handsvalues[x][0] - 11;
   		 System.out.println("Card #1 is counted as 1");
   		 System.out.println("");
   		 System.out.println("New Total: " + totals[x]);
   		 System.out.println("-------------------------");
   		 System.out.println("");
   		 return totals[x];
   	 	 }
	 return totals[x];   	
	}
	
}

