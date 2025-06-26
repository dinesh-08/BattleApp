package BattleofKings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BattlePlanHelper {
	
	public  List<Platoon> parseInput(String line) {
        List<Platoon> platoons = new ArrayList<>();
        for (String entry : line.split(";")) {
            String[] parts = entry.split("#");
            platoons.add(new Platoon(parts[0], Integer.parseInt(parts[1])));
        }
        return platoons;
    }
	
	
	public static boolean beats(Platoon own, Platoon enemy) {
        boolean hasAdvantage = BattleRuleConstants.ADVANTAGE_MAP.getOrDefault(own.getUnitType(), Collections.emptyList())
                .contains(enemy.getUnitType());

        int effectivePower = hasAdvantage ? own.getCount() * 2 : own.getCount();
        return effectivePower > enemy.getCount();
    }

    public static boolean isDraw(Platoon own, Platoon enemy) {
        boolean hasAdvantage = BattleRuleConstants.ADVANTAGE_MAP.getOrDefault(own.getUnitType(), Collections.emptyList())
                .contains(enemy.getUnitType());

        int effectivePower = hasAdvantage ? own.getCount() * 2 : own.getCount();
        return effectivePower == enemy.getCount();
    }
    
    
    public static boolean canWinMajority(List<Platoon> own, List<Platoon> enemy) {
        List<List<Platoon>> permutations = generatePermutations(own);
        List<Platoon> bestArrangement = null;
        int maxWins = 0;

        for (List<Platoon> perm : permutations) {
            int wins = 0;
            for (int i = 0; i < 5; i++) {
                if (beats(perm.get(i), enemy.get(i))) {
                    wins++;
                }
            }
            if (wins > maxWins) {
                maxWins = wins;
                bestArrangement = perm;
            }
        }

        if (maxWins >= 3 && bestArrangement != null) {
            printResult(bestArrangement);
            return true;
        }

        return false;
    }
    
    private static List<List<Platoon>> generatePermutations(List<Platoon> platoons) {
        List<List<Platoon>> results = new ArrayList<>();
        backtrack(platoons, 0, results);
        return results;
    }

    private static void backtrack(List<Platoon> list, int start, List<List<Platoon>> result) {
        if (start == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, i, start);
            backtrack(list, start + 1, result);
            Collections.swap(list, i, start);
        }
    }

    private static void printResult(List<Platoon> result) {
        System.out.println(String.join(";", result.stream().map(Platoon::toString).toList()));
    }




}
