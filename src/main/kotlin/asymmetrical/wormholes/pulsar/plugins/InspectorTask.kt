package asymmetrical.wormholes.pulsar.plugins

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.Composition
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage

class InspectorTask : Composition {
    constructor(first: IParticle, last: IParticle) : super(first, last) {

    }
    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon  = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    fun setMessage(message: SocketMessage) : InspectorTask {
        (getFirst() as Inspector).setMessage(message)
        (getLast()  as Task).setMessage(message)
        return this
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(InspectorTask::class)
    }
    private fun radiate() : String {
        return  getLocalClassId()+
                super.emit().radiate()
    }
}