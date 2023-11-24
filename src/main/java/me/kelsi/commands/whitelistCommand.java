package me.kelsi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static me.kelsi.listeners.events.list;

public class whitelistCommand implements CommandExecutor {

    JavaPlugin plugin;

    public whitelistCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("add")) {
                list.add(args[1]);
            }
            if (args[0].equalsIgnoreCase("remove")) {
                list.remove(args[1]);
            }
        }

        return false;
    }
}
