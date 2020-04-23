package poker;
import java.util.Random;

public class poker_class implements Comparable<poker_class>
{
	
	//implements comparable<Card>

	//array for all of the possible faces
	private static String[] faces = {"two", "three", "four", "five", "six", "seven", 
	    "eight", "nine", "ten", "jack", "queen", "king", "ace"};

	//array for all of the possible suits
	private static String[] suits = {"clubs", "diamonds", "hearts", "spades"};

	//variables used for the faces and suits
	private String face;
	private String suit;
	private int faceValue;

	//constructor for card; makes a Two of Clubs for testing purposes
	public poker_class ()
	{
	    face = "Two";
	    suit = "Clubs";
	}

	//deal method; deals a random card
	public void deal()
	{
	    Random generator = new Random();
	    int thisCard = generator.nextInt(52);

	    face = faces[thisCard % 13];
	    suit = suits[thisCard / 13];

	    faceValue = thisCard %13;
	}

	public int getFaceValue()
	{
	    return faceValue;
	}

	public String getFace() 
	{
	    return face;
	}


	public String getSuit() 
	{
	    return suit;
	}

	public String toString()
	{
	    return face  + " of " + suit + "  ";
	}

	public int compareTo(poker_class otherCard)
	    {
	    if (this.faceValue < otherCard.faceValue)
	        return -1;
	    else if (this.faceValue > otherCard.faceValue)
	        return 1;
	    else
	        return 0;
	}

}


