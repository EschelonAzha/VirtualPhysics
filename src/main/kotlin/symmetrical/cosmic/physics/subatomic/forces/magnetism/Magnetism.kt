package symmetrical.cosmic.physics.subatomic.forces.magnetism

import asymmetrical.physics.machine.threads.Energy

/*
https://en.wikipedia.org/wiki/Magnetism
 */

open class Magnetism: Energy

{
    constructor() : super()

    // Spin 2
    companion object {
        lateinit var magnetism : Magnetism

        fun setForce(magnetism: Magnetism) : Magnetism {
            Companion.magnetism = magnetism
            return magnetism
        }
    }

//    fun run() : Unit {
//        println("Magnetism")
//    }
}