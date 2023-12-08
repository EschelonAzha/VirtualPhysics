package symmetrical.cosmic._physics._subatomic.spacial

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class Composition(
    private val matter: IMatter = Matter(Composition::class, Composition::class, true),
) : ParticleBeam(),
    IMatter by matter
{
    constructor() : this(
        Matter(Composition::class, Composition::class, true),
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
        return matter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun getFirst() : IParticle {
        return get(Static.FIRST) as IParticle
    }
    fun getLast() : IParticle {
        return get(Static.LAST) as IParticle
    }
}