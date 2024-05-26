package me.gaminglounge.keyshop.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


/*
    /key [add/remove/set/count] [player_name] [value]
*/


public class GiveKeyFragments {

    public static final NamespacedKey keyFragments = new NamespacedKey("keyshop", "amount_key_fragments");
    MiniMessage mm = MiniMessage.miniMessage();

    public GiveKeyFragments() {

        new CommandAPICommand("KeyShop:admin")
                .withAliases("keyshop:admin", "ks:admin")
                .withPermission(CommandPermission.OP)
                .withSubcommand(new CommandAPICommand("add")
                        .withArguments(new PlayerArgument("Spieler"))
                        .withArguments(new IntegerArgument("anzahl"))
                        .executes((executor, args) -> {
                            Player p = (Player) args.get("Spieler");
                            int count = (int) args.get("anzahl");

                            PersistentDataContainer container = p.getPersistentDataContainer();
                            int get = 0;
                            if (container.has(keyFragments, PersistentDataType.INTEGER)) {
                                get = container.get(keyFragments, PersistentDataType.INTEGER);
                            }
                            int set = get + count;
                            container.set(keyFragments, PersistentDataType.INTEGER, set);

                            p.sendMessage(mm.deserialize("Dir wurden <gold><count> <red>Schlüsselfragmente<white> gegeben,<br>" +
                                            "du hast nun <gold><set> <red>Schlüsselfragmente<white>.",
                                    Placeholder.component("count", Component.text(count)),
                                    Placeholder.component("set", Component.text(set))
                                    ));
                            if (executor instanceof Player && executor != p) {
                                executor.sendMessage(mm.deserialize("Du hast <green><p> <gold><count>" +
                                                " <red>Schlüsselfragmente<white> gegeben, er hat nun <gold><count> " +
                                                "<white>Schlüsselfragmente.",
                                        Placeholder.component("p", p.teamDisplayName()),
                                        Placeholder.component("count", Component.text(count)),
                                        Placeholder.component("set", Component.text(set))
                                ));
                            }
                        })
                )
                .withSubcommand(new CommandAPICommand("remove")
                        .withArguments(new PlayerArgument("Spieler"))
                        .withArguments(new IntegerArgument("anzahl"))
                        .executes((executor, args) -> {
                            Player p = (Player) args.get("Spieler");
                            int count = (int) args.get("anzahl");

                            PersistentDataContainer container = p.getPersistentDataContainer();
                            int get = 0;
                            if (container.has(keyFragments, PersistentDataType.INTEGER)) {
                                get = container.get(keyFragments, PersistentDataType.INTEGER);
                            }
                            int set = get - count;
                            if (set < 0) set = 0;
                            container.set(keyFragments, PersistentDataType.INTEGER, set);

                            p.sendMessage(mm.deserialize("Dir wurden <gold><count> <red>Schlüsselfragmente<white> entfernt," +
                                            " du hast nun <gold><set> <red>Schlüsselfragmente<white>.",
                                    Placeholder.component("count", Component.text(count)),
                                    Placeholder.component("set", Component.text(set))
                            ));
                            if (executor instanceof Player && executor != p) {
                                executor.sendMessage(mm.deserialize("Du hast <green><p> <gold><count>" +
                                                " <red>Schlüsselfragmente<white> entfernt, er hat nun <gold><count> " +
                                                "<white>Schlüsselfragmente.",
                                        Placeholder.component("p", p.teamDisplayName()),
                                        Placeholder.component("count", Component.text(count)),
                                        Placeholder.component("set", Component.text(set))
                                ));
                            }
                        })
                )
                .withSubcommand(new CommandAPICommand("set")
                        .withArguments(new PlayerArgument("Spieler"))
                        .withArguments(new IntegerArgument("anzahl"))
                        .executes((executor, args) -> {
                            Player p = (Player) args.get("Spieler");
                            int count = (int) args.get("anzahl");

                            PersistentDataContainer container = p.getPersistentDataContainer();
                            container.set(keyFragments, PersistentDataType.INTEGER, count);

                            p.sendMessage(mm.deserialize("Deine <red>Schlüsselfragmente<white> wurden auf <gold><count> <white>gesetzt.",
                                    Placeholder.component("count", Component.text(count))
                            ));
                            if (executor instanceof Player && executor != p) {
                                executor.sendMessage(mm.deserialize("Du hast <green><p> <white>seine" +
                                                " <red>Schlüsselfragmente<white> auf <gold><count> <white> gesetzt.",
                                        Placeholder.component("p", p.teamDisplayName()),
                                        Placeholder.component("count", Component.text(count))
                                ));
                            }
                        })
                )
                .withSubcommand(new CommandAPICommand("count")
                        .withArguments(new PlayerArgument("Spieler"))
                        .executes((executor, args) -> {
                            Player p = (Player) args.get("Spieler");

                            PersistentDataContainer container = p.getPersistentDataContainer();
                            int get = 0;
                            if (container.has(keyFragments, PersistentDataType.INTEGER)) {
                                get = container.get(keyFragments, PersistentDataType.INTEGER);
                            }
                            if (executor instanceof Player && executor != p) {
                                executor.sendMessage(mm.deserialize("Der Spieler <green><p> <white>hat <gold><get><br>" +
                                                "<red>Schlüsselfragmente.",
                                        Placeholder.component("p", p.teamDisplayName()),
                                        Placeholder.component("get", Component.text(get))
                                ));
                            }
                            if (executor instanceof Player && executor == p) {
                                executor.sendMessage(mm.deserialize("Du hast <gold><get> <red>Schlüsselfragmente.",
                                        Placeholder.component("get", Component.text(get))
                                ));

                            }

                        })
                )
                .register();
    }
}
