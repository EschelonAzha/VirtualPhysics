package asymmetrical.wormholes.pulsar.plugins.galaxy.director.inspectors

import asymmetrical.wormholes.pulsar.plugins.galaxy.WSInspector
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites.GenericSocketFrame
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits08.FinalOpCode

class WSFrameTextInspector : WSInspector {

    constructor() : super() {
    }

    override fun inspect() : Int {
        getPayload().clear()
        var frame = GenericSocketFrame(message.getByteArray())
        if (frame.getOpCode() != FinalOpCode.Static.TEXT) {
            return 0
        }

        getPayload().add(frame.getPayload())
        while (frame.hasRemainder()) {
            frame = GenericSocketFrame(frame.getRemainder())
            getPayload().add(frame.getPayload())
        }

        return getPayload().size()
    }
}