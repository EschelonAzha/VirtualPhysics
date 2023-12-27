package symmetrical.dom

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics.atomic.atoms.Atom


open class Dom(
    private val matter: IMatter = Matter(Dom::class, Dom::class),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(Dom::class, Dom::class),
    )

    private var children  :Molecular     = Molecular()
    private var properties:DomProperties = DomProperties()

    override fun absorb(photon: Photon) : Photon {
        check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        var (children,   childrenRemainder) = Absorber.materialize(remainder.radiate())
        var (properties, propertiesRemainder) = Absorber.materialize(childrenRemainder)
        this.children   = children as Molecular
        this.properties = properties as DomProperties
        return Photon(propertiesRemainder)
    }
    fun append(dom:Dom) : Dom {
        children.add(dom)
        return dom
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun addProperty(property:DomProperty) : DomProperty {
        properties.add(property)
        return property
    }

    fun get(pos:Int) : Dom {
        return children.get(pos) as Dom
    }

    fun getChildren() : Molecular {
        return children
    }
    fun getProperties() : DomProperties {
        return properties
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()+children.emit().radiate()+properties.emit().radiate()
    }
}