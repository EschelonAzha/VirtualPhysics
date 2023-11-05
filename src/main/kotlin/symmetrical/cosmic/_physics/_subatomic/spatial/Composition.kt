package symmetrical.cosmic._physics._subatomic.spatial

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.bosons.Photon

open class Composition : ParticleBeam {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    object Static {
        const val FIRST  = ParticleBeam.Static.LAST + 1
        const val LAST  = ParticleBeam.Static.LAST + 2
    }
    constructor() {

    }
    constructor(first: IParticle, last: IParticle) : super(2) {
        add(first)
        add(last)
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Composition::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun getFirst() : IParticle {
        return get(Static.FIRST) as IParticle
    }
    fun getLast() : IParticle {
        return get(Static.LAST) as IParticle
    }
}