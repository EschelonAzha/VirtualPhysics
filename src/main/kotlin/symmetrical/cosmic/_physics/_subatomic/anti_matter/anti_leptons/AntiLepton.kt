package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton


open class AntiLepton(
    private val antiMatter: IAntiMatter = AntiMatter(AntiLepton::class, Lepton::class),
) : Particle(),
    IAntiMatter by antiMatter,
    IEmitter
{
    constructor() : this(
        AntiMatter(AntiLepton::class, Lepton::class),
    )

    open fun i() : AntiLepton {
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }

}