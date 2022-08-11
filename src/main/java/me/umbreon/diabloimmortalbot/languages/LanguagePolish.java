package me.umbreon.diabloimmortalbot.languages;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class LanguagePolish {

    static Map<String, Object> messages;

    void loadLanguageConfiguration() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("polish.yaml");
        messages = yaml.load(inputStream);
    }

    static String getHauntedCarriageMessage() {
        return messages.get("HAUNTED_CARRIAGE").toString();
    }

    static String getHauntedCarriageHeadUpMessage() {
        return messages.get("HAUNTED_CARRIAGE_HEADUP").toString();
    }

    static String getDemonGatesMessage() {
        return messages.get("DEMON_GATES").toString();
    }

    static String getDemonGatesHeadUpMessage() {
        return messages.get("DEMON_GATES_HEADUP").toString();
    }

    static String getBattlegroundMessage() {
        return messages.get("BATTLEGROUND").toString();
    }

    static String getBattlegroundHeadUpMessage() {
        return messages.get("BATTLEGROUND_HEADUP").toString();
    }

    static String getAncientNightmareMessage() {
        return messages.get("ANCIENT_NIGHTMARE").toString();
    }

    static String getAncientNightmareHeadUpMessage() {
        return messages.get("ANCIENT_NIGHTMARE_HEADUP").toString();
    }

    static String getAncientArenaMessage() {
        return messages.get("ANCIENT_ARENA").toString();
    }

    static String getAncientArenaHeadUpMessage() {
        return messages.get("ANCIENT_ARENA_HEADUP").toString();
    }

    static String getAssemblyMessage() {
        return messages.get("ASSEMBLY").toString();
    }

    static String getAssemblyHeadUpMessage() {
        return messages.get("ASSEMBLY_HEADUP").toString();
    }

    static String getShadowLotteryMessage() {
        return messages.get("SHADOW_LOTTERY").toString();
    }

    static String getShadowLotteryHeadUpMessage() {
        return messages.get("SHADOW_LOTTERY_HEADUP").toString();
    }

    static String getRegisteredMessage() {
        return messages.get("REGISTERED").toString();
    }

    static String getAlreadyRegisteredMessage() {
        return messages.get("REGISTERED_REGISTERED").toString();
    }

    static String getRoleNotFoundMessage() {
        return messages.get("ROLE_NOT_FOUND").toString();
    }

    static String getNotRegisteredMessage() {
        return messages.get("NOT_REGISTERED").toString();
    }

    static String getReceiveAllMessagesMessage() {
        return messages.get("RECEIVE_ALL_MESSAGES").toString();
    }

    static String getReceiveImmortalMessage() {
        return messages.get("RECEIVE_IMMORTAL_MESSAGES").toString();
    }

    static String getReceiveShadowMessage() {
        return messages.get("RECEIVE_SHADOW_MESSAGES").toString();
    }

    static String getReceiveOwImmortalMessage() {
        return messages.get("RECEIVE_OV_AND_IMMORTAL_MESSAGES").toString();
    }

    static String getReceiveOwShadowMessage() {
        return messages.get("RECEIVE_OV_AND_SHADOW_MESSAGES").toString();
    }

    static String getReceiveOverworldMessage() {
        return messages.get("RECEIVE_OVERWORLD_MESSAGES").toString();
    }

    static String getTimezoneSetToMessage() {
        return messages.get("TIMEZONE_SET").toString();
    }

    static String getUnregisteredChannel() {
        return messages.get("UNREGISTERED").toString();
    }

    static String getUnknownTimezoneMessage() {
        return messages.get("UNKNOWN_TIMEZONE").toString();
    }

    static String getUnknownStatusMessage() {
        return messages.get("UNKNOWN_STATUS").toString();
    }

    static String getIsSetMessage() {
        return messages.get("IS_SET").toString();
    }

    static String getRaidTheVaultMessage() {
        return messages.get("RAID_VAULT").toString();
    }

    static String getRaidTheVaultHeadUpMessage() {
        return messages.get("RAID_VAULT_HEADUP").toString();
    }

    static String getDefendTheVaultMessage() {
        return messages.get("DEFEND_VAULT").toString();
    }

    static String getDefendTheVaultHeadUpMessage() {
        return messages.get("DEFEND_VAULT_HEADUP").toString();
    }

    static String getLanguageNotSupportedMessage() {
        return messages.get("LANGUAGE_NOT_SUPPORTED").toString();
    }

    static String getLanguageUpdatedMessage() {
        return messages.get("LANGUAGE_UPDATED").toString();
    }

    static String getHeadUpValueSetToMessage() {
        return messages.get("HEADUP_VALUE_SET_TO").toString();
    }

    static String getLanguageMessage() {
        return messages.get("LANGUAGE").toString();
    }

    static String getEventEnabledMessage() {
        return messages.get("EVENT_ENABLED").toString();
    }

    static String getEventDisabledMessage() {
        return messages.get("EVENT_DISABLED").toString();
    }

    static String getChannelNotFoundMessage() {
        return messages.get("CHANNEL_NOT_FOUND").toString();
    }

    static String getDoBotGotRightsMessage() {
        return messages.get("DO_BOT_GOT_RIGHTS").toString();
    }

    static String getCustomMessageCreated() {
        return messages.get("CUSTOM_MESSAGE_CREATED").toString();
    }

    static String getNoCustomMessagesMessage() {
        return messages.get("NO_CUSTOM_MESSAGES").toString();
    }

    static String getYourCustomMessagesMessage() {
        return messages.get("YOUR_CUSTOM_MESSAGES").toString();
    }

    static String getCustomMessageCreatedMessage() {
        return messages.get("CUSTOM_MESSAGE_CREATED").toString();
    }

    static String getCustomMessageDeletedMessage() {
        return messages.get("CUSTOM_MESSAGE_DELETED").toString();
    }

    static String getCustomMessageWithIdDeleted() {
        return messages.get("CUSTOM_MESSAGE_WITH_ID_DELETED").toString();
    }

    static String getInvalidCommandMessage() {
        return messages.get("INVALID_COMMAND").toString();
    }

    static String getAncientArenaEmbedMessage() {
        return messages.get("ANCIENT_ARENA_EMBED").toString();
    }

    static String getLocationAncientArenaEmbedMessage1() {
        return messages.get("LOCATION_ANCIENT_ARENA_EMBED_1").toString();
    }

    static String getLocationAncientArenaEmbedMessage2() {
        return messages.get("LOCATION_ANCIENT_ARENA_EMBED_2").toString();
    }

    static String getAncientNightmareEmbedMessage() {
        return messages.get("ANCIENT_NIGHTMARE_EMBED").toString();
    }

    static String getLocationAncientNightmareEmbedMessage1() {
        return messages.get("LOCATION_ANCIENT_NIGHTMARE_EMBED_1").toString();
    }

    static String getLocationAncientNightmareEmbedMessage2() {
        return messages.get("LOCATION_ANCIENT_NIGHTMARE_EMBED_2").toString();
    }

    static String getDemonGatesEmbedMessage() {
        return messages.get("DEMON_GATES_EMBED").toString();
    }

    static String getLocationDemonGatesEmbedMessage1() {
        return messages.get("LOCATION_DEMON_GATE_EMBED_1").toString();
    }

    static String getLocationDemonGatesEmbedMessage2() {
        return messages.get("LOCATION_DEMON_GATE_EMBED_2").toString();
    }

    static String getHauntedCarriageEmbedMessage() {
        return messages.get("DEMON_GATES_EMBED").toString();
    }

    static String getLocationHauntedCarriageEmbedMessage1() {
        return messages.get("LOCATION_DEMON_GATE_EMBED_1").toString();
    }

    static String getLocationHauntedCarriageEmbedMessage2() {
        return messages.get("LOCATION_DEMON_GATE_EMBED_2").toString();
    }

    static String getSpawnAtMessage() {
        return messages.get("SPAWN_AT_EMBED").toString();
    }

    static String getCountdownEmbedMessage() {
        return messages.get("COUNTDOWN_EMBED").toString();
    }

    static String getWorldEventEmbedMessage() {
        return messages.get("WORLD_EVENT_EMBED").toString();
    }

    static String getInvalidTimezoneMessage() {
        return messages.get("INVALID_TIMEZONE").toString();
    }

    static String getHeadUpEnabledMessage() {
        return messages.get("HEADUP_ENABLED").toString();
    }

    static String getHeadUpDisabledMessage() {
        return messages.get("HEADUP_DISABLED").toString();
    }

    static String getCannotDisableEventMessage() {
        return messages.get("CANNOT_DISABLE_EVENT").toString();
    }

    static String getEventDoesNotExistMessage() {
        return messages.get("CANNOT_DISABLE_EVENT").toString();
    }

    static String getAvailableEventsMessage() {
        return messages.get("AVAILABLE_EVENTS").toString();
    }

    static String getWhatTextChannelMessage() {
        return messages.get("WHAT_TEXTCHANNEL").toString();
    }

    static String getThisMessage() {
        return messages.get("THIS").toString();
    }

    static String getWhatDayMessage() {
        return messages.get("WHAT_DAY").toString();
    }

    static String getWhatTimeMessage() {
        return messages.get("WHAT_TIME").toString();
    }

    static String getWhatMessageMessage() {
        return messages.get("WHAT_MESSAGE").toString();
    }

    static String getMessageFrequentlyMessage() {
        return messages.get("MESSAGE_FREQUENTLY").toString();
    }

    static String getYesOrNoMessage() {
        return messages.get("YES_OR_NO").toString();
    }

    static String getInvalidDayMessage() {
        return messages.get("INVALID_DAY").toString();
    }
}
