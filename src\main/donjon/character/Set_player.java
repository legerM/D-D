package donjon.character;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 *
 * @author mickaell
 *@
 */
public class Set_player{
	private ArrayList<Character>character = new ArrayList<Character>();

	private Scanner sc = new Scanner(System.in);

	public void set_player_character() {
		startGame();

	}
	private void startGame() {
		char choiceUser=0;

		//        /-------------------Demande	de choix entre les classes des personnages--------------\	

		while (choiceUser != 'q') {
			System.out.println("(C)réation de héro \n(M)odifier un Personnage \n(S)upprimer un personnage \n(L)ister les personnages \n(Q)uitter le jeu \n ");

			choiceUser = sc.next().charAt(0);
			sc.nextLine();


			if (choiceUser == 'q') {
				System.exit(0);
			}

			//			/-----------------appel des fonction d'initialisation de personnages pour le guerrier ou le mage----------------------\
			if (choiceUser == 'c') {
				while(choiceUser != '1' && choiceUser != '2') {
					System.out.println("Veuillez choisir 1 pour le Guerrier ou 2 pour le Mage ou (Q)uitter et revenir au menu principal ");
					choiceUser = sc.next().charAt(0);
					sc.nextLine();
					if (choiceUser == '1') {
						createWarrior();	
					}

					else if (choiceUser == '2') {
						createWizard();
					}
					if (choiceUser == 'q') {
						startGame();
					}
				}
			}
			//              /-------------------------------Affichage des personnages en mémoire--------------------------\	

			else if (choiceUser == 'l') {
				champ_listing();

			}

			///------------------------ verification de la bonne entrée utilisateur -----------------------\		

			while(choiceUser != '1' && choiceUser != '2' && choiceUser != 'l'  && choiceUser != 'q') {
				startGame();
			}
		}



	}




//              /-------------------------------Fonction qui Affiche des personnages en mémoire--------------------------\	

private void champ_listing( ) {
	System.out.println("quelle classe de personnage voulez vous ? tapez 1 pour warrior ou 2 pour mage " );
	int choice = sc.nextInt();
	if(choice == 1) {
		if (character==(null)) {
			System.out.println("il n'y pas encore de personnages ! Veuillez en créer un ! \n ");
			startGame();
		}
		else {
			for (int i = 0 ;i<character.size();i++) {
				System.out.println(character.get(i));

			}
		}
	}

	else if (choice == 2) {
		if (character.isEmpty()) {
			System.out.println("il n'y pas encore de personnages !Veuillez en créer un  \n ");
			startGame();
		}
		else {
			for (int i = 0 ;i<character.size();i++){
				System.out.println(character.get(i));
			}
		}
	}
}

private void changeStatPlayer(Character hero) {
	String setChoice;
	String newName;
	int newStat;
	setChoice = askForString("Voulez modifier certaines statistique de votre personnage ? O / N ");
	if (setChoice.equals("o")) {
		String setStat=askForString("que voulez vous modifier ? ");
		if(setStat.equals("name")) {
			newName = askForString("quel est le nouveau nom ?");
			hero.setName(newName);
		}
		else if (setStat.equals("hp")) {
			newStat=askForInt("quel est la nouvelle statistique ?");
			hero.setLifePoint(newStat);
		}
		else if (setStat.equals("pp")) {
			newStat=askForInt("quel est la nouvelle statistique ?");
			hero.setPowerPoint(newStat);
		}
		else if (setStat.equals("weapon")) {
			newName = askForString("quel est le nouveau nom ?");
			hero.setWeapon(newName);
		}
		else if (setStat.equals("weapon dmgs")) {
			newStat=askForInt("quel est la nouvelle statistique ?");
			hero.setWeaponDmgs(newStat);
		}
		else if (setStat.equals("protection")) {
			newName = askForString("quel est le nouveau nom ?");
			hero.setshieldName(newName);
		}
		else if (setStat.equals("protection dmgs")) {
			newStat=askForInt("quel est la nouvelle statistique ?");
			hero.setShieldDmgs(newStat);
		}
	}
}



private int askForstats(String question,int stat,int statMin,int statMax) {
	while(true) {

		System.out.println(question);
		try {
			stat = sc.nextInt();
			if(stat >= statMin && stat <= statMax) {
				sc.nextLine();
				return stat;
			}
			else {
				System.out.println("Valeur invalide ");
			}
		}catch(InputMismatchException e ) {
			System.out.println(" Error : (Veuillez entrer un entier )");
		}
		sc.nextLine();

	}
}

private  String askForString(String question) {
	while(true) {
		System.out.println(question);
		String answer ;
		try {
			answer = sc.nextLine();
			return answer ;

		}catch (NoSuchElementException e) {
			System.out.println("Error : (Veuillez entrer un texte )");
		}

	}
}



private int askForInt(String question) {
	System.out.println(question);
	int answer= 0;
	try {
		answer = sc.nextInt();
		sc.nextLine();
	}catch(InputMismatchException e) {
		System.out.println("Error : (Veuillez entrer un entier)");
	}
	return answer;
}


//             /------------------initialise le mage et le stocke dans la liste des personnages---------------\

private void createWizard( ) {
	int HP = 0;
	int PP = 0;
	String heroName;
	String spellName;
	String philterName;
	int spellDmgs=0;
	int philterDmgs=0;
	heroName = askForString("veuillez entrer le nom du Héro");
	HP = askForstats("Veuillez entrer vos HP entre 3 et 6 ",HP,3,6);
	PP = askForstats("Veuillez entrer vos PP entre 8 et 15 ",PP,8,15);
	spellName = askForString("Veuillez entrer le sort que vous utiliserez");
	spellDmgs = askForstats("Veuillez entrer les dmgs de votre sort entre 8 et 15 ",spellDmgs,8,15);
	philterName = askForString("Veuillez entrer le Nom de votre filtre de defense");
	philterDmgs = askForstats("Veuillez entrer la defense de votre filtre entre 8 et 15 ",philterDmgs,8,15);
	Wizard champion = new Wizard(heroName,HP,PP,spellName,spellDmgs,philterName,philterDmgs);
	wizard_description(heroName,HP,PP,spellName,spellDmgs,philterName,philterDmgs);
	String answer = askForString("voulez-vous modifier votre personnage ? ");
	if (answer.contentEquals("oui")) {
		changeStatPlayer(champion);
		character.add(champion);
	}
	if (answer.contentEquals("non")) {
		System.out.println("sauvegarde de votre Hero");
		character.add(champion);
	}
}





//              /------------------initialise le guerrier et le stocke dans la liste des personnages---------------\

private void createWarrior() {
	int HP = 0;
	int PP = 0;
	String heroName ;
	String weaponHero;
	String shieldName ;
	int dmgWeapon = 0;
	int shieldDmg = 0;
	heroName = askForString("veuillez entrer le nom du Héro");
	HP = askForstats("Veuillez entrer vos HP entre 5 et 10 ",HP,5,10);
	PP = askForstats("Veuillez entrer vos PP entre 5 et 10 ",PP,5,10);
	weaponHero = askForString("Veuillez entrer le l'arme que vous utiliserez");
	dmgWeapon = askForstats("Veuillez entrer les dmgs de votre arme entre 5 et 10 ",dmgWeapon,5,10);
	shieldName = askForString("Veuillez entrer le Nom de votre bouclier");
	shieldDmg = askForstats("Veuillez entrer la defense de votre bouclier entre 5 et 10 ",shieldDmg,5,10);
	//		Weapon_warrior weapon = new Weapon_warrior(weaponHero,dmgWeapon,shieldName,shieldDmg);
	Warrior champion = new Warrior(heroName,HP,PP,weaponHero,dmgWeapon,shieldName,shieldDmg);
	warrior_description(heroName,HP,PP,weaponHero,dmgWeapon,shieldName,shieldDmg);
	String answer = askForString("voulez-vous modifier votre personnage ? ");
	if (answer.contentEquals("oui")) {
		changeStatPlayer(champion);
		character.add(champion);
	}
	if (answer.contentEquals("non")) {
		System.out.println("sauvegarde de votre Hero");
		character.add(champion);
	}

}






//                                 /-------------Fonction pour la description du Guerrier----------------\	
private	void warrior_description(String heroName,int HP,int PP, String weaponHero,int dmgWeapon,String shieldName,int shieldDmg) {
	System.out.println("Vous vous appelez \n "+heroName+"\n"+" vos HP sont de : "+HP+"HP \n "+" vos PP sont de :"+PP+" \n"+
			" votre arme est :\n "+weaponHero+ " \n"+" qui fait : "+dmgWeapon+" dgms\n "+"et votre bouclier "+shieldName+" vous de defends de : "+shieldDmg);

}




//                                /-------------Fonction pour la description du Mage----------------\	

private void wizard_description(String heroName,int HP,int PP,String spellName,int spellDmgs,String philterName,int philterDmgs) {
	System.out.println("Vous vous appelez \n "+heroName+"\n"+" vos HP sont de : "+HP+"HP \n "+" vos PP sont de :"+PP+" \n"+
			" votre sort est :\n "+spellName+ " \n"+" qui fait : "+spellDmgs+" dgms\n "+"et votre philtre de défense "+philterName+" vous de defends de : "+philterDmgs);
}



}