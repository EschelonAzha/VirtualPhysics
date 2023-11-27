package symmetrical.cosmic._physics._subatomic.spatial

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Composition(
    private val luminescent: ILuminescent = Luminescent(Composition::class),
) : ParticleBeam(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Composition::class),
    )


    object Static {
        const val FIRST  = ParticleBeam.Static.LAST + 1
        const val LAST  = ParticleBeam.Static.LAST + 2
    }

    constructor(first: IParticle, last: IParticle) : this() {
        add(first)
        add(last)
    }

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun getFirst() : IParticle {
        return get(Static.FIRST) as IParticle
    }
    fun getLast() : IParticle {
        return get(Static.LAST) as IParticle
    }
}