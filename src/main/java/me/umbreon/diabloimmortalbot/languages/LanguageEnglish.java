package me.umbreon.diabloimmortalbot.languages;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class LanguageEnglish {

    static Map<String, Object> messages;

    public void loadLanguageConfiguration() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("english.yaml");
        messages = yaml.load(inputStream);
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
        return messages.get("ALREADY_REGISTERED").toString();
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

    public static String getHeadUpValueSetToMessage() {
        return messages.get("HEADUP_VALUE_SET_TO").toString();
    }

    public static String getLanguageMessage() {
        return messages.get("LANGUAGE").toString();
    }

    public static String getEventEnabledMessage() {
        return messages.get("EVENT_ENABLED").toString();
    }

    public static String getEventDisabledMessage() {
        return messages.get("EVENT_DISABLED").toString();
    }

    public static String getChannelNotFoundMessage() {
        return messages.get("CHANNEL_NOT_FOUND").toString();
    }

    public static String getDoBotGotRightsMessage() {
        return messages.get("DO_BOT_GOT_RIGHTS").toString();
    }

    public static String getCustomMessageCreatedMessage() {
        return messages.get("CUSTOM_MESSAGE_CREATED").toString();
    }

    public static String getNoCustomMessagesMessage() {
        return messages.get("NO_CUSTOM_MESSAGES").toString();
    }

    public static String getYourCustomMessagesMessage() {
        return messages.get("YOUR_CUSTOM_MESSAGES").toString();
    }

    public static String getCustomMessageDeletedMessage() {
        return messages.get("CUSTOM_MESSAGE_DELETED").toString();
    }

    public static String getCustomMessageWithIdDeleted() {
        return messages.get("CUSTOM_MESSAGE_WITH_ID_DELETED").toString();
    }

    public static String getInvalidCommandMessage() {
        return messages.get("INVALID_COMMAND").toString();
    }

    public static String getAncientArenaEmbedMessage() {
        return messages.get("ANCIENT_ARENA_EMBED").toString();
    }

    public static String getLocationAncientArenaEmbedMessage1() {
        return messages.get("LOCATION_ANCIENT_ARENA_EMBED_1").toString();
    }

    public static String getLocationAncientArenaEmbedMessage2() {
        return messages.get("LOCATION_ANCIENT_ARENA_EMBED_2").toString();
    }

    public static String getAncientNightmareEmbedMessage() {
        return messages.get("ANCIENT_NIGHTMARE_EMBED").toString();
    }

    public static String getLocationAncientNightmareEmbedMessage1() {
        return messages.get("LOCATION_ANCIENT_NIGHTMARE_EMBED_1").toString();
    }

    public static String getLocationAncientNightmareEmbedMessage2() {
        return messages.get("LOCATION_ANCIENT_NIGHTMARE_EMBED_2").toString();
    }

    public static String getDemonGatesEmbedMessage() {
        return messages.get("DEMON_GATES_EMBED").toString();
    }

    public static String getLocationDemonGatesEmbedMessage1() {
        return messages.get("LOCATION_DEMON_GATE_EMBED_1").toString();
    }

    public static String getLocationDemonGatesEmbedMessage2() {
        return messages.get("LOCATION_DEMON_GATE_EMBED_2").toString();
    }

    public static String getHauntedCarriageEmbedMessage() {
        return messages.get("DEMON_GATES_EMBED").toString();
    }

    public static String getLocationHauntedCarriageEmbedMessage1() {
        return messages.get("LOCATION_DEMON_GATE_EMBED_1").toString();
    }

    public static String getLocationHauntedCarriageEmbedMessage2() {
        return messages.get("LOCATION_DEMON_GATE_EMBED_2").toString();
    }

    public static String getSpawnAtMessage() {
        return messages.get("SPAWN_AT_EMBED").toString();
    }

    public static String getCountdownEmbedMessage() {
        return messages.get("COUNTDOWN_EMBED").toString();
    }

    public static String getWorldEventEmbedMessage() {
        return messages.get("WORLD_EVENT_EMBED").toString();
    }
}
