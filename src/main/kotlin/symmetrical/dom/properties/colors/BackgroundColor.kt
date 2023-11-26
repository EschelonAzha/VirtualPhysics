package symmetrical.dom.properties.colors

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import symmetrical.dom.DomProperty

class BackgroundColor(
    private val luminescent: Luminescent = Luminescent(BackgroundColor::class),
) : DomProperty(),
    ILuminescent by luminescent
{

    constructor() : this(
        Luminescent(BackgroundColor::class),
    )
    init {
            setProperty("backgroundColor")
    }

    constructor(height:Int) : this() {
        luminescent.setKClass(BackgroundColor::class)
        getValue()!!.setQuarkValue(height.toString())
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