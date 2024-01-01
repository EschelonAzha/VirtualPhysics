package symmetrical.cosmic._physics._subatomic.forces.strong_force

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
/*
https://en.wikipedia.org/wiki/Strong_interaction
 */

open class Strong: Energy {
    constructor() : super()

    companion object {
        lateinit var strong : Strong

        fun setForce(strong: Strong) : Strong {
            Companion.strong = strong
            return strong
        }
    }

//    fun run() : Unit {
//        println("StrongForce")
//    }
}