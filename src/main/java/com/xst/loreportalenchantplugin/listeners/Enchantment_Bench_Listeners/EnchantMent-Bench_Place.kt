package com.xst.loreportalenchantplugin.listeners.Enchantment_Bench_Listeners

import com.xst.loreportalenchantplugin.LorePortalEnchantPlugin
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.block.TileState
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class `EnchantMent-Bench_Place` : Listener {
    @EventHandler
    fun onPlace(event: BlockPlaceEvent){
        if (event.block.type != Material.ENCHANTING_TABLE)
            return
        if(!(event.block.state is TileState))
            return println("This block doesn't have a tile state")

        val state = event.block.state as TileState
        val container = state.persistentDataContainer

        val nsk = NamespacedKey(LorePortalEnchantPlugin.plugin,"EnchantmentBench")
        val player = event.player

        //CustomEnchantment-Table
        val CET = ItemStack(Material.ENCHANTING_TABLE)
        val CET_meta = CET.itemMeta
        CET_meta?.setDisplayName("${ChatColor.LIGHT_PURPLE}Enchatment-Bench")
        CET.setItemMeta(CET_meta)

        if(player.inventory.itemInMainHand.itemMeta?.displayName == "${ChatColor.LIGHT_PURPLE}Enchatment-Bench"){
        container.set(nsk, PersistentDataType.STRING, event.player.uniqueId.toString())
        state.update()
        //event.player.sendMessage("${ChatColor.LIGHT_PURPLE}")
    }else{
        event.player.sendMessage(player.inventory.itemInMainHand.toString())
    }
  }
}