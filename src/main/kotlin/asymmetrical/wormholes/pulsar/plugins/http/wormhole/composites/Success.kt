package asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites

import symmetrical.cosmic._physics.atomic.substance.ions.Compound

class Success : ResponseMessage {
    constructor(compound: Compound) : super("200", "OK") {
        addAll(compound)
        shrink()
    }
}