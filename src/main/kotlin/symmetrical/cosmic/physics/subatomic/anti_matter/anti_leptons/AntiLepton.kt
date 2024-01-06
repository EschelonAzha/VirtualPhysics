package symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.leptons.Lepton

/*
https://en.wikipedia.org/wiki/Lepton
 */
open class AntiLepton(
    private val antiMatter: IAntiMatter = AntiMatter(AntiLepton::class, Lepton::class),
) : symmetrical.cosmic.physics.subatomic.balanced.Particle(),
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
        return antiMatter.getClassId()+
                super.emit().radiate()
    }

}