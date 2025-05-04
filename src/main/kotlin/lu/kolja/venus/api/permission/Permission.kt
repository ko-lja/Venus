package lu.kolja.venus.api.permission

import org.bukkit.entity.Player

/**
 * The main permission API for Venus.
 * This interface provides methods for checking and managing player permissions.
 */
interface Permission {
    /**
     * Checks if permission service is enabled.
     *
     * @return true if the permission service is enabled
     */
    val isEnabled: Boolean

    /**
     * Gets name of permission service provider.
     *
     * @return name of the permission service provider
     */
    val name: String

    /**
     * Checks if a player has a permission.
     *
     * @param player Player to check permission for
     * @param permission Permission node to check
     * @return true if the player has the permission
     */
    fun has(player: Player, permission: String): Boolean

    /**
     * Checks if a player has a permission in the specified world.
     *
     * @param player Player to check permission for
     * @param world World name to check in
     * @param permission Permission node to check
     * @return true if the player has the permission in the specified world
     */
    fun has(player: Player, world: String, permission: String): Boolean

    /**
     * Checks if a player has a permission (by player name).
     *
     * @param playerName Name of the player to check permission for
     * @param permission Permission node to check
     * @return true if the player has the permission
     */
    fun has(playerName: String, permission: String): Boolean

    /**
     * Checks if a player has a permission in the specified world (by player name).
     *
     * @param playerName Name of the player to check permission for
     * @param world World name to check in
     * @param permission Permission node to check
     * @return true if the player has the permission in the specified world
     */
    fun has(playerName: String, world: String, permission: String): Boolean

    /**
     * Adds a permission to a player.
     *
     * @param player Player to add permission to
     * @param permission Permission node to add
     * @return true if the permission was added successfully
     */
    fun playerAdd(player: Player, permission: String): Boolean

    /**
     * Adds a permission to a player in the specified world.
     *
     * @param player Player to add permission to
     * @param world World name
     * @param permission Permission node to add
     * @return true if the permission was added successfully
     */
    fun playerAdd(player: Player, world: String, permission: String): Boolean

    /**
     * Adds a permission to a player (by player name).
     *
     * @param playerName Name of the player to add permission to
     * @param permission Permission node to add
     * @return true if the permission was added successfully
     */
    fun playerAdd(playerName: String, permission: String): Boolean

    /**
     * Adds a permission to a player in the specified world (by player name).
     *
     * @param playerName Name of the player to add permission to
     * @param world World name
     * @param permission Permission node to add
     * @return true if the permission was added successfully
     */
    fun playerAdd(playerName: String, world: String, permission: String): Boolean

    /**
     * Removes a permission from a player.
     *
     * @param player Player to remove permission from
     * @param permission Permission node to remove
     * @return true if the permission was removed successfully
     */
    fun playerRemove(player: Player, permission: String): Boolean

    /**
     * Removes a permission from a player in the specified world.
     *
     * @param player Player to remove permission from
     * @param world World name
     * @param permission Permission node to remove
     * @return true if the permission was removed successfully
     */
    fun playerRemove(player: Player, world: String, permission: String): Boolean

    /**
     * Removes a permission from a player (by player name).
     *
     * @param playerName Name of the player to remove permission from
     * @param permission Permission node to remove
     * @return true if the permission was removed successfully
     */
    fun playerRemove(playerName: String, permission: String): Boolean

    /**
     * Removes a permission from a player in the specified world (by player name).
     *
     * @param playerName Name of the player to remove permission from
     * @param world World name
     * @param permission Permission node to remove
     * @return true if the permission was removed successfully
     */
    fun playerRemove(playerName: String, world: String, permission: String): Boolean

    /**
     * Gets groups that a player is in.
     *
     * @param player Player to get groups for
     * @return Array of group names that the player is in
     */
    fun getPlayerGroups(player: Player): Array<String>

    /**
     * Gets groups that a player is in (by player name).
     *
     * @param playerName Name of the player to get groups for
     * @return Array of group names that the player is in
     */
    fun getPlayerGroups(playerName: String): Array<String>

    /**
     * Gets the primary group of a player.
     *
     * @param player Player to get primary group for
     * @return Name of the primary group
     */
    fun getPrimaryGroup(player: Player): String

    /**
     * Gets the primary group of a player (by player name).
     *
     * @param playerName Name of the player to get primary group for
     * @return Name of the primary group
     */
    fun getPrimaryGroup(playerName: String): String

    /**
     * Returns a list of all known groups.
     *
     * @return Array of group names
     */
    fun getGroups(): Array<String>

    /**
     * Checks if a group has a permission.
     *
     * @param group Group name
     * @param permission Permission node to check
     * @return true if the group has the permission
     */
    fun groupHas(group: String, permission: String): Boolean

    /**
     * Checks if a group has a permission in the specified world.
     *
     * @param group Group name
     * @param world World name
     * @param permission Permission node to check
     * @return true if the group has the permission in the specified world
     */
    fun groupHas(group: String, world: String, permission: String): Boolean

    /**
     * Adds a permission to a group.
     *
     * @param group Group name
     * @param permission Permission node to add
     * @return true if the permission was added successfully
     */
    fun groupAdd(group: String, permission: String): Boolean

    /**
     * Adds a permission to a group in the specified world.
     *
     * @param group Group name
     * @param world World name
     * @param permission Permission node to add
     * @return true if the permission was added successfully
     */
    fun groupAdd(group: String, world: String, permission: String): Boolean

    /**
     * Removes a permission from a group.
     *
     * @param group Group name
     * @param permission Permission node to remove
     * @return true if the permission was removed successfully
     */
    fun groupRemove(group: String, permission: String): Boolean

    /**
     * Removes a permission from a group in the specified world.
     *
     * @param group Group name
     * @param world World name
     * @param permission Permission node to remove
     * @return true if the permission was removed successfully
     */
    fun groupRemove(group: String, world: String, permission: String): Boolean
}