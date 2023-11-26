package symmetrical.dom.properties.region

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import symmetrical.dom.DomProperty

class DomLeft(
    private val luminescent: ILuminescent = Luminescent(DomLeft::class),
) : DomProperty(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(DomLeft::class),
    )
    init {
        setProperty("left")
    }
    constructor(height:Int) : this() {
        setProperty("left", height.toString())
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