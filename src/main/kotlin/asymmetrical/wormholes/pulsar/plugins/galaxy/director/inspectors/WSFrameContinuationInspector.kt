package asymmetrical.wormholes.pulsar.plugins.galaxy.director.inspectors

import asymmetrical.wormholes.pulsar.plugins.galaxy.WSInspector
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites.GenericSocketFrame
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.FinalOpCode

class WSFrameContinuationInspector : WSInspector {

    constructor() : super() {
    }

    override fun inspect() : Int {
        val frame = GenericSocketFrame(message.getByteArray())
        val opCode = frame.getOpCode()
        if (opCode == FinalOpCode.Static.CONTINUATION) {
            println("**CONTINUATION")
            getPayload().add(frame.getPayload())
        }
        if (opCode != FinalOpCode.Static.CONTINUATION)
            return 0
        return 1
    }
}