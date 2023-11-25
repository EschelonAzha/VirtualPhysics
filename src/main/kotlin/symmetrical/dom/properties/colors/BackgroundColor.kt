package symmetrical.dom.properties.colors

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import symmetrical.dom.DomProperty

class BackgroundColor(
    private val fermion: Luminescent = Luminescent(BackgroundColor::class),
) : DomProperty(),
    ILuminescent by fermion
{

    constructor() : this(
        Luminescent(BackgroundColor::class),
    )
    init {
            setProperty("backgroundColor")
    }

    constructor(height:Int) : this() {
        fermion.setKClass(BackgroundColor::class)
        getValue()!!.setQuarkValue(height.toString())
    }


    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
}