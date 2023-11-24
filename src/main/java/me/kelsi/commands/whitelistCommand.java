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
        if(sender.hasPermission("wl.admin")) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("add")) {
                    if (args[1] != null) {
                        list.add(args[1].toLowerCase());
                        sender.sendMessage("Игрок " + args[1] + " добавлен в вайтлист");
                        return true;
                    } else {
                        return false;
                    }
                }
                if (args[0].equalsIgnoreCase("remove")) {
                    if (args[1] != null) {
                        list.remove(args[1].toLowerCase());
                        sender.sendMessage("Игрок " + args[1] + " удален из вайтлиста");
                        return true;
                    } else {
                        return false;
                    }
                }
                if (args[0].equalsIgnoreCase("list")) {
                    sender.sendMessage(list.toString());
                }
            }
            return true;
        } if (!sender.hasPermission("wl.admin")) {
            sender.sendMessage("У вас недостаточно прав!");
            return true;
        }

        return false;
    }
}
