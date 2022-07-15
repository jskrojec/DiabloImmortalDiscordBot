package me.umbreon.diabloimmortalbot.configuration;

import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class LanguageGerman {

    static Map<String, Object> messages;

    public void loadLanguageConfiguration() {
        //Yaml yaml = new Yaml();
        //InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("german.yaml");
        //messages = yaml.load(inputStream);
    }

    public static String getVaultMessage() {
        return messages.get("VAULT").toString();
    }

    public static String getVaultHeadUpMessage() {
        return messages.get("VAULT_HEADUP").toString();
    }

    public static String getHauntedCarriageMessage() {
        return messages.get("HAUNTED_CARRIAGE").toString();
    }

    public static String getHauntedCarriageHeadUpMessage() {
        return messages.get("HAUNTED_CARRIAGE_HEADUP").toString();
    }

    public static String getDemonGatesMessage() {
        return messages.get("DEMON_GATES").toString();
    }

    public static String getDemonGatesHeadUpMessage() {
        return messages.get("DEMON_GATES_HEADUP").toString();
    }

    public static String getBattlegroundMessage() {
        return messages.get("BATTLEGROUND").toString();
    }

    public static String getBattlegroundHeadUpMessage() {
        return messages.get("BATTLEGROUND_HEADUP").toString();
    }

    public static String getAncientNightmareMessage() {
        return messages.get("ANCIENT_NIGHTMARE").toString();
    }

    public static String getAncientNightmareHeadUpMessage() {
        return messages.get("ANCIENT_NIGHTMARE_HEADUP").toString();
    }

    public static String getAncientArenaMessage() {
        return messages.get("ANCIENT_ARENA").toString();
    }

    public static String getAncientArenaHeadUpMessage() {
        return messages.get("ANCIENT_ARENA_HEADUP").toString();
    }

    public static String getAssemblyMessage() {
        return messages.get("ASSEMBLY").toString();
    }

    public static String getAssemblyHeadUpMessage() {
        return messages.get("ASSEMBLY_HEADUP").toString();
    }

    public static String getShadowLotteryMessage() {
        return messages.get("SHADOW_LOTTERY").toString();
    }

    public static String getShadowLotteryHeadUpMessage() {
        return messages.get("SHADOW_LOTTERY_HEADUP").toString();
    }

    public static String getRegisteredMessage() {
        return messages.get("REGISTERED").toString();
    }

    public static String getAlreadyRegisteredMessage() {
        return messages.get("REGISTERED_REGISTERED").toString();
    }

    public static String getRoleNotFoundMessage() {
        return messages.get("ROLE_NOT_FOUND").toString();
    }

    public static String getNotRegisteredMessage() {
        return messages.get("NOT_REGISTERED").toString();
    }

    public static String getReceiveAllMessagesMessage() {
        return messages.get("RECEIVE_ALL_MESSAGES").toString();
    }

    public static String getReceiveImmortalMessage() {
        return messages.get("RECEIVE_IMMORTAL_MESSAGES").toString();
    }

    public static String getReceiveShadowMessage() {
        return messages.get("RECEIVE_SHADOW_MESSAGES").toString();
    }

    public static String getReceiveOwImmortalMessage() {
        return messages.get("RECEIVE_OV_AND_IMMORTAL_MESSAGES").toString();
    }

    public static String getReceiveOwShadowMessage() {
        return messages.get("RECEIVE_OV_AND_SHADOW_MESSAGES").toString();
    }

    public static String getReceiveOverworldMessage() {
        return messages.get("RECEIVE_OVERWORLD_MESSAGES").toString();
    }

    public static String getTimezoneSetToMessage() {
        return messages.get("TIMEZONE_SET").toString();
    }

    public static String getUnregisteredChannel() {
        return messages.get("UNREGISTERED").toString();
    }

    public static String getNowInDebugMessage() {
        return messages.get("NOW_IN_DEBUG").toString();
    }

    public static String getNoLongerDebugMessage() {
        return messages.get("NO_LONGER_DEBUG").toString();
    }

    public static String getUnknownTimezoneMessage() {
        return messages.get("UNKNOWN_TIMEZONE").toString();
    }

    public static String getUnknownStatusMessage() {
        return messages.get("UNKNOWN_STATUS").toString();
    }

    public static String getIsSetMessage() {
        return messages.get("IS_SET").toString();
    }

    public static String getRaidTheVaultMessage() {
        return messages.get("RAID_VAULT").toString();
    }

    public static String getRaidTheVaultHeadUpMessage() {
        return messages.get("RAID_VAULT_HEADUP").toString();
    }

    public static String getDefendTheVaultMessage() {
        return messages.get("DEFEND_VAULT").toString();
    }

    public static String getDefendTheVaultHeadUpMessage() {
        return messages.get("DEFEND_VAULT_HEADUP").toString();
    }

    public static String getLanguageNotSupportedMessage() {
        return messages.get("LANGUAGE_NOT_SUPPORTED").toString();
    }

    public static String getLanguageUpdatedMessage() {
        return messages.get("LANGUAGE_UPDATED").toString();
    }

}
