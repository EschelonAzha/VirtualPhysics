package asymmetrical.machine.threads

import asymmetrical.machine.config.Config

open class Energy : Thread  {
    @Volatile protected var running     = false
    @Volatile protected var updating    = false
    constructor() {
    }

    fun acquireUpdate() : Boolean {
        while (running) {
            Thread.sleep(Config.getUpdateSleep())
        }
        updating = true
        if (running) {  // got it too late
            updating = false
            return false
        }
        return true
    }
    fun acquireRunning() : Boolean {
        while (updating) {
            Thread.sleep(Config.getUpdateSleep())
        }
        running = true
        if (updating) { // got it too late
            running = false
            return false // try again.
        }
        return true
    }
    fun releaseUpdate() : Unit {
        updating = false
        return
    }
    fun releaseRunning() : Unit {
        running = false
        return
    }

    fun pause() : Unit {
        releaseRunning()
        Thread.sleep(Config.getThreadSleep())
        while (!acquireRunning()){}
    }

}