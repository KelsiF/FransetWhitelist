package me.kelsi.listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class events implements Listener {

    public static List<String> list = new ArrayList<>();
    JavaPlugin plugin;

    public events(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        String name = player.getDisplayName().toLowerCase();
        if (list.contains(name)) {
            event.setCancelled(false);
        }
        if (!list.contains(name)) {
            event.setCancelled(true);
            player.sendMessage(" \n" + "Напишите анкету в нашем дискорде, чтобы получить возможность полноценно играть\n https://bit.ly/franset-minecraft\n" + " ");
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(false);
        }
        if (!list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(true);
            player.sendMessage(" \n" + plugin.getConfig().getString("messages.not-whitelisted") + " ");
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(false);
        }
        if (!list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(true);
            player.sendMessage(" \n" + plugin.getConfig().getString("messages.not-whitelisted") + " ");
        }
    }

    @EventHandler
    public void onDamaged(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (list.contains(player.getDisplayName().toLowerCase())) {
                event.setCancelled(false);
            }
            if (!list.contains(player.getDisplayName().toLowerCase())) {
                event.setCancelled(true);
                player.sendMessage(" \n" + plugin.getConfig().getString("messages.not-whitelisted") + " ");
            }
        }
    }

    @EventHandler
    public void onDamageByPlayer(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (list.contains(player.getDisplayName().toLowerCase())) {
                event.setCancelled(false);
            }
            if (!list.contains(player.getDisplayName().toLowerCase())) {
                event.setCancelled(true);
                player.sendMessage(" \n" + plugin.getConfig().getString("messages.not-whitelisted") + " ");
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        if (list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(false);
        }
        if (!list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(true);
            player.sendMessage(" \n" + plugin.getConfig().getString("messages.not-whitelisted") + " ");
            player.sendMessage(ChatColor.GRAY + "Вы не можете даже умереть))))");
        }
    }


}
