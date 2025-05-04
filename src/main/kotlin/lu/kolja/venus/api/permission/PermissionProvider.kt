package lu.kolja.venus.api.permission

import lu.kolja.venus.api.provider.Provider

/**
 * Interface for permission service providers.
 * Implementations of this interface provide permission services through the Permission interface.
 */
interface PermissionProvider : Provider, Permission