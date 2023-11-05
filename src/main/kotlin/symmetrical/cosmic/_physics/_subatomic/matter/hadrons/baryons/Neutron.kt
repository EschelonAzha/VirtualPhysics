package symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons


open class Neutron : Baryon {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    lateinit var __neutrons: Neutrons
    constructor()  {
        this.Neutron()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Neutron::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

    fun setNeutrons(neutrons:Neutrons) : Neutron {
        this.__neutrons = neutrons
        return this
    }
}