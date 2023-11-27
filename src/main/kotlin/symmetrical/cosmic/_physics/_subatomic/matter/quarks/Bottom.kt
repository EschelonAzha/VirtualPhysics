package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiBottom
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Bottom(
    private val antiMatter: IAntiMatter = AntiMatter(Bottom::class),
) : Quark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Bottom::class),
    )
    init {
        setAntiMatter(AntiBottom::class)
    }

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Bottom {
        super.i()
        return this
    }
}