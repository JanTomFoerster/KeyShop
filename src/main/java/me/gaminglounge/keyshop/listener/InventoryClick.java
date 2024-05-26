package me.gaminglounge.keyshop.listener;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;

public class InventoryClick implements Listener {

    public static final NamespacedKey isInventoryClickEvent = new NamespacedKey("keyshop", "is_inventory_click_event");

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null || e.getCurrentItem().getItemMeta() == null) return;
        if (!e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(isInventoryClickEvent,
                PersistentDataType.INTEGER)) return;
        switch (e.getCurrentItem().getItemMeta().getPersistentDataContainer().
                get(isInventoryClickEvent, PersistentDataType.INTEGER)) {
            default:
                break;
            case 0:
                e.setCancelled(true);
                break;
            case 1:
                e.setCancelled(true);
                e.getWhoClicked().closeInventory();
                break;
        }
    }

}
