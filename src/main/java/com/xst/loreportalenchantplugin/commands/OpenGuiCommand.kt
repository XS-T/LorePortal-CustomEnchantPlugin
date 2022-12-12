package com.xst.loreportalenchantplugin.commands

import com.xst.loreportalenchantplugin.LorePortalEnchantPlugin
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class OpenGuiCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false
        val inventory = Bukkit.createInventory(sender,9,"${ChatColor.GREEN}Enchants")
        val player = sender

        //Item-Stack
        val equipArmourButton = ItemStack(Material.DIAMOND_CHESTPLATE)
        val equipArmourButton_meta = equipArmourButton.itemMeta
        equipArmourButton_meta?.setDisplayName("${ChatColor.BLUE}Equip Armour")
        equipArmourButton.setItemMeta(equipArmourButton_meta)

        val closeButton = ItemStack(Material.BARRIER)
        val closeButton_meta = closeButton.itemMeta
        closeButton_meta?.setDisplayName("${ChatColor.RED}Close")
        closeButton.setItemMeta(closeButton_meta)

        inventory.setItem(3,equipArmourButton)
        inventory.setItem(5,closeButton)

        LorePortalEnchantPlugin.guiMap[player.uniqueId] = inventory

        player.openInventory(inventory)
        return true
    }
}