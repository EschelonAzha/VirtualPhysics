package symmetrical.dom

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class DomProperty(
    private val matter: IMatter = Matter(DomProperty::class, DomProperty::class),
) : KeyValue(),
    IMatter by matter {

    constructor() : this(
        Matter(DomProperty::class, DomProperty::class),
    )
    constructor(propertyName:String) : this() {
        setProperty(propertyName);
    }
    constructor(propertyName:String, value:String) : this() {
       setProperty(propertyName, value)
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

    fun setProperty(propertyName:String, value:String="") : DomProperty {
        add(QString(propertyName))
        add(QString(value))
        return this
    }
}