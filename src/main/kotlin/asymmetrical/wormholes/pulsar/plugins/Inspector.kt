package asymmetrical.wormholes.pulsar.plugins


import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.Beam
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage

open class Inspector : Particle, IEmitter {

    protected lateinit  var message : SocketMessage
    private             var payload : Beam = Beam(0)

    constructor()  {

    }
    fun addPayload(payload:String) : Inspector {
        this.payload.add(payload)
        return this
    }


    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Inspector::class)
    }
    fun getPayload() : Beam {
        return payload
    }
    open fun inspect() : Int {
        return 1
    }
    open fun setMessage(message: SocketMessage) : Inspector {
        this.message = message
        return this
    }

    private fun radiate() : String {
        return getLocalClassId();
    }
}