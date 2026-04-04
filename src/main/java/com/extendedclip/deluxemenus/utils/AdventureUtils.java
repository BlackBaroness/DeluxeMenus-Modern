package com.extendedclip.deluxemenus.utils;

import com.extendedclip.deluxemenus.DeluxeMenus;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class AdventureUtils {
    private final static GsonComponentSerializer gson = GsonComponentSerializer.gson();

    private AdventureUtils() {
        throw new AssertionError("Util classes should not be initialized");
    }

    public static void sendJson(@NotNull final DeluxeMenus plugin, CommandSender sender, String json) {
        sender.sendMessage(fromJson(json));
    }

    public static Component fromJson(String json) {
        return gson.deserialize(json);
    }

    // required since this method is absent on 1.18 and lower
    public static Component decorationIfAbsent(Component component, TextDecoration decoration, TextDecoration.State state) {
        final TextDecoration.State oldState = component.decoration(decoration);
        if (oldState == TextDecoration.State.NOT_SET) {
            return component.style(component.style().decoration(decoration, state));
        }
        return component;

    }
}
