package symmetrical.cosmic._physics._subatomic.matter.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class WBosonPlus (
    private val fermion: ILuminescent = Luminescent(WBosonPlus::class),
) : Particle(),
    ILuminescent by fermion,
    Emitter
{
    // Carries the weak force
    // Spin -1
    constructor() : this(
        Luminescent(WBosonPlus::class),
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
    fun i() : WBosonPlus {
        return this
    }
}