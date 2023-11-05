package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites

import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.MaskLength
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits04.OpCodeBinary
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits04.OpCodeText

class SocketFrameBinary : SocketFrameWriter {
    constructor(payload:String) : super(OpCodeBinary(), MaskLength(0u), payload) {
        setPayloadLth()
    }
}