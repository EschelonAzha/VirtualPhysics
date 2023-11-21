package symmetrical.cosmic._physics._subatomic.balanced

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Keys
import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Particle(
    private val fermion: IFermion = Fermion(Particle::class),
) :
    IFermion by fermion,
    IParticle,
    Emitter
{
    constructor() : this(
        Fermion(Particle::class),
    )
    object Static {
        const val UNIQUE_ID_LENGTH = 1
    }
    private var uniqueId = ""
    private lateinit var self : IParticle



    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        val (uniqueId, remainder) = Photons.parse(Static.UNIQUE_ID_LENGTH, photon.propagate().radiate())
        this.uniqueId = uniqueId
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val base52Lth = Base52.toFixedBase52(Static.UNIQUE_ID_LENGTH, uniqueId.length)
        return fermion.getClassId()+base52Lth+uniqueId
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun createUniqueId(): IParticle {
        uniqueId = Keys.getUniqueId()
        return getSelf()
    }

    override fun getSelf() : IParticle {
        if (::self.isInitialized)
            return self
        else return this
    }

    override fun getUniqueId(): String {
        return uniqueId
    }

    override fun setSelf(self: IParticle) : IParticle {
        this.self = self
        return getSelf()
    }
    fun setUniqueId(id:String) : IParticle {
        this.uniqueId = id
        return getSelf()
    }

}