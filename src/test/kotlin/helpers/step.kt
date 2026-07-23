package helpers

import io.qameta.allure.Allure

fun <T> step(name: String, block: () -> T): T =
    Allure.step(name, Allure.ThrowableRunnable<T> { block() })