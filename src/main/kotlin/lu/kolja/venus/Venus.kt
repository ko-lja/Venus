package lu.kolja.venus

import org.bstats.bukkit.Metrics
import org.bukkit.plugin.java.JavaPlugin

object Venus : JavaPlugin() {

    lateinit var metrics: Metrics

    override fun onEnable() {
        metrics = Metrics(this, 25735)
    }

    override fun onDisable() {}
}
