package symmetrical.cosmic._physics._subatomic.forces.magnetism

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class Magnetism: Energy

{
    constructor() : super()

    // Spin 2
    companion object {
        lateinit var magnetism : Magnetism

        fun setForce(magnetism: Magnetism) : Magnetism {
            this.magnetism = magnetism
            return magnetism
        }
    }

//    fun run() : Unit {
//        println("Magnetism")
//    }
}