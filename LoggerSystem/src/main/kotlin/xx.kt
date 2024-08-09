enum class LogType(val key: Int) {
    DEBUG(1),
    INFO(2),
    ERROR(3),
    INVALID(0)
}

abstract class LoggerSystem(val mLogType: LogType) {

    private var nextRequestHandler: LoggerSystem? = null
    fun nextRequestHandler(nextRequestHandler: LoggerSystem) {
        this.nextRequestHandler = nextRequestHandler
    }

    fun receiver(logType: LogType) {
        if (logType == LogType.INVALID) {
            println("Invalid Request")
            return
        }
        when (mLogType.key == logType.key) {
            true -> handleRequest()
            false -> {
                println("Sent to $nextRequestHandler")
                nextRequestHandler?.receiver(logType)
            }
        }
    }

    abstract fun handleRequest()
}

class InfoLogger : LoggerSystem(LogType.INFO) {
    override fun handleRequest() {
        println("Info Log Handled")
    }

}

class ErrorLogger : LoggerSystem(LogType.ERROR) {
    override fun handleRequest() {
        println("Error Log Handled")
    }

}

class DebugLogger : LoggerSystem(LogType.DEBUG) {
    override fun handleRequest() {
        println("Debug Log Handled")
    }

}

object Logger {
    fun setup(): InfoLogger {
        val infoLogger = InfoLogger()
        val errorLogger = ErrorLogger()
        val debugLogger = DebugLogger()
        infoLogger.nextRequestHandler(errorLogger)
        errorLogger.nextRequestHandler(debugLogger)
        return infoLogger
    }

}


fun main() {
//    Logger.setup().apply {
//        receiver(LogType.ERROR)
//        receiver(LogType.DEBUG)
//        receiver(LogType.INFO)
//    }
     val x : ArrayList<Int> = arrayOfNulls<>(5)
}