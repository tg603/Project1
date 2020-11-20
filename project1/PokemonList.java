import java.util.ArrayList;
class PokemonList{

ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();

	public PokemonList(){
		pokedex.add(new Pokemons("Pikachu", "\tElectric", "\b40", "Gnaw", "Quick Attack", "\b\bThunder Jolt"));
		
		pokedex.add(new Pokemons("Charmander", "Fire", "40", "Scratch", "Ember", "Flare\t"));
		
		pokedex.add(new Pokemons("Squirtle", "Water", "40", "Bubble", "Withdraw", "\bShell Attack"));

		pokedex.add(new Pokemons("Bulbasaur", "Grass", "40", "Leech Seed", "\bRazor Leaf", "\b\bBullet Seed"));

	}
	
	public void PokemonList(){
		System.out.println("Index\tName\t\tType\t\tHP\tattack1\t\tattack2\t\tattack3");
		for (int i = 0; i < pokedex.size(); i++){
			if(pokedex.get(i) instanceof Pokemons){
				System.out.println("" + i + "" + pokedex.get(i));
			}
		}
	}
	
	public void removePokemon(int index){
		pokedex.remove(index);
		PokemonList();
	}
	
	public void addPokemon(Pokemon newPokemon){
		pokedex.add(newPokemon);
		PokemonList();
	}
	
	public void reset(){
		pokedex.clear();
		pokedex.add(new Pokemons("Pikachu", "\tElectric", "\b40", "Gnaw", "Quick Attack", "\b\bThunder Jolt"));
		
		pokedex.add(new Pokemons("Charmander", "Fire", "40", "Scratch", "Ember", "Flare\t"));
		
		pokedex.add(new Pokemons("Squirtle", "Water", "40", "Bubble", "Withdraw", "\bShell Attack"));

		pokedex.add(new Pokemons("Bulbasaur", "Grass", "40", "Leech Seed", "\bRazor Leaf", "\b\bBullet Seed"));
		PokemonList();
	}
	
}