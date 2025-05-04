package lu.kolja.venus.api.provider

/**
 * Base interface for all service providers in Venus.
 */
interface Provider {
    /**
     * Gets the name of this service provider.
     *
     * @return Provider name
     */
    val name: String

    /**
     * Checks if this provider is enabled.
     *
     * @return true if this provider is enabled
     */
    val isEnabled: Boolean
}