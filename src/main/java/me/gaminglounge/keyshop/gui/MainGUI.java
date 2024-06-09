package me.gaminglounge.keyshop.gui;

import me.gaminglounge.keyshop.commands.GiveKeyFragments;
import me.gaminglounge.keyshop.utility.ItemCreator;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
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
        this.mainGUI = Bukkit.createInventory(this, (5 * 9), Component.text("Key-Shop"));

        int[] placeholder = {0,1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,23,26,27,28,29,30,31,32,33,34,35,36,37,38,39,41,42,43,44};
        for (int a : placeholder) {
            mainGUI.setItem(a, itemCreator.createItem(Material.GRAY_STAINED_GLASS_PANE,
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
        lore.add(mm.deserialize("<reset><aqua>Schlüssel<gray>-<aqua>Fragmente<gray>: <red><bold><count>",
                Placeholder.component("count", Component.text(keyShards)))
                .decoration(TextDecoration.ITALIC, false));

        List<Component> lore_claim = new ArrayList<>();
        lore_claim.add(mm.deserialize("<reset><gold>2 <aqua>Schlüssel<gray>-<aqua>Fragmente")
                .decoration(TextDecoration.ITALIC, false));

        List<Component> lore_resource = new ArrayList<>();
        lore_resource.add(mm.deserialize("<reset><gold>4 <aqua>Schlüssel<gray>-<aqua>Fragmente")
                .decoration(TextDecoration.ITALIC, false));

        List<Component> lore_spezial = new ArrayList<>();
        lore_spezial.add(mm.deserialize("<reset><gold>6 <aqua>Schlüssel<gray>-<aqua>Fragmente")
                .decoration(TextDecoration.ITALIC, false));

        mainGUI.setItem(4, itemCreator.playerhead(p, 0, lore));

        mainGUI.setItem(40, itemCreator.createItem(Material.BARRIER, 1, false,
                mm.deserialize("<reset><red>Schließen")
                        .decoration(TextDecoration.ITALIC, false)));

        mainGUI.setItem(20, itemCreator.createItem(Material.GREEN_CONCRETE_POWDER,2, true,
                mm.deserialize("<reset><dark_green>Claim <gray>- <gold>Schlüssel")
                        .decoration(TextDecoration.ITALIC, false),lore_claim));

        mainGUI.setItem(22, itemCreator.createItem(Material.BRICKS,3, true,
                mm.deserialize("<reset><aqua>Resource <gray>- <gold>Schlüssel")
                        .decoration(TextDecoration.ITALIC, false),lore_resource));

        mainGUI.setItem(24, itemCreator.createItem(Material.MAGMA_BLOCK,4, true,
                mm.deserialize("<reset><red>Spezial <gray>- <gold>Schlüssel")
                        .decoration(TextDecoration.ITALIC, false),lore_spezial));

    }

    @Override
    public @NotNull Inventory getInventory() {
        return mainGUI;
    }
}
