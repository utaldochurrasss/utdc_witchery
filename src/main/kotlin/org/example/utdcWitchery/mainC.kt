package org.example.utdcWitchery

import io.papermc.paper.event.inventory.ItemCraftedEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.inventory.CraftingRecipe
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin
import javax.xml.stream.events.Namespace
import org.bukkit.event.Listener
import org.bukkit.inventory.ShapelessRecipe
import org.bukkit.potion.PotionType
import org.bukkit.inventory.meta.PotionMeta

class mainC : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic

        // recursos

        ShapelessRecipe(NamespacedKey(this,"elixir_p"), ItemStack(Material.LINGERING_POTION).apply {

            val meta = itemMeta as PotionMeta

            meta.displayName(Component.text("Elixir primário").color(NamedTextColor.LIGHT_PURPLE))
            meta.basePotionType = PotionType.WATER

            itemMeta = meta
        }).apply {
            addIngredient(ItemStack(Material.POTION).apply {
                val meta = itemMeta as PotionMeta
                meta.basePotionType = PotionType.WATER
                itemMeta = meta
            })
            addIngredient(Material.GUNPOWDER)
            addIngredient(Material.GLOWSTONE_DUST)
            addIngredient(Material.SUGAR)

            Bukkit.addRecipe(this)
        }


        // Runes
        ShapedRecipe(NamespacedKey(this, "c_goldRune"), ItemStack(Material.CHISELED_SANDSTONE).apply {
            val meta = itemMeta
            meta.displayName(Component.text("Runa de ouro").color(NamedTextColor.GOLD))
            meta.lore(listOf(Component.text("É capaz de transformar ferro em ouro")))
            meta.setEnchantmentGlintOverride(true)
            itemMeta = meta
        }).apply {
            shape(
                "DSG",
                "S@S",
                "GSD"

            )
            setIngredient('@', Material.GOLD_BLOCK)
            setIngredient('D', Material.GUNPOWDER)
            setIngredient('S', Material.SANDSTONE)
            setIngredient('G', Material.GLOWSTONE_DUST)

            Bukkit.addRecipe(this)
        }

        ShapedRecipe(NamespacedKey(this, "c_emeraldRune"), ItemStack(Material.CHISELED_POLISHED_BLACKSTONE).apply {
            val meta = itemMeta
            meta.displayName(Component.text("Runa de esmeralda").color(NamedTextColor.GREEN))
            meta.lore(listOf(Component.text("É capaz de transformar ouro em esmeralda")))
            meta.setEnchantmentGlintOverride(true)
            itemMeta = meta
        }).apply {
            shape(
                "%bg",
                "beb",
                "gb%"

            )
            setIngredient('e', Material.EMERALD_BLOCK)
            setIngredient('b', Material.BLACKSTONE)
            setIngredient('g', Material.GHAST_TEAR)
            setIngredient('%', Material.PRISMARINE_SHARD)

            Bukkit.addRecipe(this)
        }

        ShapedRecipe(NamespacedKey(this, "c_diamondRune"), ItemStack(Material.PRISMARINE_BRICKS).apply {
            val meta = itemMeta
            meta.displayName(Component.text("Runa de diamante").color(NamedTextColor.AQUA))
            meta.lore(listOf(Component.text("É capaz de transformar esmeralda em diamante")))
            meta.setEnchantmentGlintOverride(true)
            itemMeta = meta
        }).apply {
            shape(
                "DSG",
                "S@S",
                "GSD"

            )
            setIngredient('@', Material.DIAMOND_BLOCK)
            setIngredient('D', Material.ENDER_EYE)
            setIngredient('S', Material.PRISMARINE)
            setIngredient('G', Material.ANCIENT_DEBRIS)

            Bukkit.addRecipe(this)
        }

        // Transmutações

        ShapedRecipe(NamespacedKey("c_witch","t_gold"), ItemStack(Material.GOLD_INGOT, 8)).apply {
            shape(
                "III",
                "I%I",
                "III"
            )

            setIngredient('I', Material.IRON_BLOCK)

            setIngredient('%', ItemStack(Material.CHISELED_SANDSTONE).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de ouro").color(NamedTextColor.GOLD))
                meta.lore(listOf(Component.text("É capaz de transformar ferro em ouro")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
            Bukkit.addRecipe(this)
        }


        ShapedRecipe(NamespacedKey("c_witch","t_emerald"), ItemStack(Material.EMERALD, 8)).apply {
            shape(
                "III",
                "I%I",
                "III"
            )

            setIngredient('I', Material.GOLD_BLOCK)

            setIngredient('%', ItemStack(Material.CHISELED_POLISHED_BLACKSTONE).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de esmeralda").color(NamedTextColor.GREEN))
                meta.lore(listOf(Component.text("É capaz de transformar ouro em esmeralda")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
            Bukkit.addRecipe(this)
        }

        ShapedRecipe(NamespacedKey("c_witch","t_diamond"), ItemStack(Material.DIAMOND, 8)).apply {
            shape(
                "III",
                "I%I",
                "III"
            )

            setIngredient('I', Material.EMERALD_BLOCK)

            setIngredient('%', ItemStack(Material.PRISMARINE_BRICKS).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de diamante").color(NamedTextColor.AQUA))
                meta.lore(listOf(Component.text("É capaz de transformar esmeralda em diamante")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
            Bukkit.addRecipe(this)
        }

        // simplificado


        ShapedRecipe(NamespacedKey("c_witch","st_gold"), ItemStack(Material.GOLD_INGOT, 1)).apply {
            shape(
                "   ",
                " %I",
                "   "
            )

            setIngredient('I', Material.IRON_BLOCK)

            setIngredient('%', ItemStack(Material.CHISELED_SANDSTONE).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de ouro").color(NamedTextColor.GOLD))
                meta.lore(listOf(Component.text("É capaz de transformar ferro em ouro")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
            Bukkit.addRecipe(this)
        }

        ShapedRecipe(NamespacedKey("c_witch","st_emerald"), ItemStack(Material.EMERALD, 1)).apply {
            shape(
                "   ",
                " %I",
                "   "
            )

            setIngredient('I', Material.GOLD_BLOCK)

            setIngredient('%', ItemStack(Material.CHISELED_POLISHED_BLACKSTONE).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de esmeralda").color(NamedTextColor.GREEN))
                meta.lore(listOf(Component.text("É capaz de transformar ouro em esmeralda")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
            Bukkit.addRecipe(this)
        }

        ShapedRecipe(NamespacedKey("c_witch","st_diamond"), ItemStack(Material.DIAMOND, 1)).apply {
            shape(
                "   ",
                " %I",
                "   "
            )

            setIngredient('I', Material.EMERALD_BLOCK)

            setIngredient('%', ItemStack(Material.PRISMARINE_BRICKS).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de diamante").color(NamedTextColor.AQUA))
                meta.lore(listOf(Component.text("É capaz de transformar esmeralda em diamante")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
            Bukkit.addRecipe(this)
        }


        server.pluginManager.registerEvents(L_Gold(), this)
        server.pluginManager.registerEvents(L_Emerald(), this)
        server.pluginManager.registerEvents(SL_Gold(), this)
        server.pluginManager.registerEvents(SL_Emerald(), this)
        server.pluginManager.registerEvents(L_Diamond(), this)
        server.pluginManager.registerEvents(SL_Diamond(), this)

    }



    class L_Gold : Listener {
        private val keyGT = NamespacedKey("c_witch", "t_gold")

        @EventHandler
        fun onCraft(event: CraftItemEvent) {
            val recipe = event.recipe as? CraftingRecipe ?: return

            if (recipe.key != keyGT) return

            val player = event.whoClicked as Player

            player.inventory.addItem(ItemStack(Material.CHISELED_SANDSTONE).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de ouro").color(NamedTextColor.GOLD))
                meta.lore(listOf(Component.text("É capaz de transformar ferro em ouro")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
        }
    }

    class L_Emerald : Listener {
        private val keyGT = NamespacedKey("c_witch", "t_emerald")

        @EventHandler
        fun onCraft(event: CraftItemEvent) {
            val recipe = event.recipe as? CraftingRecipe ?: return

            if (recipe.key != keyGT) return

            val player = event.whoClicked as Player

            player.inventory.addItem(ItemStack(Material.CHISELED_POLISHED_BLACKSTONE).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de esmeralda").color(NamedTextColor.GREEN))
                meta.lore(listOf(Component.text("É capaz de transformar ouro em esmeralda")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
        }
    }
    class SL_Emerald : Listener {
        private val keyGT = NamespacedKey("c_witch", "st_emerald")

        @EventHandler
        fun onCraft(event: CraftItemEvent) {
            val recipe = event.recipe as? CraftingRecipe ?: return

            if (recipe.key != keyGT) return

            val player = event.whoClicked as Player

            player.inventory.addItem(ItemStack(Material.CHISELED_POLISHED_BLACKSTONE).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de esmeralda").color(NamedTextColor.GREEN))
                meta.lore(listOf(Component.text("É capaz de transformar ouro em esmeralda")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
        }
    }
    class SL_Gold : Listener {
        private val keyGT = NamespacedKey("c_witch", "st_gold")

        @EventHandler
        fun onCraft(event: CraftItemEvent) {
            val recipe = event.recipe as? CraftingRecipe ?: return

            if (recipe.key != keyGT) return

            val player = event.whoClicked as Player

            player.inventory.addItem(ItemStack(Material.CHISELED_SANDSTONE).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de ouro").color(NamedTextColor.GOLD))
                meta.lore(listOf(Component.text("É capaz de transformar ferro em ouro")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
        }
    }

    class L_Diamond : Listener {
        private val keyGT = NamespacedKey("c_witch", "t_diamond")

        @EventHandler
        fun onCraft(event: CraftItemEvent) {
            val recipe = event.recipe as? CraftingRecipe ?: return

            if (recipe.key != keyGT) return

            val player = event.whoClicked as Player

            player.inventory.addItem(ItemStack(Material.PRISMARINE_BRICKS).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de diamante").color(NamedTextColor.AQUA))
                meta.lore(listOf(Component.text("É capaz de transformar esmeralda em diamante")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
        }
    }

    class SL_Diamond : Listener {
        private val keyGT = NamespacedKey("c_witch", "st_diamond")

        @EventHandler
        fun onCraft(event: CraftItemEvent) {
            val recipe = event.recipe as? CraftingRecipe ?: return

            if (recipe.key != keyGT) return

            val player = event.whoClicked as Player

            player.inventory.addItem(ItemStack(Material.PRISMARINE_BRICKS).apply {
                val meta = itemMeta
                meta.displayName(Component.text("Runa de diamante").color(NamedTextColor.AQUA))
                meta.lore(listOf(Component.text("É capaz de transformar esmeralda em diamante")))
                meta.setEnchantmentGlintOverride(true)
                itemMeta = meta
            })
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
