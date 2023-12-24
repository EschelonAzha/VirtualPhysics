package asymmetrical.wormholes.pulsar.plugins.galaxy

import asymmetrical.wormholes.pulsar.plugins.Task
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet


open class WSTask : Task {
    private val plugin:WSServerPlugin

    constructor(plugin:WSServerPlugin, outlet: IOutlet) : super(outlet){
        this.plugin = plugin
    }
    fun getNebula() : INebula {
        return plugin
    }
    override fun run() : Boolean {
        return false
    }
}