package symmetrical.dom

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class DomProperty(
    private val fermion: IQuantumEntanglement = QuantumEntanglement()
) : KeyValue(),
    IQuantumEntanglement by fermion {

    constructor() : this(QuantumEntanglement()) {

    }
    constructor(propertyName:String) : this() {
        setProperty(propertyName);
    }
    constructor(propertyName:String, value:String) : this() {
       setProperty(propertyName, value)
    }

    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

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
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(DomProperty::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

    fun setProperty(propertyName:String, value:String="") : DomProperty {
        add(QString(propertyName))
        add(QString(value))
        return this
    }
}