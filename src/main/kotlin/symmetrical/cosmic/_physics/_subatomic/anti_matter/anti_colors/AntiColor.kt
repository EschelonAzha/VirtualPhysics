package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

open class AntiColor : ChromoCharge {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
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
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiColor::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiColor {
        super.i()
        return this
    }
    override fun clone() : ChromoCharge {
        return AntiColor()
    }
}