package symmetrical.cosmic._physics._subatomic.forces.magnetism

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Magnetism(
    private val fermion: IFermion = Fermion(),
) : Energy()
{
    constructor() : this(
        Fermion()
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