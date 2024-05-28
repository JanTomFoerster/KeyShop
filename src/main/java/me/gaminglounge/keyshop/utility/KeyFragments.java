package me.gaminglounge.keyshop.utility;

import me.gaminglounge.keyshop.commands.GiveKeyFragments;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class KeyFragments {

    public int getKeyFragments(Player p) {

        PersistentDataContainer container = p.getPersistentDataContainer();
        int get = 0;
        if (container.has(GiveKeyFragments.keyFragments, PersistentDataType.INTEGER)) {
            get = container.get(GiveKeyFragments.keyFragments, PersistentDataType.INTEGER);
        }
        return get;

    }

    public void setKeyFragments(Player p, int set) {

        PersistentDataContainer container = p.getPersistentDataContainer();
        container.set(GiveKeyFragments.keyFragments, PersistentDataType.INTEGER, set);

    }

    public void addKeyFragments(Player p, int add) {

        int get = getKeyFragments(p);
        int set = get + add;
        setKeyFragments(p, set);

    }

    public void subtractKeyFragments(Player p, int subtract) {

        int get = getKeyFragments(p);
        int set = get - subtract;
        setKeyFragments(p, set);

    }

}
