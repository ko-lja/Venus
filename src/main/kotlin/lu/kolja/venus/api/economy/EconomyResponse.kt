package lu.kolja.venus.api.economy

/**
 * Represents a response from an economy operation.
 *
 * @property amount The amount that was requested for the operation
 * @property balance The new balance after the operation
 * @property type The type of response
 * @property errorMessage Error message if the operation failed, empty string otherwise
 */
data class EconomyResponse(
    val amount: Double,
    val balance: Double,
    val type: ResponseType,
    val errorMessage: String = ""
) {
    /**
     * Indicates whether the operation was successful.
     */
    val transactionSuccess: Boolean
        get() = type == ResponseType.SUCCESS

    /**
     * Enum representing the possible response types for economy operations.
     */
    enum class ResponseType {
        /**
         * Operation completed successfully
         */
        SUCCESS,

        /**
         * Operation failed due to insufficient funds
         */
        FAILURE_INSUFFICIENT_FUNDS,

        /**
         * Operation failed because the account does not exist
         */
        FAILURE_ACCOUNT_DOES_NOT_EXIST,

        /**
         * Operation failed for some other reason
         */
        FAILURE_GENERAL
    }
}