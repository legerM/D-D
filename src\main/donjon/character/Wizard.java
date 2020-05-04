package donjon.character;

public class Wizard extends Character{

	private Weapon_wizard weapon;

	public Wizard(String heroName, int hP, int pP,Weapon_wizard weapon) {
		super(heroName,hP,pP);
		this.weapon = weapon;

	}

}