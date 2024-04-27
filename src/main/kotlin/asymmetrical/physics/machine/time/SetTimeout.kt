package asymmetrical.physics.machine.time

import java.util.*

class SetTimeout {

    fun run(delay:Long, callback: () -> Unit) {
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                callback()
            }
        }

        timer.schedule(task, delay)
    }
}