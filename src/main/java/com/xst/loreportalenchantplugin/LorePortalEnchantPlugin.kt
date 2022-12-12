package com.xst.loreportalenchantplugin

import com.xst.loreportalenchantplugin.commands.enchantment_bench_give_command
import com.xst.loreportalenchantplugin.listeners.Enchantment_Bench_Listeners.`EnchantMent-Bench_Place`
import com.xst.loreportalenchantplugin.listeners.Enchantment_Bench_Listeners.`EnchantMent-Bench_Open`
import com.xst.loreportalenchantplugin.listeners.inventory_close_listener
import com.xst.loreportalenchantplugin.listeners.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class LorePortalEnchantPlugin : JavaPlugin() {


    companion object {
        lateinit var plugin : LorePortalEnchantPlugin
            private set
        public val guiMap: MutableMap<UUID, Inventory> = mutableMapOf()
    }

    override fun onEnable() {
        // Plugin startup logic
        plugin = this
        registerCommands()
        registerlisteners()
    }

    private fun registerCommands(){
        getCommand("enc")!!.setExecutor(enchantment_bench_give_command())
        logger.info("Registering commands")
    }
    private fun registerlisteners(){
        server.pluginManager.registerEvents(inventory_close_listener(),this)
        server.pluginManager.registerEvents(InventoryClickEvent(),this)
        server.pluginManager.registerEvents(`EnchantMent-Bench_Place`(),this)
        server.pluginManager.registerEvents(`EnchantMent-Bench_Open`(),this)
        logger.info("Registerd Listeners!")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}