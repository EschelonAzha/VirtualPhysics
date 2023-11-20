package symmetrical.cosmic._physics._subatomic.forces.strong_force

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


open class Strong(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : Energy(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    companion object {
        lateinit var strong : Strong

        fun setForce(strong: Strong) : Strong {
            Companion.strong = strong
            return strong
        }
    }


    private fun getLocalClassId() : String {
        return Absorber.getClassId(Strong::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
//    fun run() : Unit {
//        println("StrongForce")
//    }
}