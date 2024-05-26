package me.gaminglounge.keyshop.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import me.gaminglounge.keyshop.gui.MainGUI;


/*
    /keyshop:open
*/


public class OpenMainGui {

    public OpenMainGui() {

        new CommandAPICommand("KeyShop:open")
                .withAliases("keyshop:open", "ks:open", "keyshopopen")
                .withPermission(CommandPermission.OP)
                .executesPlayer((player, args) -> {
                    MainGUI mainGUI = new MainGUI(player);
                    player.openInventory(mainGUI.getInventory());
                })
                .register();

    }
}
