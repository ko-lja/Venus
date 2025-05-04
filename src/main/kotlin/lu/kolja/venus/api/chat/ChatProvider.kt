package lu.kolja.venus.api.chat

import lu.kolja.venus.api.provider.Provider

/**
 * Interface for chat service providers.
 * Implementations of this interface provide chat services through the Chat interface.
 */
interface ChatProvider : Provider, Chat