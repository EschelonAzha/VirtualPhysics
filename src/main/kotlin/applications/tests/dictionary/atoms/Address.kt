package applications.tests.dictionary.atoms

import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.atoms.elements.Helium
import symmetrical.cosmic.physics.atomic.atoms.elements.Hydrogen
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

class Address(
    private val matterAntiMatter: IMatter = Matter().with(Address::class),
) : Helium(),
    IMatter by matterAntiMatter
{
    init {
        setContent("", true)
        protons(FieldNameProton().with("Address"))
    }

    fun with(value:String) : Address {
        setContent(value, true)
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }

}