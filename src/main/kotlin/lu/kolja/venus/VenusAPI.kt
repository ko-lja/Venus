package lu.kolja.venus

import lu.kolja.venus.api.chat.Chat
import lu.kolja.venus.api.chat.ChatProvider
import lu.kolja.venus.api.economy.Economy
import lu.kolja.venus.api.economy.EconomyProvider
import lu.kolja.venus.api.permission.Permission
import lu.kolja.venus.api.permission.PermissionProvider
import org.bukkit.Bukkit
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.ServicesManager

/**
 * Main API class for Venus.
 * This class provides methods for registering and accessing service providers.
 */
object VenusAPI {
    private var economyProvider: EconomyProvider? = null
    private var permissionProvider: PermissionProvider? = null
    private var chatProvider: ChatProvider? = null

    /**
     * Gets the economy service.
     *
     * @return Economy service or null if no provider is registered
     */
    val economy: Economy?
        get() = economyProvider

    /**
     * Gets the permission service.
     *
     * @return Permission service or null if no provider is registered
     */
    val permission: Permission?
        get() = permissionProvider

    /**
     * Gets the chat service.
     *
     * @return Chat service or null if no provider is registered
     */
    val chat: Chat?
        get() = chatProvider

    /**
     * Registers an economy provider.
     *
     * @param provider The provider to register
     * @param plugin The plugin registering the provider
     * @param priority The priority of the registration
     * @return true if the provider was registered successfully
     */
    fun registerEconomyProvider(
        provider: EconomyProvider,
        plugin: Venus,
        priority: ServicePriority = ServicePriority.Normal
    ): Boolean {
        when (val currentProvider = economyProvider) {
            is EconomyProvider if currentProvider.isEnabled -> return false
            else -> {
                economyProvider = provider
                registerService(Economy::class.java, provider, plugin, priority)
                registerService(EconomyProvider::class.java, provider, plugin, priority)
                return true
            }
        }
    }

    /**
     * Registers a permission provider.
     *
     * @param provider The provider to register
     * @param plugin The plugin registering the provider
     * @param priority The priority of the registration
     * @return true if the provider was registered successfully
     */
    fun registerPermissionProvider(
        provider: PermissionProvider,
        plugin: Venus,
        priority: ServicePriority = ServicePriority.Normal
    ): Boolean {
        when (val currentProvider = permissionProvider) {
            is PermissionProvider if currentProvider.isEnabled -> return false
            else -> {
                permissionProvider = provider
                registerService(Permission::class.java, provider, plugin, priority)
                registerService(PermissionProvider::class.java, provider, plugin, priority)
                return true
            }
        }
    }

    /**
     * Registers a chat provider.
     *
     * @param provider The provider to register
     * @param plugin The plugin registering the provider
     * @param priority The priority of the registration
     * @return true if the provider was registered successfully
     */
    fun registerChatProvider(
        provider: ChatProvider,
        plugin: Venus,
        priority: ServicePriority = ServicePriority.Normal
    ): Boolean {
        when (val currentProvider = chatProvider) {
            is ChatProvider if currentProvider.isEnabled -> return false
            else -> {
                chatProvider = provider
                registerService(Chat::class.java, provider, plugin, priority)
                registerService(ChatProvider::class.java, provider, plugin, priority)
                return true
            }
        }
    }

    /**
     * Registers a service with the Bukkit services manager.
     *
     * @param serviceClass The class of the service
     * @param provider The provider of the service
     * @param plugin The plugin registering the service
     * @param priority The priority of the registration
     */
    private fun <T : Any> registerService(
        serviceClass: Class<T>,
        provider: T,
        plugin: Venus,
        priority: ServicePriority
    ) {
        servicesManager.register(serviceClass, provider, plugin, priority)
    }

    /**
     * Gets the Bukkit services manager.
     */
    private val servicesManager: ServicesManager
        get() = Bukkit.getServicesManager()
}
