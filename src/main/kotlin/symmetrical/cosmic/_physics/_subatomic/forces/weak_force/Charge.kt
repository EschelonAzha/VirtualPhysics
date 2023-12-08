package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Charge(
    private val antiMatter: IAntiMatter = AntiMatter(Charge::class, Charge::class, true),
)  : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Charge::class, Charge::class, true),
    )


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : Charge {
        return this
    }
}