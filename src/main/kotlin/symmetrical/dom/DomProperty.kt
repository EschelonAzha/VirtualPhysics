package symmetrical.dom

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class DomProperty(
    private val luminescent: ILuminescent = Luminescent(DomProperty::class),
) : KeyValue(),
    ILuminescent by luminescent {

    constructor() : this(
        Luminescent(DomProperty::class),
    )
    constructor(propertyName:String) : this() {
        setProperty(propertyName);
    }
    constructor(propertyName:String, value:String) : this() {
       setProperty(propertyName, value)
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

    fun setProperty(propertyName:String, value:String="") : DomProperty {
        add(QString(propertyName))
        add(QString(value))
        return this
    }
}