package symmetrical.dom.properties.region

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.dom.DomProperty

class DomWidth(
    private val matter: IMatter = Matter(DomWidth::class, DomWidth::class, true),
) : DomProperty(),
    IMatter by matter
{
    constructor() : this(
        Matter(DomWidth::class, DomWidth::class, true),
    )
    init {
        setProperty("width")
    }
    constructor(width:Int) : this() {
        setProperty("width", width.toString())
    }


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
}