package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Recycler
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Up(
    private val luminescent: ILuminescent = Luminescent(Up::class),
) : Quark(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Up::class),
    )
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent .getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : Up {
        super.i()
        return this
    }
    override fun dissipate() : Unit {
        Recycler.Up_dissipate(this)
    }
}