package `11MenjalankanJob`

import kotlinx.coroutines.*

@OptIn(InternalCoroutinesApi::class)
fun main() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        delay(5000L)
        println("Start new Job!")
    }

    delay(2000L)
    job.cancel(cause = CancellationException("time is up"))
    println("Canceling job. . .")
    if (job.isCancelled){
        println("Job is canceled because ${job.getCancellationException().message}")
    }
}
