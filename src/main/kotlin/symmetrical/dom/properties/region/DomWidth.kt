package symmetrical.dom.properties.region

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.dom.DomProperty

class DomWidth(
    private val antiMatter: IAntiMatter = AntiMatter(DomWidth::class),
) : DomProperty(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(DomWidth::class),
    )
    init {
        setProperty("width")
    }
    constructor(width:Int) : this() {
        setProperty("width", width.toString())
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