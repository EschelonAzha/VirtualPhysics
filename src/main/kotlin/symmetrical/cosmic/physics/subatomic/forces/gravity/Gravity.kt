package symmetrical.cosmic.physics.subatomic.forces.gravity

import symmetrical.cosmic.physics.subatomic.bosons.Graviton

/*
https://en.wikipedia.org/wiki/Gravity
 */

open class Gravity {
    constructor()

    // Spin 2

    private val gravitons : ArrayList<Graviton> = ArrayList<Graviton>()

    companion object {
        private lateinit var gravity : Gravity

        fun setForce(gravity: Gravity) : Gravity {
            Companion.gravity = gravity
            return gravity
        }
    }

//    fun run() : Unit {
//        for (graviton in gravitons) {
//            graviton.attract()
//        }
//
//    }

    fun graviton(center: Graviton, attract:Unit, radial: Graviton) : Unit {
        val graviton = Graviton().i(center, attract, radial)
        gravitons.add(graviton)
        return attract
    }
}