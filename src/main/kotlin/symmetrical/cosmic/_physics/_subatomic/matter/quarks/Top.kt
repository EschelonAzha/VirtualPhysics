package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiTop
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Top(
    private val antiMatter: IAntiMatter = AntiMatter(Top::class, AntiTop::class),
) : Quark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Top::class, AntiTop::class),
    )

    init {

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
    override fun i() : Top {
        super.i()
        return this
    }
}