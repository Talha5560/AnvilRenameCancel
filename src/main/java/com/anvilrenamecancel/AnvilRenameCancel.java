package com.anvilrenamecancel;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class AnvilRenameCancel extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        ItemStack result = event.getResult();
        if (result != null) {
            String renamedItem = result.getItemMeta().getDisplayName();
            if (!renamedItem.equals(result.getItemMeta().getLocalizedName())) {
                event.setResult(null);
                event.getInventory().setRepairCost(0);
                event.getView().getPlayer().sendMessage("Eşya isimlerini değiştiremezsin!");
            }
        }
    }
}