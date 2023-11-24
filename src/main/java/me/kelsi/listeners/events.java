package me.kelsi.listeners;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class events implements Listener {

    public static List<String> list = new ArrayList<>();
    JavaPlugin plugin;

    public events(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (list.contains(player.getDisplayName())) {
            event.setCancelled(false);
        }
        if (!list.contains(player.getDisplayName())) {
            event.setCancelled(true);
        }
    }

}
