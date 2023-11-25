package symmetrical.dom.properties.style

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import symmetrical.dom.DomProperty

class DomStyle(
    private val fermion: ILuminescent = Luminescent(DomStyle::class),
) : DomProperty(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(DomStyle::class),
    )
    init {
        setProperty("style")
    }
    constructor(style:Int) : this() {
        setProperty("style", style.toString())
    }


    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (domPropertyId, remainder) = Strings.remainder(2, super.emit().radiate())
        return fermion.getClassId()+remainder
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
}