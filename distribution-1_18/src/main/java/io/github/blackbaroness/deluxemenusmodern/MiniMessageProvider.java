package io.github.blackbaroness.deluxemenusmodern;

import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
@UtilityClass
public class MiniMessageProvider {

    private final MiniMessage instance = MiniMessage.builder()
        .preProcessor(new LegacyPreProcessor())
        .postProcessor(new LegacyPostProcessor())
        .build();

    public static MiniMessage get() {
        return instance;
    }

    // Reference: https://github.com/Rollczi/LiteCommands/blob/master/litecommands-adventure/src/dev/rollczi/litecommands/adventure/LegacyPreProcessor.java
    private static final class LegacyPreProcessor implements UnaryOperator<String> {
        @Override
        public String apply(String component) {
            return component.replace(LegacyComponentSerializer.SECTION_CHAR, LegacyComponentSerializer.AMPERSAND_CHAR);
        }
    }

    // Reference: https://github.com/Rollczi/LiteCommands/blob/master/litecommands-adventure/src/dev/rollczi/litecommands/adventure/LegacyPostProcessor.java
    private static final class LegacyPostProcessor implements UnaryOperator<Component> {

        private static final TextReplacementConfig LEGACY_REPLACEMENT_CONFIG = TextReplacementConfig.builder()
            .match(Pattern.compile(".*"))
            .replacement((matchResult, build) -> LegacyComponentSerializer.legacyAmpersand().deserialize(matchResult.group()))
            .build();

        @Override
        public Component apply(Component component) {
            return component.replaceText(LEGACY_REPLACEMENT_CONFIG);
        }
    }
}
