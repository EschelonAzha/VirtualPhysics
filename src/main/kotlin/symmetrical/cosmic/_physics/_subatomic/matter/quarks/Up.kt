package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Recycler
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon

class Up(
    private val matter: IMatter = Matter(Up::class, AntiUp::class),
) : Quark(),
    IMatter by matter
{
    constructor() : this(
        Matter(Up::class, AntiUp::class),
    )
    init {
    }
    constructor(baryon: Baryon) : this() {
        this._parent = baryon
    }
    override fun i() : Up {
        super.i()
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    override fun dissipate() : Unit {
        Recycler.Up_dissipate(this)
    }
    private fun radiate() : String {
        return matter .getClassId()+super.emit().radiate()
    }
}