package asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.fields.bits04

import symmetrical.cosmic._bitmaps.Bits04

class OpCodeClose : Bits04 {
    constructor() : super(0u) {
        this.setO(1)
    }
}