package sample

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class MainScope(private val mainContext: CoroutineContext) :
    CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = mainContext + job + exceptionHandler

    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        printThrowable(throwable)
        showError(throwable)
    }

    // TODO: Some way of exposing this to the caller without trapping a reference and freezing it.
    private fun showError(t: Throwable) {
        printThrowable(t)
    }

    fun onDestroy() {
        job.cancel()
    }
}

internal expect fun printThrowable(t: Throwable)