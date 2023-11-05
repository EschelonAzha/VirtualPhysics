package asymmetrical.wormholes.pulsar.plugins.galaxy.director.tasks

import asymmetrical.wormholes.pulsar.plugins.galaxy.WSServerPlugin
import asymmetrical.wormholes.pulsar.plugins.galaxy.WSTask
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet


class WSFramePongTask : WSTask {
    constructor(plugin: WSServerPlugin, outlet: IOutlet) : super(plugin, outlet){

    }
    override fun run() : Boolean {
        return false
    }
}