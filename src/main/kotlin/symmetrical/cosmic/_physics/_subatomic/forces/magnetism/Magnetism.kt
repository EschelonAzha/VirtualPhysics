package symmetrical.cosmic._physics._subatomic.forces.magnetism

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class Magnetism(
    private val antiMatter: IAntiMatter = AntiMatter(Magnetism::class),
) : Energy(),
    IAntiMatter by antiMatter

{
    constructor() : this(
        AntiMatter(Magnetism::class),
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
        return antiMatter.getClassId()
    }
//    fun run() : Unit {
//        println("Magnetism")
//    }
}