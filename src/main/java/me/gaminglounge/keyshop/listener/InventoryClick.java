package me.gaminglounge.keyshop.listener;

import me.gaminglounge.keyshop.utility.KeyFragments;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;

public class InventoryClick implements Listener {

    public static final NamespacedKey isInventoryClickEvent = new NamespacedKey("keyshop", "is_inventory_click_event");
    KeyFragments key = new KeyFragments();
    MiniMessage mm = MiniMessage.miniMessage();

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null || e.getCurrentItem().getItemMeta() == null) return;
        if (!e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(isInventoryClickEvent,
                PersistentDataType.INTEGER)) return;
        Player p = (Player) e.getWhoClicked();
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
            case 2:
                e.setCancelled(true);
                if (key.getKeyFragments(p) < 2) {
                    p.sendMessage(mm.deserialize("<red>Du hast leider nicht genug " +
                            "<aqua>Schlüssel<gray>-<aqua>Fragmente<red>, bitte gehe zur <gold>Gilde " +
                            "<red>um mehr zu bekommen."));
                    break;
                }
                key.subtractKeyFragments(p, 2);
                String claim_command = "loot give " + p.getName() + " 549 1";
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), claim_command);
                break;
            case 3:
                e.setCancelled(true);
                if (key.getKeyFragments(p) < 4) {
                    p.sendMessage(mm.deserialize("<red>Du hast leider nicht genug " +
                            "<aqua>Schlüssel<gray>-<aqua>Fragmente<red>, bitte gehe zur <gold>Gilde " +
                            "<red>um mehr zu bekommen."));
                    break;
                }
                key.subtractKeyFragments(p, 4);
                String resource_command = "loot give " + p.getName() + " 129 1";
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), resource_command);
                break;
            case 4:
                e.setCancelled(true);
                if (key.getKeyFragments(p) < 6) {
                    p.sendMessage(mm.deserialize("<red>Du hast leider nicht genug " +
                            "<aqua>Schlüssel<gray>-<aqua>Fragmente<red>, bitte gehe zur <gold>Gilde " +
                            "<red>um mehr zu bekommen."));
                    break;
                }
                key.subtractKeyFragments(p, 6);
                String spezial_command = "loot give " + p.getName() + " 702 1";
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), spezial_command);
                break;
        }
    }

}
