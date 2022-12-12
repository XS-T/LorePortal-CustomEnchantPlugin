package com.xst.loreportalenchantplugin.CustomEnchants

import com.xst.loreportalenchantplugin.LorePortalEnchantPlugin
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentTarget
import org.bukkit.inventory.ItemStack

class GlowEnchant(namespace: String?) : Enchantment(NamespacedKey(LorePortalEnchantPlugin.plugin, namespace.toString())){

    override fun getName(): String {
        return "Glow"
    }


    override fun getMaxLevel(): Int {
        return 2
    }

    override fun getStartLevel(): Int {
        return 1
    }

    override fun getItemTarget(): EnchantmentTarget {
        return EnchantmentTarget.ARMOR
    }

    override fun isTreasure(): Boolean {
        return false
    }

    override fun isCursed(): Boolean {
        return false
    }

    override fun conflictsWith(other: Enchantment): Boolean {
        return false
    }

    override fun canEnchantItem(item: ItemStack): Boolean {
        return true
    }
}