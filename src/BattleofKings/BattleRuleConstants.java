package BattleofKings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleRuleConstants {

	
	 public static final Map<String, List<String>> ADVANTAGE_MAP = Map.of(
		        "Militia", List.of("Spearmen", "LightCavalry"),
		        "Spearmen", List.of("LightCavalry", "HeavyCavalry"),
		        "LightCavalry", List.of("FootArcher", "CavalryArcher"),
		        "HeavyCavalry", List.of("Militia", "FootArcher", "LightCavalry"),
		        "CavalryArcher", List.of("Spearmen", "HeavyCavalry"),
		        "FootArcher", List.of("Militia", "CavalryArcher")
		    );
	
}
