import java.util.Scanner;

class PokemonConsoleUi{
	public void ConsoleUserInterface(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nPlease choose a Pokemon.\n1. List Pokemon \n2. Add Pokemon\n3. Remove Pokemon\n4. Reset\n5. Exit\n");
		
		int user = input.nextInt();
		PokemonList pokedex = new PokemonList();
		
		while(user != 5){
			
			if(user == 1){
				pokedex.PokemonList();
			System.out.print("\nPlease choose a Pokemon.\n1. List Pokemon \n2. Add Pokemon\n3. Remove Pokemon\n4. Reset\n5. Exit\n");
			user = input.nextInt();
			} else if(user == 2){
					System.out.print("Enter Pokemon's name.");
					Scanner in = new Scanner (System.in);
					String Name = in.nextLine();
					System.out.println("Enter the Pokemon's type.");
					String Type = in.nextLine();
					System.out.println("Enter the Pokemon's HP.");
					String HP = in.nextLine();
					System.out.println("Enter the Pokemon's Attack 1.");
					String attack1 = in.nextLine();
					System.out.println("Enter the Pokemon's Attack 2.");
					String attack2 = in.nextLine();
					System.out.println("Enter the Pokemon's Attack 3.");
					String attack3 = in.nextLine();
					
					pokedex.addPokemon(new Pokemons(Name, Type, HP, attack1, attack2, attack3));
					System.out.print("\nPlease choose a Pokemon.\n1. List Pokemon \n2. Add Pokemon\n3. Remove Pokemon\n4. Reset\n5. Exit\n");
					user = input.nextInt();
				}
				else if(user == 3){
					System.out.println("Please choose an pokedex number to remove.");
					int index = input.nextInt();
					pokedex.removePokemon(index);
					System.out.print("\nPlease choose a Pokemon.\n1. List Pokemon \n2. Add Pokemon\n3. Remove Pokemon\n4. Reset\n5. Exit\n");
					user = input.nextInt();
					
				}
				else if(user == 4){
					pokedex.reset();
					System.out.print("\nPlease choose a Pokemon.\n1. List Pokemon \n2. Add Pokemon\n3. Remove Pokemon\n4. Reset\n5. Exit\n");
					user = input.nextInt();
				}
				else{
					break;
			}
		}
		System.out.println("Go be the very best, that no one has ever known!");
	}
	
}