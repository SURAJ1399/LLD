package behavioral

class ChainOfResponsibility {
}


class ChainOfResponsibilityExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SupportCenterClient.handlerChain.apply {
                println(".....")
                receiveRequest(AbstractSupportCenter.Constants.GENERAL, "I'm having general issue.")
                println(".....")
                receiveRequest(AbstractSupportCenter.Constants.TECHNICAL, "I'm having technical issue.")
                println(".....")
                receiveRequest(AbstractSupportCenter.Constants.ADVANCE, "I'm having advance issue.")
                println(".....")
            }
        }
    }
}

/**
 * Base Support Center class for this Support System.
 *
 * @param _level Priority [_level]
 */
abstract class AbstractSupportCenter(private val _level: Int) {
    object Constants {
        /*Constants for Priority*/
        val GENERAL: Int = 1
        val TECHNICAL: Int = 2
        val ADVANCE: Int = 3
    }

    /*Store the next handler to pass request to the next handler - Chaining*/
    private var nextHandler: AbstractSupportCenter? = null

    /**
     * Set the next handler.
     *
     * @param handler [AbstractSupportCenter] instance.
     */
    open fun nextHandler(handler: AbstractSupportCenter) {
        this.nextHandler = handler
    }

    /**
     * Receive a request from the client.
     * If the requested [_level] is lower then [level]
     * handle the request else pass the request to
     * the next handler.
     *
     * @param level Priority [level].
     * @param message Message from client.
     */
    open fun receiveRequest(level: Int, message: String) {
        when (this._level <= level) {
            true -> handleRequest(message)
            else -> nextHandler?.receiveRequest(level, message)
                ?: kotlin.run { println("Next handler not found to handle this request.") }
        }
    }

    /*Should be implemented by the concrete classes*/
    protected abstract fun handleRequest(message: String)
}

class TechnicalSupportCenter(level: Int) : AbstractSupportCenter(level) {
    override fun handleRequest(message: String) {
        println("TechnicalSupportHandler: Processing request $message")
    }
}

class GeneralSupportCenter(level: Int) : AbstractSupportCenter(level) {
    override fun handleRequest(message: String) {
        println("GeneralSupportCenter: Processing request $message")
    }
}

class AdvanceSupportCenter(level: Int) : AbstractSupportCenter(level) {
    override fun handleRequest(message: String) {
        println("AdvanceSupportCenter: Processing request $message")
    }
}

/**
 * Support center client access point.
 */
object SupportCenterClient {
    val handlerChain: AbstractSupportCenter
        get() {
            val general = GeneralSupportCenter(AbstractSupportCenter.Constants.GENERAL)
            val technical = TechnicalSupportCenter(AbstractSupportCenter.Constants.TECHNICAL)
            val advance = AdvanceSupportCenter(AbstractSupportCenter.Constants.ADVANCE)
            /*Assign the next handler for the [GeneralSupportCenter]*/
            general.nextHandler(technical)
            /*Assign the next handler for the [TechnicalSupportCenter]*/
            technical.nextHandler(advance)
            return general
        }
}