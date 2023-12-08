package symmetrical.dom.properties.colors

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.dom.DomProperty

class BackgroundColor(
    private val matter: IMatter = Matter(BackgroundColor::class, BackgroundColor::class, true),
) : DomProperty(),
    IMatter by matter
{

    constructor() : this(
        Matter(BackgroundColor::class, BackgroundColor::class, true),
    )
    init {
            setProperty("backgroundColor")
    }

    constructor(height:Int) : this() {
        getValue()!!.setQuarkValue(height.toString())
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