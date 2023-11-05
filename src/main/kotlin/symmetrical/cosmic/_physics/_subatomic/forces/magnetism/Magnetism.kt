package symmetrical.cosmic._physics._subatomic.forces.magnetism

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


open class Magnetism : Energy {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    // Spin 2
    companion object {
        lateinit var magnetism : symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism

        fun setForce(magnetism: symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism) : symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism {
            symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism.Companion.magnetism = magnetism
            return magnetism
        }
    }
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
//    fun run() : Unit {
//        println("Magnetism")
//    }
}