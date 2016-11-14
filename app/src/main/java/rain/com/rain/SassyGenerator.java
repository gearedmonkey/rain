package rain.com.rain;

import java.util.Random;

public class SassyGenerator {
    private static final double U_235_THRESHOLD = 0;
    private static final String[] ACTIVE_U_235 = {
            "You need to think about getting a jacket made of active U-235.",
            "You'll live. Maybe?",
            "I hope you're from Greenland…",
            "Damn. I hope you don't have to goto school…"
    };
    private static final double HEAVY_THRESHOLD = 43;
    private static final String[] HEAVY_JACKET = {
            "Get yo parka",
            "You got a wind-proof, insulated jacket ya?"
    };
    private static final double LIGHT_THRESHOLD = 65;
    private static final String[] LIGHT_JACKET = {
            "\"You should bring a light jacket.\"\nLove, Mom",
            "It's not a sweater. It's a fleece, Jordan.",
            "Don't forget your jacket, honey!"
    };
    private static final String[] NORMAL = {
            "Just get the hell out there.",
            "It's fine.",
            "Just go."
    };
    private static final double NEKKID_THRESHOLD = 110;
    private static final String[] NEKKID = {
            "\uD83C\uDFB6 It's gettin' hot in here, so talk off all your clothes! \uD83C\uDFB6",
            "You'll live. Maybe?",
            "I hope you were raised in a desert…",
            "Good luck",
            "You really don't want to leave the house.\nLike you really really don't want to go out.",
            "It's baking today, can't stand it when it's this hot"
    };

    public static String getSass(double temperature) {
        Random rGen = new Random();
        if (temperature <= U_235_THRESHOLD) {
            return ACTIVE_U_235[rGen.nextInt(ACTIVE_U_235.length)];
        } else if (temperature <= HEAVY_THRESHOLD) {
            return HEAVY_JACKET[rGen.nextInt(HEAVY_JACKET.length)];
        } else if (temperature <= LIGHT_THRESHOLD) {
            return LIGHT_JACKET[rGen.nextInt(LIGHT_JACKET.length)];
        } else if (temperature >= NEKKID_THRESHOLD) {
            return NEKKID[rGen.nextInt(NEKKID.length)];
        } else {
            return NORMAL[rGen.nextInt(NORMAL.length)];
        }
    }
}
