package hw1

import kotlin.reflect.full.declaredFunctions

interface TestRunner { fun <T>runTest(steps: T, test: () -> Unit) }


class MyTestRunner<T> : TestRunner {
    override fun <T> runTest(steps: T, test: () -> Unit) {
        if (steps != null) {
            val beforeMethods = steps!!::class.declaredFunctions
                .filter { it.name.startsWith("before") }

            beforeMethods.forEach { method ->
                method.call(steps)
            }
        }

        test.invoke()

        if (steps != null) {
            val afterMethods = steps!!::class.declaredFunctions
                .filter { it.name.startsWith("after") }

            afterMethods.forEach { method ->
                method.call(steps)
            }
        }
    }
}