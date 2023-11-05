package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites

import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.MaskLength
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits04.OpCodePong

class SocketFramePong : SocketFrameWriter {
    constructor() : super(OpCodePong(), MaskLength(0u)) {
    }
}