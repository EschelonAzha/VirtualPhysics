package symmetrical.cosmic.physics.subatomic.forces.strong_force

import asymmetrical.physics.machine.threads.Energy

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