package sample

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Example {
    private val scope = MainScope(Dispatchers.Main)
    val client = HttpClient()

    fun callNetwork() {
        scope.launch {
            val breeds = client.get<String>("https://dog.ceo/api/breeds/list/all")
            println(breeds)
        }
    }

    fun callBackground() {
        scope.launch {
            doSomeBackgroundThing()
        }
    }

    private suspend fun doSomeBackgroundThing() = withContext(Dispatchers.Default) {
        println("Not main thread")
    }
}
