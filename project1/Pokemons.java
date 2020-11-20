class Pokemons extends Pokemon{

public String currentHP;

public Pokemons(String Name, String Type, String HP, String attack1, String attack2, String attack3){
	super(Name, Type, HP, attack1, attack2, attack3);
	this.currentHP = currentHP;
}
public String getcurrentHP(){
	return currentHP;
}

@Override
public String toString(){
	return ("\t" + Name + "\t" + Type + "\t\t" + HP + "\t" + attack1 + "\t\t" + attack2 + "\t\t" + attack3 + "\t\t" + currentHP);
}

}