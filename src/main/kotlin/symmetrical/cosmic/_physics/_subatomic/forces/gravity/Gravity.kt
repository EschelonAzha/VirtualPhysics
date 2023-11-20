package symmetrical.cosmic._physics._subatomic.forces.gravity

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Graviton
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Gravity(
    private val fermion: IFermion = Fermion(),
) : Energy(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    // Spin 2

    private val gravitons : ArrayList<Graviton> = ArrayList<Graviton>()

    companion object {
        private lateinit var gravity : Gravity

        fun setForce(gravity: Gravity) : Gravity {
            this.gravity = gravity
            return gravity
        }
    }


    private fun getLocalClassId() : String {
        return Absorber.getClassId(Gravity::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
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