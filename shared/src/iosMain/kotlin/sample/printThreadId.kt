package sample

import platform.Foundation.NSThread

internal actual fun printThreadInfo() {
    println("Thread: ${NSThread.currentThread}")
    println("Is main: ${NSThread.currentThread.isMainThread}")
}