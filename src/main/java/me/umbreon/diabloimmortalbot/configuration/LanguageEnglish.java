package me.umbreon.diabloimmortalbot.configuration;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class LanguageEnglish {

    private final String configurationPath = "/home/discord/english.yaml";

    Map<String, Object> messages;

    String vault, vaultHeadUp;
    String demonGates, demonGatesHeadUp;
    String ancientArea, ancientAreaHeadUp;
    String assembly, assemblyHeadUp;
    String ancientNightmare, ancientNightmareHeadUp;
    String battleground, battlegroundHeadUp;
    String hauntedCarriage, hauntedCarriageHeadUp;
    String shadowLottery, shadowLotteryHeadUp;

    public void loadConfiguration() {
        Yaml yaml = new Yaml();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configurationPath);
        messages = yaml.load(inputStream);
        //System.out.println(messages);
    }
}
