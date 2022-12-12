package com.xst.loreportalenchantplugin.listeners

import com.xst.loreportalenchantplugin.LorePortalEnchantPlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

class inventory_close_listener : Listener {
    @EventHandler
    fun inventoryCloseEvent(event: InventoryCloseEvent){
        val playerUUID = event.player.uniqueId

        if(LorePortalEnchantPlugin.guiMap.containsKey(playerUUID)) LorePortalEnchantPlugin.guiMap.remove(playerUUID)
    }
}