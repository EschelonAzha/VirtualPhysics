package symmetrical.cosmic._physics._subatomic.forces.magnetism

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class Magnetism(
    private val fermion: ILuminescent = Luminescent(Magnetism::class),
) : Energy(),
    ILuminescent by fermion

{
    constructor() : this(
        Luminescent(Magnetism::class),
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