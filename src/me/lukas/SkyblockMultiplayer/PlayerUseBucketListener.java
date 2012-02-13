package me.lukas.skyblockmultiplayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class PlayerUseBucketListener implements Listener {

	SkyblockMultiplayer plugin;

	public PlayerUseBucketListener(SkyblockMultiplayer instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
		if (!Data.SKYBLOCK_ONLINE) {
			return;
		}
		
		if (event.getPlayer().getWorld().equals(SkyblockMultiplayer.getSkyblockIslands())) { // Pr�fe ob der Spieler in der Welt SkyblockMultiplayer ist
			if (event.getPlayer().getLocation().getBlockX() >= -20 && event.getPlayer().getLocation().getBlockX() <= 20) {
				if (event.getPlayer().getLocation().getBlockZ() >= -20 && event.getPlayer().getLocation().getBlockZ() <= 20) {
					event.setCancelled(true);
					return;
				}
			}
		}
	}
}
