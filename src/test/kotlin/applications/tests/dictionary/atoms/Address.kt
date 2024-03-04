package applications.tests.dictionary.atoms

import symmetrical.dictionary.protons.AccessLevelProton
import symmetrical.dictionary.protons.FieldNameProton
import symmetrical.physics.atomic.atoms.elements.Lithium
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

class Address(
    private val matterAntiMatter: IMatter = Matter().with(Address::class),
) : Lithium(),
    IMatter by matterAntiMatter
{
    init {
        setAtomicValue("", true)
        val fieldName   : Proton = FieldNameProton().with("Address")
        val accessLevel : Proton = AccessLevelProton().with(AccessLevelProton.Static.READ_ONLY)
        protons(fieldName, accessLevel)  //<---- when you add protons, don't forget to add getter functions
    }

    fun with(value:String) : Address {
        setAtomicValue(value, true)
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


    fun getAccessLevel() : Field {  //<--- Add these functions to easily get the extra protons
        return getProtonField(AccessLevelProton::class)
    }
    fun getFieldName() : Field {  //<--- Add these functions to easily get the extra protons
        return getProtonField(FieldNameProton::class)
    }


}