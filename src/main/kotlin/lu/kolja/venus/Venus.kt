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

        // Using multi-dollar string interpolation to create a JSON-like message
        // This demonstrates how to include both literal $ characters and interpolated values
        val repoOwner = "ko-lja"
        val repoName = "Venus"
        logger.info($$"""For more information, visit our GitHub repository:
            |{
            |  "$repoOwner/$repoName": "https://github.com/${repoOwner}/${repoName}",
            |  "license": "GNU Lesser General Public License v3.0",
            |  "version": "${description.version}"
            |}""".trimMargin())
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
