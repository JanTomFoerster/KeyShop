package me.gaminglounge.keyshop.utility;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import me.gaminglounge.keyshop.listener.InventoryClick;
import java.util.List;

public class ItemCreator {

    /**
     * @param material
     * @param persistentDataIsClickedID used in ClickEvent
     * @param glint
     * @param displayName Component.text
     * @param lore List of Component lore; lore.add(Component.text)
     * @return the Item
     */
    public ItemStack createItem(Material material, int persistentDataIsClickedID, boolean glint, Component displayName, List<Component> lore ) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(displayName);
        meta.lore(lore);
        if (glint) {
            meta.addEnchant(Enchantment.DURABILITY, 10, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        meta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.getPersistentDataContainer().set(InventoryClick.isInventoryClickEvent, PersistentDataType.INTEGER, persistentDataIsClickedID);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack createItem(Material material, int persistentDataIsClickedID, boolean glint, Component displayName) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(displayName);
        if (glint) {
            meta.addEnchant(Enchantment.DURABILITY, 10, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        meta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.getPersistentDataContainer().set(InventoryClick.isInventoryClickEvent, PersistentDataType.INTEGER, persistentDataIsClickedID);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack createItem(Material material, int persistentDataIsClickedID, boolean glint) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (glint) {
            meta.addEnchant(Enchantment.DURABILITY, 10, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        meta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.getPersistentDataContainer().set(InventoryClick.isInventoryClickEvent, PersistentDataType.INTEGER, persistentDataIsClickedID);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack createItem(Material material, int persistentDataIsClickedID) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        meta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.getPersistentDataContainer().set(InventoryClick.isInventoryClickEvent, PersistentDataType.INTEGER, persistentDataIsClickedID);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack createItem(Material material) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        meta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack playerhead(Player p, int persistentDataIsClickedID, List<Component> lore){
        ItemStack head= new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setPlayerProfile(p.getPlayerProfile());
        skullMeta.lore(lore);
        skullMeta.getPersistentDataContainer().set(InventoryClick.isInventoryClickEvent,
                PersistentDataType.INTEGER, persistentDataIsClickedID);
        head.setItemMeta(skullMeta);
        return head;
    }


    public ItemStack playerhead(Player p, int persistentDataIsClickedID){
        ItemStack head= new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setPlayerProfile(p.getPlayerProfile());
        skullMeta.getPersistentDataContainer().set(InventoryClick.isInventoryClickEvent,
                PersistentDataType.INTEGER, persistentDataIsClickedID);
        head.setItemMeta(skullMeta);
        return head;
    }

    public ItemStack playerhead(Player p, List<Component> lore){
        ItemStack head= new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setPlayerProfile(p.getPlayerProfile());
        skullMeta.lore(lore);
        head.setItemMeta(skullMeta);
        return head;
    }

    public ItemStack playerhead(Player p){
        ItemStack head= new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setPlayerProfile(p.getPlayerProfile());
        head.setItemMeta(skullMeta);
        return head;
    }
}