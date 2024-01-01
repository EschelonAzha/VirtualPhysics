package symmetrical.cosmic._physics._subatomic.forces.gravity

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.bosons.Graviton
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
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
            this.gravity = gravity
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