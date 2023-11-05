package asymmetrical.wormholes.pulsar.plugins.galaxy.director.tasks

import asymmetrical.wormholes.pulsar.plugins.galaxy.WSServerPlugin
import asymmetrical.wormholes.pulsar.plugins.galaxy.WSTask
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
//TODO:
/*
    Although Binary Data seems to be sent correctly it doesn't seem to be received correctly
 */
class WSFrameBinaryTask : WSTask {
    constructor(plugin: WSServerPlugin, outlet: IOutlet) : super(plugin, outlet){

    }
    override fun run() : Boolean {
        getNebula().onMessage(getPayload().popLeft() as String)
        return false
    }
}