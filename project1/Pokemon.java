import java.util.ArrayList;

abstract class Pokemon{
	public String Name;
	public String Type;
	public String HP;
	public String attack1;
	public String attack2;
	public String attack3;
	
	public Pokemon( String Name, String Type, String HP, String attack1, String attack2, String attack3){
		this.Name = Name;
		this.Type = Type;
		this.HP = HP;
		this.attack1 = attack1;
		this.attack2 = attack2;
		this.attack3 = attack3;
	}
	
	public String getName(){
		return Name;
	}
	
	public String getType(){
		return Type;
	}
	
	public String getHP(){
		return HP;
	}
	
	public String getAttack1(){
		return attack1;
	}
	
	public String getAttack2(){
		return attack2;
	}
	
	public String getAttack3(){
		return attack3;
	}
	
	abstract public String toString();
}
