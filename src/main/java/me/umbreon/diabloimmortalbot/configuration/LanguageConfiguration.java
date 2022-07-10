package me.umbreon.diabloimmortalbot.configuration;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class LanguageConfiguration {

    Map<String, Object> messages;

    String vault, vaultHeadUp;
    String demonGates, demonGatesHeadUp;
    String ancientArea, ancientAreaHeadUp;
    String assembly, assemblyHeadUp;
    String ancientNightmare, ancientNightmareHeadUp;
    String battleground, battlegroundHeadUp;
    String hauntedCarriage, hauntedCarriageHeadUp;
    String shadowLottery, shadowLotteryHeadUp;

    public void loadLanguageConfiguration() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/home/discord/english.yaml");
        messages = yaml.load(inputStream);
        //System.out.println(messages);
    }

}
