package com.xst.loreportalenchantplugin.listeners.Enchantment_Bench_Listeners.ItemStacks

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class `ItemStacks-Enchantment-Bench` {
    fun ItemStacks_1(): ItemStack {
        val equipArmourButton = ItemStack(Material.DIAMOND_CHESTPLATE)
        val equipArmourButton_meta = equipArmourButton.itemMeta
        equipArmourButton_meta?.setDisplayName("${ChatColor.BLUE}Equip Armour")
        equipArmourButton.setItemMeta(equipArmourButton_meta)
        return equipArmourButton;
    }
    fun ItemStacks_2(): ItemStack {
        val closeButton = ItemStack(Material.BARRIER)
        val closeButton_meta = closeButton.itemMeta
        closeButton_meta?.setDisplayName("${ChatColor.RED}Close")
        closeButton.setItemMeta(closeButton_meta)
        return closeButton
    }
    fun ItemStacks_3(): ItemStack{
        val LP_Blank = ItemStack(Material.PURPLE_STAINED_GLASS_PANE)
        val LP_Blank_Meta = LP_Blank.itemMeta
        LP_Blank_Meta?.setDisplayName("")
        LP_Blank.setItemMeta(LP_Blank_Meta)
        return LP_Blank
    }
    fun ItemStacks_4(): ItemStack{
        val LP_Blank = ItemStack(Material.BLACK_STAINED_GLASS_PANE)
        val LP_Blank_Meta = LP_Blank.itemMeta
        LP_Blank_Meta?.setDisplayName("")
        LP_Blank.setItemMeta(LP_Blank_Meta)
        return LP_Blank
    }
}