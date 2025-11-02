package com.semihakin685;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;

public class ItemDurability extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("ItemDurability aktif.");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Item item = player.getInventory().getItemInHand();

        if (item.isTool()) {
            int durability = item.getMaxDurability();
            int damage = item.getDamage();
            int remaining = durability - damage;

            player.sendPopup("§aDurability: §c" + remaining);
        }
    }
}
