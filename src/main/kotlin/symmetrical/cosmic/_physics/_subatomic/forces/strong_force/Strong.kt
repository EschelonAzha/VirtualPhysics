package symmetrical.cosmic._physics._subatomic.forces.strong_force

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class Strong(
    private val antiMatter: IAntiMatter = AntiMatter(Strong::class, Strong::class),
) : Energy(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Strong::class, Strong::class),
    )

    companion object {
        lateinit var strong : Strong

        fun setForce(strong: Strong) : Strong {
            Companion.strong = strong
            return strong
        }
    }


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
//    fun run() : Unit {
//        println("StrongForce")
//    }
}