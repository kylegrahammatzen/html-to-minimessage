package com.kylegm.html2mm.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HtmlCommand implements CommandExecutor {

    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 2) {
            sender.sendMessage("<aqua>Usage: /html <player> <html>");
            return false;
        }

        String playerName = args[0];
        Player player = Bukkit.getPlayer(playerName);

        if (player == null) {
            sender.sendRichMessage("<red>Player not found: " + playerName);
            return false;
        }

        String html = buildHtml(args);
        String compiledHtml = compileHtml(html);
        Component messageComponent = miniMessage.deserialize(compiledHtml,
                Placeholder.component("bullet", Component.text("\u2022")),
                Placeholder.unparsed("player_name", playerName)
        );

        player.sendRichMessage(MiniMessage.miniMessage().serialize(messageComponent));
        return true;
    }

    private String buildHtml(String[] args) {
        StringBuilder htmlBuilder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            htmlBuilder.append(args[i]).append(" ");
        }
        return htmlBuilder.toString().trim();
    }

    private String compileHtml(String html) {
        // Replace HTML tags with MiniMessage-compatible tags
        html = html.replaceAll("(?i)<p>", "\n")
                .replaceAll("(?i)</p>", "\n")
                .replaceAll("(?i)<li>", "\n<bullet> ")
                .replaceAll("(?i)</li>", "")
                .replaceAll("(?i)<ul>", "")
                .replaceAll("(?i)</ul>", "")
                .replaceAll("(?i)<br>", "\n")
                .replaceAll("(?i)<span>", "")
                .replaceAll("(?i)</span>", "");

        // Remove any leading/trailing whitespace and multiple blank lines
        html = html.replaceAll("(?m)^[ \t]*\n", "");

        return html.trim();
    }
}
