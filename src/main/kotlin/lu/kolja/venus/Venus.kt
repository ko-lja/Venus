package lu.kolja.venus

import org.bstats.bukkit.Metrics
import org.bukkit.plugin.java.JavaPlugin

class Venus : JavaPlugin() {

    lateinit var metrics: Metrics

    override fun onEnable() {
        metrics = Metrics(this, 25735)

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
}
