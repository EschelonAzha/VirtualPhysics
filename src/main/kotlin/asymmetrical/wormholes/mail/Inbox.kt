package asymmetrical.wormholes.mail

import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage

class Inbox : Compound {
    constructor() {
    }

    override fun popLeft() : SocketMessage? {
        return super.popLeft() as SocketMessage?
    }
}