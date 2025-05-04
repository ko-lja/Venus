package lu.kolja.venus

import org.bukkit.plugin.java.JavaPlugin

/**
 * Main plugin class for Venus.
 * Venus is a service provider API for Bukkit plugins, similar to Vault.
 */
class Venus : JavaPlugin() {

    override fun onEnable() {
        logger.info("Venus v${description.version} enabled")
        logger.info("Venus is a service provider API for Bukkit plugins")
        logger.info("For more information, visit: https://github.com/ko-lja/Venus")
    }

    override fun onDisable() {
        logger.info("Venus v${description.version} disabled")
    }

    companion object {
        /**
         * Gets the instance of the Venus plugin.
         *
         * @return Venus plugin instance
         */
        lateinit var instance: Venus
            private set
    }

    init {
        instance = this
    }
}
