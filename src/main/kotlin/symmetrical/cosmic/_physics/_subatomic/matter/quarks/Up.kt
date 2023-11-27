package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Recycler
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Up(
    private val antiMatter: IAntiMatter = AntiMatter(Up::class),
) : Quark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Up::class),
    )
    init {
        setAntiMatter(AntiUp::class)
    }

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter .getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Up {
        super.i()
        return this
    }
    override fun dissipate() : Unit {
        Recycler.Up_dissipate(this)
    }
}