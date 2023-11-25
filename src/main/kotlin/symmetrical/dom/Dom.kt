package symmetrical.dom

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class Dom(
    private val fermion: ILuminescent = Luminescent(Dom::class),
) : Atom(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Dom::class),
    )

    private var children  :Molecular     = Molecular()
    private var properties:DomProperties = DomProperties()



    override fun absorb(photon: Photon) : Photon {
        check(photon);

        val remainder = super.absorb(photon.propagate())
        var (children,   childrenRemainder) = Absorber.materialize(remainder.radiate())
        var (properties, propertiesRemainder) = Absorber.materialize(childrenRemainder)
        this.children   = children as Molecular
        this.properties = properties as DomProperties
        return Photon(propertiesRemainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()+super.emit().radiate()+children.emit().radiate()+properties.emit().radiate()
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }

    fun append(dom:Dom) : Dom {
        children.add(dom)
        return dom
    }
    fun get(pos:Int) : Dom {
        return children.get(pos) as Dom
    }
    fun addProperty(property:DomProperty) : DomProperty {
        properties.add(property)
        return property
    }

    fun getChildren() : Molecular {
        return children
    }
    fun getProperties() : DomProperties {
        return properties
    }
}