package lu.kolja.venus.api.economy

/**
 * The main economy API for Venus.
 * This interface provides methods for managing player balances and economies.
 */
interface Economy {
    /**
     * Checks if economy service is enabled.
     *
     * @return true if the economy service is enabled
     */
    val isEnabled: Boolean

    /**
     * Gets name of economy service provider.
     *
     * @return name of the economy service provider
     */
    val name: String

    /**
     * Format the amount into a human-readable String format.
     *
     * @param amount to format
     * @return Human-readable formatted string
     */
    fun format(amount: Double): String

    /**
     * Returns the name of the currency in plural form.
     * If the economy doesn't support currency names, an empty string will be returned.
     *
     * @return name of the currency (plural)
     */
    val currencyNamePlural: String

    /**
     * Returns the name of the currency in singular form.
     * If the economy doesn't support currency names, an empty string will be returned.
     *
     * @return name of the currency (singular)
     */
    val currencyNameSingular: String

    /**
     * Checks if this economy implementation has a currency.
     *
     * @return true if this economy implementation has a currency
     */
    fun hasCurrency(): Boolean = currencyNamePlural.isNotEmpty() || currencyNameSingular.isNotEmpty()

    /**
     * Gets balance of a player.
     *
     * @param playerName player name
     * @return balance of the player
     */
    fun getBalance(playerName: String): Double

    /**
     * Checks if the player has at least the specified amount of money.
     *
     * @param playerName player name
     * @param amount amount to check for
     * @return true if the player has at least the specified amount
     */
    fun has(playerName: String, amount: Double): Boolean

    /**
     * Withdraws an amount from a player.
     *
     * @param playerName player name
     * @param amount amount to withdraw
     * @return response indicating success or failure
     */
    fun withdrawPlayer(playerName: String, amount: Double): EconomyResponse

    /**
     * Deposits an amount to a player.
     *
     * @param playerName player name
     * @param amount amount to deposit
     * @return response indicating success or failure
     */
    fun depositPlayer(playerName: String, amount: Double): EconomyResponse

    /**
     * Creates a player account.
     *
     * @param playerName player name
     * @return true if the account was created
     */
    fun createPlayerAccount(playerName: String): Boolean

    /**
     * Checks if a player has an account.
     *
     * @param playerName player name
     * @return true if the player has an account
     */
    fun hasAccount(playerName: String): Boolean
}