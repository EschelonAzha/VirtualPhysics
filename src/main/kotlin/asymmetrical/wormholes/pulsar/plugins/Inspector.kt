package asymmetrical.wormholes.pulsar.plugins


import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.Beam
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage

open class Inspector(private val particle: Particle = Particle()) : IParticle by particle, Emitter {

    protected lateinit var message          : SocketMessage

    private   var payload                   : Beam = Beam(0)

    constructor() : this(Particle()) {

    }
    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName);
        return;
    }

    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId();
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Inspector::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

    open fun inspect() : Int {
        return 1
    }
    fun getPayload() : Beam {
        return payload
    }
    open fun setMessage(message: SocketMessage) : Inspector {
        this.message = message
        return this
    }

    fun addPayload(payload:String) : Inspector {
        this.payload.add(payload)
        return this
    }


}