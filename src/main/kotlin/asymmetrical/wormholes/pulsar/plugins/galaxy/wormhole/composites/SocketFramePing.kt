package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites

import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.MaskLength
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits04.OpCodePing

class SocketFramePing : SocketFrameWriter {
    constructor() : super(OpCodePing(), MaskLength(0u)) {
    }
}