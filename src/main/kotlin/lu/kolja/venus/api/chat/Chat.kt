package lu.kolja.venus.api.chat

import org.bukkit.entity.Player

/**
 * The main chat API for Venus.
 * This interface provides methods for managing player chat prefixes, suffixes, and other chat-related functionality.
 */
interface Chat {
    /**
     * Checks if chat service is enabled.
     *
     * @return true if the chat service is enabled
     */
    val isEnabled: Boolean

    /**
     * Gets name of chat service provider.
     *
     * @return name of the chat service provider
     */
    val name: String

    /**
     * Gets a player's prefix.
     *
     * @param player Player to get prefix for
     * @return Player's prefix
     */
    fun getPlayerPrefix(player: Player): String

    /**
     * Gets a player's prefix in the specified world.
     *
     * @param player Player to get prefix for
     * @param world World name
     * @return Player's prefix in the specified world
     */
    fun getPlayerPrefix(player: Player, world: String): String

    /**
     * Gets a player's prefix (by player name).
     *
     * @param playerName Name of the player to get prefix for
     * @return Player's prefix
     */
    fun getPlayerPrefix(playerName: String): String

    /**
     * Gets a player's prefix in the specified world (by player name).
     *
     * @param playerName Name of the player to get prefix for
     * @param world World name
     * @return Player's prefix in the specified world
     */
    fun getPlayerPrefix(playerName: String, world: String): String

    /**
     * Sets a player's prefix.
     *
     * @param player Player to set prefix for
     * @param prefix Prefix to set
     */
    fun setPlayerPrefix(player: Player, prefix: String)

    /**
     * Sets a player's prefix in the specified world.
     *
     * @param player Player to set prefix for
     * @param world World name
     * @param prefix Prefix to set
     */
    fun setPlayerPrefix(player: Player, world: String, prefix: String)

    /**
     * Sets a player's prefix (by player name).
     *
     * @param playerName Name of the player to set prefix for
     * @param prefix Prefix to set
     */
    fun setPlayerPrefix(playerName: String, prefix: String)

    /**
     * Sets a player's prefix in the specified world (by player name).
     *
     * @param playerName Name of the player to set prefix for
     * @param world World name
     * @param prefix Prefix to set
     */
    fun setPlayerPrefix(playerName: String, world: String, prefix: String)

    /**
     * Gets a player's suffix.
     *
     * @param player Player to get suffix for
     * @return Player's suffix
     */
    fun getPlayerSuffix(player: Player): String

    /**
     * Gets a player's suffix in the specified world.
     *
     * @param player Player to get suffix for
     * @param world World name
     * @return Player's suffix in the specified world
     */
    fun getPlayerSuffix(player: Player, world: String): String

    /**
     * Gets a player's suffix (by player name).
     *
     * @param playerName Name of the player to get suffix for
     * @return Player's suffix
     */
    fun getPlayerSuffix(playerName: String): String

    /**
     * Gets a player's suffix in the specified world (by player name).
     *
     * @param playerName Name of the player to get suffix for
     * @param world World name
     * @return Player's suffix in the specified world
     */
    fun getPlayerSuffix(playerName: String, world: String): String

    /**
     * Sets a player's suffix.
     *
     * @param player Player to set suffix for
     * @param suffix Suffix to set
     */
    fun setPlayerSuffix(player: Player, suffix: String)

    /**
     * Sets a player's suffix in the specified world.
     *
     * @param player Player to set suffix for
     * @param world World name
     * @param suffix Suffix to set
     */
    fun setPlayerSuffix(player: Player, world: String, suffix: String)

    /**
     * Sets a player's suffix (by player name).
     *
     * @param playerName Name of the player to set suffix for
     * @param suffix Suffix to set
     */
    fun setPlayerSuffix(playerName: String, suffix: String)

    /**
     * Sets a player's suffix in the specified world (by player name).
     *
     * @param playerName Name of the player to set suffix for
     * @param world World name
     * @param suffix Suffix to set
     */
    fun setPlayerSuffix(playerName: String, world: String, suffix: String)

    /**
     * Gets a group's prefix.
     *
     * @param group Group name
     * @return Group's prefix
     */
    fun getGroupPrefix(group: String): String

    /**
     * Gets a group's prefix in the specified world.
     *
     * @param group Group name
     * @param world World name
     * @return Group's prefix in the specified world
     */
    fun getGroupPrefix(group: String, world: String): String

    /**
     * Sets a group's prefix.
     *
     * @param group Group name
     * @param prefix Prefix to set
     */
    fun setGroupPrefix(group: String, prefix: String)

    /**
     * Sets a group's prefix in the specified world.
     *
     * @param group Group name
     * @param world World name
     * @param prefix Prefix to set
     */
    fun setGroupPrefix(group: String, world: String, prefix: String)

    /**
     * Gets a group's suffix.
     *
     * @param group Group name
     * @return Group's suffix
     */
    fun getGroupSuffix(group: String): String

    /**
     * Gets a group's suffix in the specified world.
     *
     * @param group Group name
     * @param world World name
     * @return Group's suffix in the specified world
     */
    fun getGroupSuffix(group: String, world: String): String

    /**
     * Sets a group's suffix.
     *
     * @param group Group name
     * @param suffix Suffix to set
     */
    fun setGroupSuffix(group: String, suffix: String)

    /**
     * Sets a group's suffix in the specified world.
     *
     * @param group Group name
     * @param world World name
     * @param suffix Suffix to set
     */
    fun setGroupSuffix(group: String, world: String, suffix: String)
}