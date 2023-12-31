package symmetrical.dom.properties.colors

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.dom.DomProperty

class BackgroundColor(
    private val matter: IMatter = Matter(BackgroundColor::class, BackgroundColor::class),
) : DomProperty(),
    IMatter by matter
{

    constructor() : this(
        Matter(BackgroundColor::class, BackgroundColor::class),
    )
    init {
            setProperty("backgroundColor")
    }

    constructor(height:Int) : this() {
        val atom:Atom = getValue() as Atom
        Quark.value(atom).setWavelength(height.toString())
    }


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
}