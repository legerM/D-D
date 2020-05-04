package donjon.character;

public class Weapon_warrior {
	String weaponName;
	int weaponDmgs;
	String shieldName;
	int shieldDmgs;

	public Weapon_warrior(String weaponHero, int dmgWeapon,String shieldName2,int shieldDmg){

		this.weaponName = weaponHero;
		this.weaponDmgs = dmgWeapon;
		this.shieldName=shieldName2;
		this.shieldDmgs = shieldDmg;
	}
	// Getter 
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
