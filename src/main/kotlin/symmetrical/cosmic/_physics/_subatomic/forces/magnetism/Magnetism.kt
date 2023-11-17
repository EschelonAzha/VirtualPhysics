package symmetrical.cosmic._physics._subatomic.forces.magnetism

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement


open class Magnetism(
    private val entanglement: IQuantumEntanglement
) : Energy()
{
    constructor() : this(
        QuantumEntanglement()
    )

    // Spin 2
    companion object {
        lateinit var magnetism : Magnetism

        fun setForce(magnetism: Magnetism) : Magnetism {
            this.magnetism = magnetism
            return magnetism
        }
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Magnetism::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
//    fun run() : Unit {
//        println("Magnetism")
//    }
}