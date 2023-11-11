package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__recycle.Recycler
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Up : Quark {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
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
        return Absorber.getClassId(Up::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Up {
        super.i()
        return this
    }
    override fun dissipate() : Unit {
        Recycler.Up_dissipate(this)
    }
}