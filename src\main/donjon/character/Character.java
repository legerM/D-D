package donjon.character;

public class Character{
	private String name ;
	private int lifePoint;
	private int powerPoint;
	private String weaponName;
	private int weaponDmgs;
	private String shieldName;
	private int shieldDmgs;
	Character(String name,int hp, int pp,String weaponName,int weaponDmgs,String shieldName,int shieldDmgs){

		this.name=name;
		this.lifePoint=hp;
		this.powerPoint=pp;
		this.weaponName=weaponName;
		this.weaponDmgs=weaponDmgs;
		this.shieldName=shieldName;
		this.shieldDmgs=shieldDmgs;
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
	public String getWeapon(){
		return weaponName;
	}
	public int getWeaponDmgs() {
		return weaponDmgs;
	}
	public String getshieldName() {
		return shieldName;
		
	}
	public int getShieldDmgs() {
		return shieldDmgs;
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
	public void setWeapon(String newWeapon) {
		this.weaponName = newWeapon;
		
	}
	
	public void setWeaponDmgs(int newWeaponDmgs) {
		this.weaponDmgs = newWeaponDmgs;
	}
	
	public void setshieldName(String newshieldName) {
		this.shieldName = newshieldName;
	}
	public void setShieldDmgs(int newShieldDmgs) {
		this.shieldDmgs = newShieldDmgs;
	}
}