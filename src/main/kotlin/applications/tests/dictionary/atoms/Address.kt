package applications.tests.dictionary.atoms

import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

class Address(
    private val matter: IMatter = Matter(Address::class, Address::class),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(Address::class, Address::class),
    )   init {
    Quark.value(this).setWavelength("")
}

    constructor(value:String) : this() {
        Quark.value(this).setWavelength(value)
    }

    override fun absorb(photon: Photon) : Photon {
        matter.check(photon)
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
        val classId = matter.getClassId()
        val atom = super.emit().radiate()
        return classId+atom
    }

}