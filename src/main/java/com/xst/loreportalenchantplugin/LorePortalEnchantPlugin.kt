package com.xst.loreportalenchantplugin

import com.xst.loreportalenchantplugin.CustomEnchants.GlowEnchant
import com.xst.loreportalenchantplugin.commands.enchantment_bench_give_command
import com.xst.loreportalenchantplugin.listeners.Enchantment_Bench_Listeners.`EnchantMent-Bench_Open`
import com.xst.loreportalenchantplugin.listeners.Enchantment_Bench_Listeners.`EnchantMent-Bench_Place`
import com.xst.loreportalenchantplugin.listeners.InventoryClickEvent
import com.xst.loreportalenchantplugin.listeners.inventory_close_listener
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin
import java.lang.reflect.Field
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
        val GlowEnchantment = GlowEnchant("glow")
        registerEnchantment(GlowEnchantment)
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
        //CE-EL

        logger.info("Registerd Listeners!")
    }
    public fun registerEnchantment(enchantment: Enchantment){
        var registered = true
        try{
            val f = Enchantment::class.java.getDeclaredField("acceptingNew")
            f.isAccessible = true
            f.set(null,true)
            Enchantment.registerEnchantment(enchantment)
        }catch (e: Exception){
            registered = false
            e.printStackTrace()

        }
        if(registered){

        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}