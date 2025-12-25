import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

private val log = KotlinLogging.logger {}

suspend fun main() = coroutineScope {
    log.info { "Starting..." }
    log.debug { "Sleep now 2s" }
    delay(5000)
    println()
    log.debug { "Sleep 2s End" }
    log.info { "\"${getMyText()}\"\"" }
    delay(1000)
}