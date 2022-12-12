package com.xst.loreportalenchantplugin.listeners.Enchantment_Bench_Listeners

import com.xst.loreportalenchantplugin.LorePortalEnchantPlugin
import com.xst.loreportalenchantplugin.listeners.Enchantment_Bench_Listeners.ItemStacks.`ItemStacks-Enchantment-Bench` as It
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.block.TileState
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.persistence.PersistentDataType

class `EnchantMent-Bench_Open` : Listener {
    @EventHandler
    fun onChestOpen(event: PlayerInteractEvent){
        val inventory = Bukkit.createInventory(event.player, 54, "${ChatColor.LIGHT_PURPLE}Enchantment-Bench")
        if(!event.hasBlock())
            return
        if (event.clickedBlock?.type != Material.ENCHANTING_TABLE)
            return
        if(!(event.clickedBlock?.state is TileState))
            return println("This doesn't have a block state")

        val state = event.clickedBlock?.state as TileState
        val container = state.persistentDataContainer

        val nsk = NamespacedKey(LorePortalEnchantPlugin.plugin,"EnchantmentBench")
        if(!container.has(nsk, PersistentDataType.STRING))
            return

        if(event.player.uniqueId.toString().equals(container.get(nsk, PersistentDataType.STRING),ignoreCase = true)){
            if(event.action == Action.RIGHT_CLICK_BLOCK){
                val player = event.player
                if(player.itemInHand.type == Material.AIR){
                    event.isCancelled = true
                    //Border 3 = PurpleStainedGlass 4=BlackStainedGlass
                    inventory.setItem(0,It().ItemStacks_3())
                    inventory.setItem(1,It().ItemStacks_4())
                    inventory.setItem(2,It().ItemStacks_3())
                    inventory.setItem(3,It().ItemStacks_4())
                    inventory.setItem(4,It().ItemStacks_3())
                    inventory.setItem(5,It().ItemStacks_4())
                    inventory.setItem(6,It().ItemStacks_3())
                    inventory.setItem(7,It().ItemStacks_4())
                    inventory.setItem(8,It().ItemStacks_3())
                    inventory.setItem(9,It().ItemStacks_4())
                    inventory.setItem(17,It().ItemStacks_3())
                    inventory.setItem(18,It().ItemStacks_4())
                    inventory.setItem(26,It().ItemStacks_3())
                    inventory.setItem(27,It().ItemStacks_4())
                    inventory.setItem(35,It().ItemStacks_3())
                    inventory.setItem(36,It().ItemStacks_4())
                    inventory.setItem(44,It().ItemStacks_3())
                    inventory.setItem(45,It().ItemStacks_4())
                    inventory.setItem(46,It().ItemStacks_3())
                    inventory.setItem(47,It().ItemStacks_4())
                    inventory.setItem(48,It().ItemStacks_3())
                    inventory.setItem(49,It().ItemStacks_4())
                    inventory.setItem(50,It().ItemStacks_3())
                    inventory.setItem(51,It().ItemStacks_4())
                    inventory.setItem(52,It().ItemStacks_3())




                    inventory.setItem(53,It().ItemStacks_2())
                    LorePortalEnchantPlugin.guiMap[player.uniqueId] = inventory
                    player.openInventory(inventory)
                }else{
                    event.isCancelled = true
                    LorePortalEnchantPlugin.guiMap[player.uniqueId] = inventory
                    //player.sendMessage("There is Somthing Wrong")
                }
            }
        } else{
            event.isCancelled = true
            event.player.sendMessage("You Can not open another players Enchantment-Bench")
        }
    }
}

