package donjon.character;

public class Weapon_wizard {
	String spellName;
	int spellDmgs;
	String philterName;
	int philterDmgs;
	public Weapon_wizard(String spellName, int spellDmgs,String philterName,int philterDmgs){
		this.spellName = spellName;
		this.spellDmgs = spellDmgs;
		this.philterName=philterName;
		this.philterDmgs = philterDmgs;
		
	}
	// Getter 
	public String getSpell(){
		return spellName;
	}
	public int getSpellDmgs() {
		return spellDmgs;
	}
	public String getPhilterName() {
		return philterName;
		
	}
	public int getPhilterDmgs() {
		return philterDmgs;
	}

	// Setter 
	
	public void setspell(String newSpell) {
		this.spellName = newSpell;
		
	}
	
	public void setSpellDmgs(int newSpellDmgs) {
		this.spellDmgs = newSpellDmgs;
	}
	
	public void setPhilterName(String newPhilterName) {
		this.philterName = newPhilterName;
	}
	public void setPhilterDmgs(int newPhilterDmgs) {
		this.philterDmgs = newPhilterDmgs;
	}
}
