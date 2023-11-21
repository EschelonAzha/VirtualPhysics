package symmetrical.cosmic._physics._subatomic.forces.magnetism

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Magnetism(
    private val fermion: IFermion = Fermion(Magnetism::class),
) : Energy(),
    IFermion by fermion

{
    constructor() : this(
        Fermion(Magnetism::class),
    )

    // Spin 2
    companion object {
        lateinit var magnetism : Magnetism

        fun setForce(magnetism: Magnetism) : Magnetism {
            this.magnetism = magnetism
            return magnetism
        }
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
//    fun run() : Unit {
//        println("Magnetism")
//    }
}