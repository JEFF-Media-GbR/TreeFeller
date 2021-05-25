package com.minelazz.treefeller.hooks;

import de.jeff_media.drop2inventory.Drop2InventoryAPI;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Wrapper class to access the Drop2Inventory API without shading it into the plugin.
 * It would be better to just shade the API but I saw the pom.xml doesn't include the shade plugin
 * and I also couldn't resolve all the other dependencies, so I decided to just write this wrapper class instead.
 */
public class Drop2InventoryHook {

    public static void addOrDrop(Player player, ItemStack itemStack, Location location) {
        if(Drop2InventoryAPI.hasDropCollectionEnabled(player)) {
            Drop2InventoryAPI.addOrDrop(player, itemStack, location);
        } else {
            location.getWorld().dropItem(location, itemStack);
        }
    }

}
