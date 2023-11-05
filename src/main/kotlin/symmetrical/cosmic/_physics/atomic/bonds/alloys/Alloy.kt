package symmetrical.cosmic._physics.atomic.bonds.alloys

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.substance.Substance


open class Alloy(vararg mixtures: Substance) {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    var derived = ArrayList<Substance>()
    var mixture = ArrayList<Substance>()

    init {
        for (substance in mixtures) {
            substance.addDerived(substance)
            mixture.add(substance)
        }
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Alloy::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }

    fun getSubstance(pos:Int) : Substance {
        return this.mixture[pos]
    }

    open fun run() : Unit {
        println("I'm running");
    }
}