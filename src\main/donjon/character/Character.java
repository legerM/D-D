package donjon.character;

public class Character{
	String name ;
	int lifePoint;
	int powerPoint;
	Character(String name,int hp, int pp){
		this.name=name;
		this.lifePoint=hp;
		this.powerPoint=pp;
	}
	void attack_move(){


	}
	void def_move() {

	}
	public String toString() {
		return " \n Nom du Héro  " + this.name +
				" HP : " + this.lifePoint +
				" PP : " + this.powerPoint ;
	}

	// Getter 
	public String getName(){
		return name;
	}
	public int getLifePoint() {
		return lifePoint;
	}
	public int getPowerPoint() {
		return powerPoint;
	}

	// Setter 
	
	public void setName(String newName) {
		this.name = newName;
		
	}
	
	public void setLifePoint(int newLifePoint) {
		this.lifePoint = newLifePoint;
	}
	
	public void setPowerPoint(int newPowerPoint) {
		this.powerPoint = newPowerPoint;
	}

}