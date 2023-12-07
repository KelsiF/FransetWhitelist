package me.kelsi;

import me.kelsi.commands.whitelistCommand;
import me.kelsi.listeners.chatEvents;
import me.kelsi.listeners.events;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static me.kelsi.listeners.events.list;

public final class fransetwhitelist extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("\n" +
                "███████╗██████╗░░█████╗░███╗░░██╗░██████╗███████╗████████╗░██╗░░░░░░░██╗██╗░░██╗██╗████████╗███████╗██╗░░░░░██╗░██████╗████████╗\n" +
                "██╔════╝██╔══██╗██╔══██╗████╗░██║██╔════╝██╔════╝╚══██╔══╝░██║░░██╗░░██║██║░░██║██║╚══██╔══╝██╔════╝██║░░░░░██║██╔════╝╚══██╔══╝\n" +
                "█████╗░░██████╔╝███████║██╔██╗██║╚█████╗░█████╗░░░░░██║░░░░╚██╗████╗██╔╝███████║██║░░░██║░░░█████╗░░██║░░░░░██║╚█████╗░░░░██║░░░\n" +
                "██╔══╝░░██╔══██╗██╔══██║██║╚████║░╚═══██╗██╔══╝░░░░░██║░░░░░████╔═████║░██╔══██║██║░░░██║░░░██╔══╝░░██║░░░░░██║░╚═══██╗░░░██║░░░\n" +
                "██║░░░░░██║░░██║██║░░██║██║░╚███║██████╔╝███████╗░░░██║░░░░░╚██╔╝░╚██╔╝░██║░░██║██║░░░██║░░░███████╗███████╗██║██████╔╝░░░██║░░░\n" +
                "╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═════╝░╚══════╝░░░╚═╝░░░░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝╚═╝░░░╚═╝░░░╚══════╝╚══════╝╚═╝╚═════╝░░░░╚═╝░░░\n" +
                "\n" +
                "██████╗░██╗░░░██╗  ██╗░░██╗███████╗██╗░░░░░░██████╗██╗██████╗░███████╗██╗░░░██╗\n" +
                "██╔══██╗╚██╗░██╔╝  ██║░██╔╝██╔════╝██║░░░░░██╔════╝██║██╔══██╗██╔════╝██║░░░██║\n" +
                "██████╦╝░╚████╔╝░  █████═╝░█████╗░░██║░░░░░╚█████╗░██║██║░░██║█████╗░░╚██╗░██╔╝\n" +
                "██╔══██╗░░╚██╔╝░░  ██╔═██╗░██╔══╝░░██║░░░░░░╚═══██╗██║██║░░██║██╔══╝░░░╚████╔╝░\n" +
                "██████╦╝░░░██║░░░  ██║░╚██╗███████╗███████╗██████╔╝██║██████╔╝███████╗░░╚██╔╝░░\n" +
                "╚═════╝░░░░╚═╝░░░  ╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░╚═╝╚═════╝░╚══════╝░░░╚═╝░░░");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new events(this), this);
        getServer().getPluginManager().registerEvents(new chatEvents(this), this);
        Objects.requireNonNull(getCommand("wl")).setExecutor(new whitelistCommand(this));

        // получения списка из конфига
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        list = (List<String>) getConfig().getList("whitelisted");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        // сохранение списка игроков при выключении плагина
        getConfig().set("whitelisted", list);
        saveConfig();
    }
}
