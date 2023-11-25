package symmetrical.cosmic._physics._subatomic.forces.strong_force

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class Strong(
    private val fermion: ILuminescent = Luminescent(Strong::class),
) : Energy(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Strong::class),
    )

    companion object {
        lateinit var strong : Strong

        fun setForce(strong: Strong) : Strong {
            Companion.strong = strong
            return strong
        }
    }


    override fun getClassId() : String {
        return fermion.getClassId()
    }
//    fun run() : Unit {
//        println("StrongForce")
//    }
}