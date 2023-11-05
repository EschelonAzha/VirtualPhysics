package asymmetrical.wormholes.pulsar.plugins.galaxy.director.inspectors

import asymmetrical.wormholes.pulsar.plugins.galaxy.WSInspector
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites.GenericSocketFrame
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.FinalOpCode
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString

class WSFrameBinaryInspector : WSInspector {

    constructor() : super() {
    }

    override fun inspect() : Int {
        val frame = GenericSocketFrame(message.getByteArray())
        val opCode = frame.getOpCode()
        if (opCode == FinalOpCode.Static.BINARY) {
            println("**BINARY")
            getPayload().add(QString(frame.getPayload()))
        }
        if (opCode != FinalOpCode.Static.BINARY)
            return 0
        return 1
    }
}