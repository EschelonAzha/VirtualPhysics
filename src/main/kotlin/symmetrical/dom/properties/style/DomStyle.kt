package symmetrical.dom.properties.style

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.dom.DomProperty

class DomStyle(
    private val matter: IMatter = Matter(DomStyle::class, DomStyle::class),
) : DomProperty(),
    IMatter by matter
{
    constructor() : this(
        Matter(DomStyle::class, DomStyle::class),
    )
    init {
        setProperty("style")
    }
    constructor(style:Int) : this() {
        setProperty("style", style.toString())
    }


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (domPropertyId, remainder) = Strings.remainder(2, super.emit().radiate())
        return matter.getClassId()+remainder
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
}