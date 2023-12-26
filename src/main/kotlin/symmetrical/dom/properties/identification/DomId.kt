package symmetrical.dom.properties.identification

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.dom.DomProperty

class DomId(
    private val matter: IMatter = Matter(DomId::class, DomId::class),
) : DomProperty(),
    IMatter by matter
{
    constructor() : this(
        Matter(DomId::class, DomId::class),
    )
    init {
        setProperty("id")
    }
    constructor(height:Int) : this() {
        setProperty("id", height.toString())
    }
    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }
}