package symmetrical.dom.properties.style

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.dom.DomProperty

class DomStyle(
    private val antiMatter: IAntiMatter = AntiMatter(DomStyle::class),
) : DomProperty(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(DomStyle::class),
    )
    init {
        setProperty("style")
    }
    constructor(style:Int) : this() {
        setProperty("style", style.toString())
    }


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (domPropertyId, remainder) = Strings.remainder(2, super.emit().radiate())
        return antiMatter.getClassId()+remainder
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}