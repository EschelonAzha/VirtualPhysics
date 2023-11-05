package asymmetrical.wormholes.pulsar

import asymmetrical.wormholes.pulsar.plugins.galaxy.WSServerPlugin
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites.SocketFrameText
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic.cosmology.INebula

open class Nebula : WSServerPlugin, INebula {
    constructor() {
    }
    fun i(url:String) : Nebula {
        return this
    }
    override fun nextPhase() : INebula {
        return this
    }
    override fun send     (message:String)   : Boolean {
        val byteArray = SocketFrameText(Strings.scramble(message)).getByteArray()
        return !getOutlet().write(byteArray)
    }
}