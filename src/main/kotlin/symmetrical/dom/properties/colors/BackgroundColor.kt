package symmetrical.dom.properties.colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion
import symmetrical.dom.DomProperty

class BackgroundColor(
    private val fermion: Fermion = Fermion(BackgroundColor::class),
) : DomProperty(),
    IFermion by fermion
{

    constructor() : this(
        Fermion(BackgroundColor::class),
    )
    init {
            setProperty("backgroundColor")
    }

    constructor(height:Int) : this() {
        fermion.setKClass(BackgroundColor::class)
        getValue()!!.setQuarkValue(height.toString())
    }

    private fun check(photon: Photon) : Unit {
        val classId = fermion.getClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

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