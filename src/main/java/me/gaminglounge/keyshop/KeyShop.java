package me.gaminglounge.keyshop;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import me.gaminglounge.keyshop.commands.GiveKeyFragments;
import me.gaminglounge.keyshop.commands.OpenMainGui;
import me.gaminglounge.keyshop.listener.InventoryClick;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class KeyShop extends JavaPlugin {

    public static KeyShop INSTANCE;
    public static String PREFIX;
    public Logger logger;

    @Override
    public void onLoad() {
        INSTANCE = this;
        PREFIX = "[KeyShop] ";

        this.logger = this.getLogger();

        CommandAPI.onLoad(new CommandAPIBukkitConfig(this));
        new GiveKeyFragments();
        new OpenMainGui();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandAPI.onEnable();

        this.listener();

        logger.log(Level.INFO, "Plugin activated!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        CommandAPI.onDisable();

        logger.log(Level.INFO, "Plugin disabled!");
    }

    public void listener() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new InventoryClick(), this);
    }
}
