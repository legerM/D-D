package donjon.character;

public class Warrior extends Character{

	private Weapon_warrior weapon;

	public Warrior(String heroName, int hP, int pP,Weapon_warrior weapon) {
		super(heroName,hP,pP);
		this.weapon = weapon;

	}
	

}