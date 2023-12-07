package me.kelsi.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
                        plugin.getConfig().set("whitelisted", list);
                        plugin.saveConfig();
                        return true;
                    } else {
                        return false;
                    }
                }
                if (args[0].equalsIgnoreCase("remove")) {
                    if (args[1] != null) {
                        list.remove(args[1].toLowerCase());
                        sender.sendMessage("Игрок " + args[1] + " удален из вайтлиста");
                        plugin.getConfig().set("whitelisted", list);
                        plugin.saveConfig();
                        return true;
                    } else {
                        return false;
                    }
                }
                if (args[0].equalsIgnoreCase("list")) {
                    sender.sendMessage(list.toString());
                }
                if (args[0].equalsIgnoreCase("update")) {
                    sender.sendMessage(ChatColor.GREEN + "Конфиг обновлен.\nИгроки добавлены в вайтлист из конфига");
                    list = (List<String>) plugin.getConfig().getList("whitelisted");
                    plugin.reloadConfig();
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
