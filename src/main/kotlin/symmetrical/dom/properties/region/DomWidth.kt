package symmetrical.dom.properties.region

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import symmetrical.dom.DomProperty

class DomWidth(
    private val luminescent: ILuminescent = Luminescent(DomWidth::class),
) : DomProperty(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(DomWidth::class),
    )
    init {
        setProperty("width")
    }
    constructor(width:Int) : this() {
        setProperty("width", width.toString())
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