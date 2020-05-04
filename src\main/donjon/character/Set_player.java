package donjon.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Set_player{
	
	char choiceUser;
	
	String heroName;
	String weaponHero;
	String shieldName;
	String spellName;
	String philterName;
	
	int HP;
	int PP;
	int dmgWeapon;
	int shieldDmg;
	int spellDmgs;
	int philterDmgs;

	List<Wizard> select_wizard = new ArrayList<Wizard>();	
	List<Warrior> select_warrior = new ArrayList<Warrior>();
	
	Scanner sc = new Scanner(System.in);
	
	public void set_player_character() {


		//                  /-------------------Demande	de choix entre les classes des personnages--------------\	
		
		while (choiceUser != 'q') {
			System.out.println("Veuillez choisir 1 pour le Guerrier ou 2 pour le Mage, l pour lister les personnages ou q pour quitter ");

			choiceUser = sc.next().charAt(0);
			sc.nextLine();


			if (choiceUser == 'q') {
				System.exit(0);
			}

			//              /-------------------------------Affichage des personnages en mémoire--------------------------\	

			else if (choiceUser == 'l') {
				champ_listing();

			}

			//               /------------------------ verification de la bonne entrée utilisateur -----------------------\		

			while(choiceUser != '1' && choiceUser != '2') {
				System.out.println("Veuillez choisir 1 pour le Guerrier ou 2 pour le Mage, l pour lister les personnages ou q pour quitter");
				choiceUser = sc.next().charAt(0);
				sc.nextLine();
				if (choiceUser == 'q') {
					System.exit(0);
				}
				else if (choiceUser == 'l') {
					champ_listing();
				}
			}


			//			/-----------------appel des fonction d'initialisation de personnages pour le guerrier ou le mage----------------------\

			if (choiceUser == '1') {
				createWarrior();	
			}

			else if (choiceUser == '2') {
				createWizard();
			}
		}

	}



	//              /-------------------------------Fonction qui Affiche des personnages en mémoire--------------------------\	

	private void champ_listing( ) {
		System.out.println("quelle classe de personnage voulez vous ? tapez 1 pour warrior ou 2 pour mage " );
		int choice = sc.nextInt();

		if(choice == 1) {
			if (select_warrior.isEmpty()) {
				System.out.println("il n'y pas encore de personnages ! \n ");
			}
			else {
				for (int i =0 ; i < select_warrior.size();i++) {
					System.out.println(select_warrior.get(i));
				}
			}
		}
		else if (choice == 2) {
			for (int i =0 ; i < select_wizard.size();i++)
				System.out.println(select_wizard.get(i));
		}
	}



	private int askForstats(String question,int stat,int statMin,int statMax) {
		System.out.println(question);
		sc.nextLine();
		while(stat <statMin || stat >statMax) {
			System.out.println(question);
			sc.nextInt();
			sc.nextLine();
		}
		return sc.nextInt();
	}



	private  String askForString(String question) {
		System.out.println(question);
		return sc.nextLine();
	}



	//             /------------------initialise le mage et le stocke dans la liste des personnages---------------\

	private void createWizard( ) {
		heroName = askForString("veuillez entrer le nom du Héro");
		HP = askForstats("Veuillez entrer vos HP entre 3 et 6 ",HP,3,6);
		PP = askForstats("Veuillez entrer vos PP entre 8 et 15 ",PP,8,15);
		spellName = askForString("Veuillez entrer le sort que vous utiliserez");
		spellDmgs = askForstats("Veuillez entrer les dmgs de votre sort entre 8 et 15 ",spellDmgs,8,15);
		philterName = askForString("Veuillez entrer le Nom de votre filtre de defense");
		philterDmgs = askForstats("Veuillez entrer la defense de votre filtre entre 8 et 15 ",philterDmgs,8,15);
		Weapon_wizard spell = new Weapon_wizard(spellName,spellDmgs,philterName,philterDmgs);
		select_wizard.add(new Wizard(heroName,HP,PP,spell));
		wizard_description();

	}





	//              /------------------initialise le guerrier et le stocke dans la liste des personnages---------------\

	private void createWarrior() {
		heroName = askForString("veuillez entrer le nom du Héro");
		HP = askForstats("Veuillez entrer vos HP entre 5 et 10 ",HP,5,10);
		PP = askForstats("Veuillez entrer vos PP entre 5 et 15 ",PP,5,10);
		weaponHero = askForString("Veuillez entrer le l'arme que vous utiliserez");
		dmgWeapon = askForstats("Veuillez entrer les dmgs de votre arme entre 5 et 10 ",dmgWeapon,5,10);
		shieldName = askForString("Veuillez entrer le Nom de votre bouclier");
		shieldDmg = askForstats("Veuillez entrer la defense de votre bouclier entre 5 et 10 ",shieldDmg,5,10);
		Weapon_warrior weapon = new Weapon_warrior(weaponHero,dmgWeapon,shieldName,shieldDmg);
		select_warrior.add(new Warrior(heroName,HP,PP,weapon));
		warrior_description();
	}






	//                                 /-------------Fonction pour la description du Guerrier----------------\	
	void warrior_description() {
		System.out.println("Vous vous appelez \n "+heroName+"\n"+" vos HP sont de : "+HP+"HP \n "+" vos PP sont de :"+PP+" \n"+
				" votre arme est :\n "+weaponHero+ " \n"+" qui fait : "+dmgWeapon+" dgms\n "+"et votre bouclier "+shieldName+" vous de defends de : "+shieldDmg);

	}




	//                                /-------------Fonction pour la description du Mage----------------\	

	void wizard_description() {
		System.out.println("Vous vous appelez \n "+heroName+"\n"+" vos HP sont de : "+HP+"HP \n "+" vos PP sont de :"+PP+" \n"+
				" votre sort est :\n "+spellName+ " \n"+" qui fait : "+spellDmgs+" dgms\n "+"et votre philtre de défense "+philterName+" vous de defends de : "+philterDmgs);
	}

}