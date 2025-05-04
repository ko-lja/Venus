package lu.kolja.venus.api.economy

import lu.kolja.venus.api.provider.Provider

/**
 * Interface for economy service providers.
 * Implementations of this interface provide economy services through the Economy interface.
 */
interface EconomyProvider : Provider, Economy