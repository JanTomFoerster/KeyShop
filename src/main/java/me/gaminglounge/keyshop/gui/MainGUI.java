package me.gaminglounge.keyshop.gui;

import me.gaminglounge.keyshop.commands.GiveKeyFragments;
import me.gaminglounge.keyshop.utility.ItemCreator;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class MainGUI implements InventoryHolder{

    private Inventory mainGUI;
    ItemCreator itemCreator = new ItemCreator();
    MiniMessage mm = MiniMessage.miniMessage();

    public MainGUI(Player p) {
        if (p == null) return;
        this.mainGUI = Bukkit.createInventory(this, (5 * 9), Component.text("Nexus"));

        int[] placeholder = {0,1,2,3,5,6,7,8,9,17,18,26,27,35,36,37,38,39,41,42,43,44};
        for (int a : placeholder) {
            mainGUI.setItem(a, itemCreator.createItem(Material.BLACK_STAINED_GLASS_PANE,
                    0, false, Component.text("")));
        }

        int keyShards;
        PersistentDataContainer container = p.getPersistentDataContainer();
        if (container.has(GiveKeyFragments.keyFragments, PersistentDataType.INTEGER)) {
            keyShards = container.get(GiveKeyFragments.keyFragments, PersistentDataType.INTEGER);
        } else {
            keyShards = 0;
        }
        List<Component> lore = new ArrayList<>();
        lore.add(mm.deserialize("<aqua>Schlüssel<gray>-<aqua>Fragmente<gray>: <red><bold><count>",
                Placeholder.component("count", Component.text(keyShards))));


        mainGUI.setItem(4, itemCreator.playerhead(p, 0, lore));

        mainGUI.setItem(40, itemCreator.createItem(Material.BARRIER, 1, false,
                mm.deserialize("<red>Schließen")));
    }

    @Override
    public @NotNull Inventory getInventory() {
        return mainGUI;
    }
}
