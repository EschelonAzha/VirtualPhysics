package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites


import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits04.OpCodeText
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.MaskLength
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits16.ShortLength
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits32.IntLength

class SocketFrameText : SocketFrameWriter {

    constructor(payload:String) : super(OpCodeText(), MaskLength(0u), payload) {
        setPayloadLth()
    }
}