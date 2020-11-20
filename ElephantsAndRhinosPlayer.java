import java.lang.*;
import java.io.*;
import java.util.*;

/**
* Fill this in later with a description of your player's strategy.
*
* @author Zach 'TG' Thoroughgood
*/

public class ElephantsAndRhinosPlayer extends Player<ElephantsAndRhinos>{

/**
*
*@param ElephantsAndRhinosPlayer() 
* Empty Constructor
*/
	public ElephantsAndRhinosPlayer(){

//Line 15 - 46 into main method();
		
	}
	
	
/**
*
*@param toString()
*Returns the value for the players name
*@return String of player name
*
*/
	public String toString(){
		//returning name of my player
		return "TG";
	}
	
/**
* 
*@param getMove()
*Returns a move based on whether the player is left or right
*@return A valid move based off of Left or Right position
*/
	
	public ElephantsAndRhinos getMove(ElephantsAndRhinos position, int playerId){
		ArrayList<String> spaces = position.getSpaces();
		
		if (playerId == CombinatorialGame.LEFT){
			//move the first elephant
			ArrayList<Integer> elephants = moveableElephants(position);
			int first = elephants.get(0);
			spaces.set(first, ElephantsAndRhinos.EMPTY);
			spaces.set(first+1, ElephantsAndRhinos.ELEPHANT);
		}else if(playerId == CombinatorialGame.RIGHT){
			//move the first rhino
			ArrayList<Integer> rhinos = moveableRhinos(position);
			int first = rhinos.get(0);
			spaces.set(first, ElephantsAndRhinos.EMPTY);
			spaces.set(first-1, ElephantsAndRhinos.RHINO);
		}else{
			System.out.println("Error!");
		}
		return new ElephantsAndRhinos(spaces);
		
	}
	
	/**
	* Returns position The game state that is being checked.
	*
	* @param position The game state that is being checked.
	* @param index The index of the space on the board, starting from 0 and going left-to-right.
	* @return True if there is an elephant in the indexeth space of position; false otherwise.
	*/
	
	public static boolean hasElephantAt(ElephantsAndRhinos position, int index){
		ArrayList<String> spaces = position.getSpaces();
		String checker = spaces.get(index);
		if(checker.contains(ElephantsAndRhinos.ELEPHANT)){
			System.out.println("Elephant is inside index " + index + "!");
			return true;
		}else{
		boolean hasElephant = checker.equals(ElephantsAndRhinos.ELEPHANT);
		return false;
		}
		
	}
	
		public static boolean hasRhinoAt(ElephantsAndRhinos position, int index){
		ArrayList<String> spaces = position.getSpaces();
		String checker = spaces.get(index);
		if(checker.contains(ElephantsAndRhinos.RHINO)){
			System.out.println("Rhino is inside index " + index + "!");
			return true;
		}else{
		boolean hasRhino = spaces.equals(ElephantsAndRhinos.RHINO);
		return false;
		}
	}
	
	
		public static boolean  hasPachydermAt(ElephantsAndRhinos position, int index){
			ArrayList<String> spaces = position.getSpaces();
			if(hasRhinoAt(position, index) == true){
				return true;
			}else if(hasElephantAt(position, index) == true){
					return true;
				}
				else{
					System.out.println("No Pachyderm was found inside index " + index + "!");
				return false;
			}
		}
		
		public static boolean elephantCanMove(ElephantsAndRhinos position, int index){
			int check = index + 1;
			if(hasElephantAt(position, index) == true && hasRhinoAt(position, check) == false && hasElephantAt(position, check) == false ){
				System.out.println("Elephant can move to " + check + " for a legal move.");
				return true;
			}
			return false;
		}
		
			public static boolean rhinoCanMove(ElephantsAndRhinos position, int index){
				int check = index - 1;
		if(hasRhinoAt(position, index) == true && hasRhinoAt(position, check) == false && hasElephantAt(position, check) == false){
			System.out.println("Rhino can move to " + check + " for a legal move.");
			return true;
		}
		return false;
	}
	
	
	/**
	* @param index The index of the space.  Precondition: the indexeth space must contain either an elephant or a rhino.
	*/
		
		public static boolean pachydermCanMove(ElephantsAndRhinos position, int index){
			if(elephantCanMove(position, index) == true){
				elephantCanMove(position, index);
				return true;
			}else if(rhinoCanMove(position, index) == true ){
				//rhinoCanMove(position, index);
				return true;
			}
			return false;
		}
		
		//This method took soooooo long to figure out
		//Just about ripped my hair out interchanging the parts I knew for this method
		//Reviewed the API atleast 5 times
		//Finally figured out the logic of this after 2 hours of trial/error
		public static ArrayList<Integer> moveableElephants(ElephantsAndRhinos position){
			ArrayList<Integer> length = new ArrayList<Integer>();
			ArrayList<String> spaces = position.getSpaces();
			String l;
			String p;

			//int m = spaces.size();
			
				for(int i = 0; i < spaces.size() - 1; i++){
					l = spaces.get(i);
					p = spaces.get(i + 1);

					if(l.contains(ElephantsAndRhinos.ELEPHANT) && p.contains(ElephantsAndRhinos.EMPTY)){
						length.add(i);
						//return length;
					}
					/*
					else if(m n){
						return length;
					}
					*/
					
				}
			
			
			/*
		if(spaces.contains(ElephantsAndRhinos.ELEPHANT)){
			//int index = spaces.indexOf("E");
			return length;
		}
			*/
			return length;
		}

		public static ArrayList<Integer> moveableRhinos(ElephantsAndRhinos position){
			ArrayList<Integer> length = new ArrayList<Integer>();
			ArrayList<String> spaces = position.getSpaces();
			String l;
			String p;
			
				for(int i = 1; i < spaces.size() - 1; i++){
					l = spaces.get(i);
					p = spaces.get(i - 1);

					if(l.contains(ElephantsAndRhinos.RHINO) && p.contains(ElephantsAndRhinos.EMPTY)){
						length.add(i);
					}
					
				}
			return length;
		}
		

			public static void main(String[] args){
			
			ArrayList<String> pachyderms = new ArrayList<String>();
			pachyderms.add(ElephantsAndRhinos.EMPTY);
			pachyderms.add(ElephantsAndRhinos.ELEPHANT);
			pachyderms.add(ElephantsAndRhinos.RHINO);
			pachyderms.add(ElephantsAndRhinos.ELEPHANT);
			ElephantsAndRhinos game = new ElephantsAndRhinos(pachyderms);
			boolean hasElephant = ElephantsAndRhinosPlayer.hasElephantAt(game, 3);
			System.out.println(pachyderms);
			
			
		//Tests for the methods
		if(hasElephant == true){
			System.out.println("Successful");
		}
		else{
			System.out.println("failure");
		}

		boolean hasRhino = ElephantsAndRhinosPlayer.hasRhinoAt(game, 2);
		System.out.println(pachyderms);
		if(hasRhino == true){
			System.out.println("Successful");
		}
		else{
			System.out.println("failure");
		}

		//Tests the first index == False no pachyderms
		boolean hasPachyder = ElephantsAndRhinosPlayer.hasPachydermAt(game, 0);
		System.out.println(pachyderms);
		if(hasPachyder == true){
			System.out.println("Successful");
		}
		else{
			System.out.println("Failure");
		}

		//Tests the second index == True elephant pachyderm
		boolean hasPach = ElephantsAndRhinosPlayer.hasPachydermAt(game, 1);
		System.out.println(pachyderms);
		if(hasPach == true){
			System.out.println("Successful");
		}
		else{
			System.out.println("Failure");
		}
		//Tests the third index == True rhino pachyderms
		boolean hasPachy = ElephantsAndRhinosPlayer.hasPachydermAt(game, 2);
		System.out.println(pachyderms);
		if(hasPachy == true){
			System.out.println("Successful");
		}
		else{
			System.out.println("Failure");
		}



		//New Arraylist for further testing
		ArrayList<String> pachyderma = new ArrayList<String>();
		pachyderma.add(ElephantsAndRhinos.EMPTY);
		pachyderma.add(ElephantsAndRhinos.ELEPHANT);
		pachyderma.add(ElephantsAndRhinos.EMPTY);
		pachyderma.add(ElephantsAndRhinos.RHINO);
		ElephantsAndRhinos games = new ElephantsAndRhinos(pachyderma);
		//Tests whether elephant can move
		boolean hasPac = ElephantsAndRhinosPlayer.elephantCanMove(games, 1);
		System.out.println(pachyderma);
		if(hasPac == true){
			System.out.println("Successful");
		}
		else{
			System.out.println("Failure");
		}

		//Tests instance of an Elephant
		boolean hasP = ElephantsAndRhinosPlayer.pachydermCanMove(games, 1);
		System.out.println(pachyderma);
		if(hasP == true){
			System.out.println("Successful");
		}
		else{
			System.out.println("Failure");
		}


		ArrayList<String> pp = new ArrayList<String>();
		pp.add(ElephantsAndRhinos.EMPTY);
		pp.add(ElephantsAndRhinos.ELEPHANT);
		pp.add(ElephantsAndRhinos.EMPTY);
		pp.add(ElephantsAndRhinos.RHINO);
		pp.add(ElephantsAndRhinos.ELEPHANT);
		pp.add(ElephantsAndRhinos.EMPTY);
		ElephantsAndRhinos gamer = new ElephantsAndRhinos(pp);


		ArrayList <Integer> hasEle = ElephantsAndRhinosPlayer.moveableElephants(gamer);
		System.out.println(hasEle);

		ArrayList <Integer> hasRhin = ElephantsAndRhinosPlayer.moveableRhinos(gamer);
		System.out.println(hasRhin);

	}
}
