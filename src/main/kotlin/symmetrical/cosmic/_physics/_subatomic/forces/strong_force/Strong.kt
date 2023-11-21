package symmetrical.cosmic._physics._subatomic.forces.strong_force

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Strong(
    private val fermion: IFermion = Fermion(Strong::class),
) : Energy(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Strong::class),
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