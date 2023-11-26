package symmetrical.dom.properties.region

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import symmetrical.dom.DomProperty

class DomTop(
    private val luminescent: ILuminescent = Luminescent(DomTop::class),
) : DomProperty(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(DomTop::class),
    )
    init {
        setProperty("top")
    }
    constructor(height:Int) : this() {
        setProperty("top", height.toString())
    }


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}