package asymmetrical.wormholes.pulsar.plugins.galaxy.director.inspectors

import asymmetrical.wormholes.pulsar.plugins.galaxy.WSInspector
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites.GenericSocketFrame
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.FinalOpCode

class WSFramePongInspector : WSInspector {

    constructor() : super() {
    }

    override fun inspect() : Int {
        val frame = GenericSocketFrame(message.getByteArray())
        val opCode = frame.getOpCode()
        if (opCode == FinalOpCode.Static.PONG) {
            println("**PONG")
            getPayload().add(frame.getPayload())
        }
        if (opCode != FinalOpCode.Static.PONG)
            return 0
        return 1
    }
}