package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Charge(
    private val luminescent: ILuminescent = Luminescent(Charge::class),
)  : Particle(),
    ILuminescent by luminescent,
    Emitter
{
    constructor() : this(
        Luminescent(Charge::class),
    )


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : Charge {
        return this
    }
}