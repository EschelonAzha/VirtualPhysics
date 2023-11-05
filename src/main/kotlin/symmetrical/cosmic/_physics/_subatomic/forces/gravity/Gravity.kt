package symmetrical.cosmic._physics._subatomic.forces.gravity

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Graviton
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


open class Gravity : Energy {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    // Spin 2

    private val gravitons : ArrayList<Graviton> = ArrayList<Graviton>()

    companion object {
        private lateinit var gravity : symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity

        fun setForce(gravity: symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity) : symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity {
            symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity.Companion.gravity = gravity
            return gravity
        }
    }
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
//    fun run() : Unit {
//        for (graviton in gravitons) {
//            graviton.attract()
//        }
//
//    }

    fun graviton(center: Graviton, attract:Unit, radial: Graviton) : Unit {
        val graviton = Graviton().i(center, attract, radial)
        gravitons.add(graviton)
        return attract
    }
}