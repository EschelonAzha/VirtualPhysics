package symmetrical.dom.properties.identification

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.dom.DomProperty

class DomId(
    private val antiMatter: IAntiMatter = AntiMatter(DomId::class),
) : DomProperty(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(DomId::class),
    )
    init {
        setProperty("id")
    }
    constructor(height:Int) : this() {
        setProperty("id", height.toString())
    }


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}