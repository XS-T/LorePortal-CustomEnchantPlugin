package com.xst.loreportalenchantplugin.listeners

import com.xst.loreportalenchantplugin.LorePortalEnchantPlugin
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class InventoryClickEvent : Listener {
    @EventHandler
    fun inventoryClickEvent(event: InventoryClickEvent){
        val player = event.whoClicked
        val playerUUID = event.whoClicked.uniqueId

        if(event.inventory == LorePortalEnchantPlugin.guiMap[playerUUID]) {
            if (event.currentItem == null) return


            when (event.currentItem!!.type) {
                Material.DIAMOND_CHESTPLATE -> {
                    player.inventory.helmet = ItemStack(Material.DIAMOND_HELMET)
                    player.inventory.chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
                    player.inventory.leggings = ItemStack(Material.DIAMOND_LEGGINGS)
                    player.inventory.boots = ItemStack(Material.DIAMOND_BOOTS)
                    event.isCancelled = true

                    player.closeInventory()
                }

                Material.BARRIER -> {
                    event.isCancelled = true
                    //player.closeInventory()
                    player.sendMessage("HOLLAAAAA")
                }

                else -> {/*event.isCancelled = true*/}
            }
            if(event.view.title == "${ChatColor.DARK_GRAY}Inventory"){
                if(event.clickedInventory == LorePortalEnchantPlugin.guiMap[playerUUID]){
                    event.isCancelled = true
                }

            }
        }
    }
}