package com.xst.loreportalenchantplugin.commands

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class enchantment_bench_give_command : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if(sender is Player){
            val player = sender
            val item_stack = ItemStack(Material.CRAFTING_TABLE,1)
            val item_meta = item_stack.itemMeta
            item_meta?.setDisplayName("${ChatColor.LIGHT_PURPLE}EnchatMent-Bench")
            item_stack.setItemMeta(item_meta)
            player.inventory.addItem(item_stack)
            player.sendMessage("You Have Gained a Special Crafting Table")
        }







        return true
    }
}