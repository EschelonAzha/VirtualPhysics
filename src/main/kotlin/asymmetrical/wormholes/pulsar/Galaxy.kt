package asymmetrical.wormholes.pulsar

import asymmetrical.machine.threads.Energy
import asymmetrical.wormholes.pulsar.plugins.galaxy.WSServerPlugin
import java.util.*

open class Galaxy : Energy {
    private var plugins   : Vector<WSServerPlugin> = Vector<WSServerPlugin>()
    private var additions : Vector<WSServerPlugin> = Vector<WSServerPlugin>()

    private var messageCount:Long = 0
    private var every             = 0

    constructor() {
    }
    fun add(plugin: WSServerPlugin) : WSServerPlugin {
        while (!acquireUpdate()){}
        additions.add(plugin)
        releaseUpdate()
        plugin.run()
        return plugin
    }
    fun remove(plugin: WSServerPlugin) : WSServerPlugin {
        while (!acquireUpdate()){}
        plugins.remove(plugin)
        releaseUpdate()
        return plugin
    }
    override fun run() : Unit {
        while (true) {
            while (!acquireRunning()){}
            var size :Int = plugins.size
            var i    :Int = 0
            while (i < size) {
                val plugin: WSServerPlugin = plugins[i] as WSServerPlugin
                deliverCrossSessionMail()
                size = plugins.size
                i++
            }
            addReadySessions()

            pause()
        }
        return;
    }
    fun showCount() : Unit {
        every++
        messageCount++
        if (every > 1000) {
            every = 0
            println("MessageCount=$messageCount")
        }
    }
    private fun addReadySessions() : Unit {
        for (i in 0 until additions.size) {
            val session:WSServerPlugin = additions[i]
            if (session.isLoggedIn()&&session.isSessionReady()) {
                plugins.add(session)
                additions.remove(session)
            }
        }
    }
    private fun deliverCrossSessionMail() : Unit {
    }
}