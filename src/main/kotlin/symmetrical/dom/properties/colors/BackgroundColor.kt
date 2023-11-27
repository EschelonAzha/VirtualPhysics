package symmetrical.dom.properties.colors

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.dom.DomProperty

class BackgroundColor(
    private val antiMatter: AntiMatter = AntiMatter(BackgroundColor::class),
) : DomProperty(),
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(BackgroundColor::class),
    )
    init {
            setProperty("backgroundColor")
    }

    constructor(height:Int) : this() {
        antiMatter.setKClass(BackgroundColor::class)
        getValue()!!.setQuarkValue(height.toString())
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