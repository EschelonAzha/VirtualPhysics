package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites

import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.MaskLength
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits04.OpCodeClose

class SocketFrameClose : SocketFrameWriter {
    constructor() : super(OpCodeClose(), MaskLength(0u)) {
    }
}