package BattleofKings;

import java.util.List;
import java.util.Scanner;

public class MedievalBattleApp {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your platoons:");
		String ownInput = scanner.nextLine();

		System.out.println("Enter opponent platoons:");
		String enemyInput = scanner.nextLine();
		BattlePlanHelper battlePlanHelper = new BattlePlanHelper();
		List<Platoon> ownPlatoons = battlePlanHelper.parseInput(ownInput);
		List<Platoon> enemyPlatoons = battlePlanHelper.parseInput(enemyInput);
		
		 if (!BattlePlanHelper.canWinMajority(ownPlatoons, enemyPlatoons)) {
	            System.out.println("There is no chance of winning");
	        }


	}

}
