package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Charge(
    private val fermion: ILuminescent = Luminescent(Charge::class),
)  : Particle(),
    ILuminescent by fermion,
    Emitter
{
    constructor() : this(
        Luminescent(Charge::class),
    )


    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : Charge {
        return this
    }
}