package poker_simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Poker_simulator 
{

	public static void main(String[] args) 
	{
		//Declaring variables
		//String arrays are used to make a deck of 52 cards
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"}; 
		String[] ranks = {"Ace", "2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King"};
		
		String card_one;   //first rejected card
		String card_two; 	//second rejected card
		String card_three; 	//third rejected card
		String decision = "";   //user decision, reject- none, some or all
		int remove_count = 0;   //count of how many cards user wants to remove
		int reject_count2 = 0;	//counts how many are actually removed
		String[] cardsSorted = new String [5]; 	//cards that user currently has
		String[] suitValue = new String [5];   	//holds the suit of the card
		int[] rankValue = new int [5]; 			//holds the rank of the card
		ArrayList<String> card_holder = new ArrayList<String>(); //holds 52 cards

		//Declaring a Scanner Object
		Scanner input = new Scanner (System.in);

////////////////Assigning cards and shuffling////////////////
		for (int i = 0; i < 13; i++)
		{
			for(int j = 0; j < 4;j++)
			{
				String temp = "";
				temp = ranks[i] + " " + suits[j];
				card_holder.add(temp);
			}
		}

		//randomly orders/shuffles the cards
		Collections.shuffle(card_holder);

/////////////////Output for the first five cards/////////////
		System.out.println("Welcome to Poker Simulator!");
		System.out.println("Your cards:");
		for(int i = 0; i < 5; i++)
		{
			System.out.println(card_holder.get(i));
		}
		System.out.println();

		//User decision regarding the cards- do-while loop for Invalid Input
		do {

			System.out.println("What would you like to do? Reject none,some,or all of the cards? ");
			decision = input.nextLine();
			decision = decision.toLowerCase();

			if(decision.equals("all"))
			{
				cardsSorted = card_sorting(card_holder, 5 ,10); //returns array of sorted cards
				suitValue = face_value(cardsSorted); 			  //suit value of each card
				rankValue = card_value(cardsSorted);  			 //rank value of each card

				//poker hand being displayed
				poker_hand(suitValue, rankValue);

			}

/////////Assigning new cards based on user decision////////
			else if(decision.equals("some"))
			{

				//user input for how many cards he/she wants to reject
				while (reject_count2 != 1 && reject_count2 != 2 && reject_count2 != 3)
				{
					System.out.println("How many cards do you want to reject?");
					String reject_count = input.nextLine();

					//if the input is valid
					if(reject_count.equals("1") || reject_count.equals("2") || reject_count.equals("3"))
					{
						reject_count2 = Integer.parseInt(reject_count);
					}

					//if input is not valid
					if ((reject_count2 != 1 && reject_count2 != 2 && reject_count2 != 3))
					{
						System.out.println("Please enter 1, 2 or 3");
					}
				}
				System.out.println("Please write the full name of the " + reject_count2 + " cards you want to reject.");

////////////////////////1 NEW CARD////////////////
				if(reject_count2 == 1)
				{
					do {
						//input for what card user does not want
						System.out.println("Enter the card:");
						card_one = input.nextLine();

						//checks to see if the card exists in the cards that the user currently has 
						for(int i = 0;i < 5;i++)
						{
							if(card_holder.get(i).equals(card_one))
							{
								remove_count++;
							}
						}

						//shows the new card if the user entered the name correctly
						if(remove_count == 1)
						{
							System.out.println();
							System.out.println("Your new card: " +card_holder.get(5));
							System.out.println();
						}

						//removes the card user doesn't want
						for(int i = 0;i < 5;i++)
						{
							if(card_holder.get(i).equals(card_one))
							{
								card_holder.remove(i);
							}
						}

						//invalid input check
						if(remove_count !=1)
						{
							System.out.println("INVALID INPUT!");
						}
					}while (remove_count != 1);

					cardsSorted = card_sorting(card_holder, 0 ,5);  //returns array of sorted cards
					suitValue = face_value(cardsSorted); 			 //suit value of each card
					rankValue = card_value(cardsSorted);  			//rank value of each card

					for(int i =0; i <5; i++)
					{
						System.out.println(cardsSorted[i]);
					}

					//poker hand being displayed
					poker_hand(suitValue, rankValue);
				}

//////////////////////////////2 NEW CARDS//////////////////////
				else if(reject_count2 == 2)
				{
					do {
						//input for what cards user does not want
						System.out.println("Enter the first card:");
						card_one = input.nextLine();
						System.out.println("Enter the second card:");
						card_two = input.nextLine();

						//checks to see if the card exists in the cards that the user currently has 
						for(int i = 0;i < 5;i++)
						{
							if(card_holder.get(i).equals(card_one) || card_holder.get(i).equals(card_two))
							{
								remove_count++;
							}
						}

						//shows the new cards if the user entered the name correctly
						if(remove_count == 2)
						{
							System.out.println("Your new card: " +card_holder.get(5));
							System.out.println("Your new card: " +card_holder.get(6));
							System.out.println();
						}

						//removes the cards user doesn't want
						for(int i = 0;i < 5;i++)
						{
							if(card_holder.get(i).equals(card_one) || card_holder.get(i).equals(card_two))
							{
								card_holder.remove(i);
								i--;
							}
						}

						//Invalid Input check
						if(remove_count !=2)
						{
							System.out.println("INVALID INPUT!");
						}
					}while (remove_count != 2);

					cardsSorted = card_sorting(card_holder, 0 ,5);  //returns array of sorted cards
					suitValue = face_value(cardsSorted); 			 //suit value of each card
					rankValue = card_value(cardsSorted);  			//rank value of each card

					for(int i =0; i <5; i++)
					{
						System.out.println(cardsSorted[i]);
					}

					//poker hand being displayed
					poker_hand(suitValue, rankValue);
				}
////////////////////////////3 NEW CARDS///////////////////////////
				else if(reject_count2 == 3)
				{
					do {
						//input for what cards user does not want
						System.out.println("Enter the first card:");
						card_one = input.nextLine();
						System.out.println("Enter the second card:");
						card_two = input.nextLine();
						System.out.println("Enter the third card:");
						card_three = input.nextLine();

						//checks to see if the card exists in the cards that the user currently has 
						for(int i = 0;i < 5;i++)
						{
							if(card_holder.get(i).equals(card_one) || card_holder.get(i).equals(card_two) || card_holder.get(i).equals(card_three) )
							{
								remove_count++;
							}
						}

						//shows the new cards if the user entered the name correctly
						if(remove_count == 3)
						{
							System.out.println("Your new card: " +card_holder.get(5));
							System.out.println("Your new card: " +card_holder.get(6));
							System.out.println("Your new card: " +card_holder.get(7));
							System.out.println();
						}

						//removes the cards user doesn't want
						for(int i = 0;i < 5;i++)
						{
							if(card_holder.get(i).equals(card_one) || card_holder.get(i).equals(card_two) || card_holder.get(i).equals(card_three))
							{
								card_holder.remove(i);
								i--;
							}
						}

						//Invalid Input check
						if(remove_count !=3)
						{
							System.out.println("INVALID INPUT!");
						}
					}while (remove_count != 3);

					cardsSorted = card_sorting(card_holder, 0 ,5);  //returns array of sorted cards
					suitValue = face_value(cardsSorted); 			 //suit value of each card
					rankValue = card_value(cardsSorted);  			//rank value of each card

					for(int i =0; i <5; i++)
					{
						System.out.println(cardsSorted[i]);
					}

					//poker hand being displayed
					poker_hand(suitValue, rankValue);
				}
			}
///////////////////////////NO NEW CARDS//////////////////////////////
			else if(decision.equals("none"))
			{
				cardsSorted = card_sorting(card_holder, 0 ,5);  //returns array of sorted cards
				suitValue = face_value(cardsSorted); 			 //suit value of each card
				rankValue = card_value(cardsSorted);  			//rank value of each card

				System.out.println();


				//poker hand being displayed
				poker_hand(suitValue, rankValue);

			}
			//Invalid Input check
			else
			{
				System.out.println("Enter a valid input - none, some, all");
			}

		}while(!decision.equals("some")  && !decision.equals("none") && !decision.equals("all"));
	}




	//creates a string array and then sorts the cards 
	private static String[] card_sorting(ArrayList<String> array, int start_index, int end_index) 
	{
		String[] newArrangment = new String [5]; //holds the cards

		//creates the string array of first five cards from the array of 52 cards - user selects none, some
		if(start_index!=5)
		{
			for(int i = start_index ; i < end_index  ;i++)
			{	
				newArrangment[i] = array.get(i);
			}
		}

		////creates the string array of the next five cards from the array of 52 cards- user selected all
		else if(start_index==5)
		{
			int x = 0;
			while ( x < 5)
			{
				newArrangment[x] =  array.get(start_index);
				x++;
				start_index++;
			}
			for(int i = 0; i< 5; i++)
				System.out.println(newArrangment[i]);
		}

		//sorts the array
		Arrays.sort(newArrangment);

		return newArrangment;

	}

	//creates a string array of suits for each card and then sorts the array 
	private static String[] face_value(String[] cards) 
	{
		String temp = ""; //holds the suits
		int test = 0;       //index for making a substring
		String[] suitValue = new String [5]; //array that holds the suit value

		for(int i =0 ; i < 5; i++)
		{
			test = cards[i].indexOf(" "); //index of space
			temp = cards[i].substring(test+1); //suit value of each card from array of sorted cards 

			suitValue[i] = temp;// assigning to suits array
		}

		//sorts the suits in order
		Arrays.sort(suitValue);

		return suitValue;

	}

	//rank value of each card and the sorts the array
	private static int[] card_value(String[] cards) 
	{
		String temp = ""; //holds the rank
		int test = 0; 		//index for making a substring
		int[] rankValue = new int [5]; //array that holds the rank value

		for(int i =0 ; i < 5; i++)
		{
			test = cards[i].indexOf(" "); //index of space
			temp = cards[i].substring(0,test); //rank value of each card from array of sorted cards 

			//order of Jack, Queen, King and Ace in the rank
			if(temp.equals("Jack"))
			{
				rankValue[i] = 11;
			}
			else if(temp.equals("Queen"))
			{
				rankValue[i] = 12;
			}
			else if(temp.equals("King"))
			{
				rankValue[i] = 13;
			}
			else if(temp.equals("Ace"))
			{
				rankValue[i] = 14;
			}
			else
			{
				//if not Jack, Queen, King or Ace, convert the string value of the rank to int
				rankValue[i] =Integer.parseInt(temp);
			}
		}

		//sorts the rank value
		Arrays.sort(rankValue);

		return rankValue;
	}

	//poker hand display
	private static void poker_hand(String[] suitValue, int[] rankValue) 
	{

		int[] tempArray = new int[5]; //temporary array for straight hand
		boolean isStraight = false;	//true is the hand is straight

		//Assigning temp Array
		for(int i = 0; i < 5;i++)
		{
			tempArray[i] = rankValue[i];
		}
		Arrays.sort(tempArray); //Sorts temp
		if(tempArray[4] == 14 && tempArray[0] == 2) //Ace can precede 2 or follow a king
		{
			tempArray[4] = 1;	//if 2 is there make Ace = 1
			Arrays.sort(tempArray); //sorts the arrray
		}

		int counter = 0; //counter for consecutive value
		for(int i = 0; i < 4;i++)
		{
			////checks if the rank value of each card is in consecutive order
			if(tempArray[i] + 1 == tempArray[i+1])
			{
				counter++;
			}
		}
		//if they are all in order
		if (counter == 4)
		{
			isStraight= true;
		}

		//Royal flush- uses the best possible ranking from 10 - 14 so from 10 - Ace
		if(rankValue[0] == 10 && rankValue[4] == 14)
		{
			int count = 0;
			for(int i = 0; i < 4;i++)
			{
				//checks if the rank value of each card is in consecutive order
				if(rankValue[i] + 1 == rankValue[i+1])
				{
					count++;
				}
			}
			//if they are all in order
			if (count == 4)
			{
				System.out.println();
				System.out.println("You have a ROYAL FLUSH!");
			}

		}

		//Straight Flush- if all the suit values are the same
		else if(suitValue[0].equals(suitValue[4]))
		{
			int count = 0;
			for(int i = 0; i < 4;i++)
			{
				////checks if the rank value of each card is in consecutive order
				if(rankValue[i] + 1 == rankValue[i+1])
				{
					count++;
				}
			}
			//if they are all in order
			if (count == 4)
			{
				System.out.println();
				System.out.println("You have a STRAIGHT FLUSH!");
			}
		}

		//if four suits are the same
		else if(suitValue[0].equals(suitValue[3]) ||suitValue[1].equals(suitValue[4]))
		{
			System.out.println();
			System.out.println("You have a Four of  a Kind!");
		}

		//Full house if there are three cards of the same suit + two cards of the same suit but different from the other three
		else if (suitValue[0].equals(suitValue[1]) && suitValue[1].equals(suitValue[2]) && suitValue[0].equals(suitValue[2]) && suitValue[3].equals(suitValue[4]))
		{
			System.out.println();
			System.out.println("You have a Full House!");
		}

		//Flush if all the suits are the same
		else if(suitValue[0].equals(suitValue[4]))
		{
			System.out.println();
			System.out.println("It is a FLUSH!!");
		}

		//Straight
		else if(isStraight== true)
		{
			System.out.println();
			System.out.println("You have a Straight!");
		}
		//if three suits are the same
		else if(suitValue[0].equals(suitValue[2]) ||suitValue[1].equals(suitValue[3]) ||suitValue[2].equals(suitValue[4]))
		{
			System.out.println();
			System.out.println("You have a three of a kind!");
		}

		//if two cards with the same suit value+ two cards of the same suit value of different suit from the other two
		else if(suitValue[0].equals(suitValue[1]) && suitValue[2].equals(suitValue[3]) || suitValue[0].equals(suitValue[1]) && suitValue[3].equals(suitValue[4]) ||suitValue[1].equals(suitValue[2]) && suitValue[3].equals(suitValue[4]) )
		{
			System.out.println();
			System.out.println("You have two pairs!");
		}

		//if two cards have the same suit
		else if(suitValue[0].equals(suitValue[1]) || suitValue[1].equals(suitValue[2]) || suitValue[2].equals(suitValue[3]) ||suitValue[3].equals(suitValue[4]))
		{
			System.out.println();
			System.out.print("You have One pair");
		}

	}
}
