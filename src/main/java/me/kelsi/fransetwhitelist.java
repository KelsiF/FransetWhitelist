package me.kelsi;

import me.kelsi.commands.whitelistCommand;
import me.kelsi.listeners.events;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

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
        Objects.requireNonNull(getCommand("wl")).setExecutor(new whitelistCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}