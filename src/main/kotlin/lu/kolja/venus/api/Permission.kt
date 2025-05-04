package lu.kolja.venus.api



/**
 * Main interface allowing interaction with Venus
 */
interface Permission {

    fun name(): String
    fun isEnabled(): Boolean

}