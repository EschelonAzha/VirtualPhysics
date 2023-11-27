package symmetrical.cosmic._physics._subatomic.matter.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class WBosonPlus (
    private val antiMatter: IAntiMatter = AntiMatter(WBosonPlus::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    // Carries the weak force
    // Spin -1
    constructor() : this(
        AntiMatter(WBosonPlus::class),
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
    fun i() : WBosonPlus {
        return this
    }
}