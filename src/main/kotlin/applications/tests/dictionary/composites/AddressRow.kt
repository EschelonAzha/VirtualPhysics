package applications.tests.dictionary.composites

import applications.tests.dictionary.atoms.Address
import applications.tests.dictionary.atoms.City
import applications.tests.dictionary.atoms.Name
import applications.tests.dictionary.atoms.State
import symmetrical.cosmic.chemistry.monomer.IMonomer
import symmetrical.cosmic.chemistry.monomer.Monomer
import symmetrical.cosmic.physics.atomic.substance.ions.Compound
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter

class AddressRow(name:String="",
                 address:String="",
                 city:String="",
                 state:String="",
                 private val monomer         : Monomer,
                 private val matterAntiMatter: IMatterAntiMatter,
) : Compound(),
    IMonomer by monomer,
    IMatterAntiMatter by matterAntiMatter
{
    object Static {

        const val NAME      : Int = Compound.Static.LAST+1
        const val ADDRESS   : Int = NAME+1
        const val CITY      : Int = ADDRESS+1
        const val STATE     : Int = CITY+1
        const val LAST      : Int = STATE+1

    }

    constructor() : this("", "","","") {

    }
    constructor(name:String, address:String, city:String, state:String) : this(
        name,
        address,
        city,
        state,
        Monomer(),
        MatterAntiMatter(AddressRow::class),
    ) {
        monomer.setSelf(this)
        add(Name      (name))
        add(Address   (address))
        add(City      (city))
        add(State     (state))
    }
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    fun getAddress() : Address {
        return get(Static.ADDRESS) as Address
    }
    fun getCity() : City {
        return get(Static.CITY) as City
    }
    fun getName() : Name {
        return get(Static.NAME) as Name
    }
    fun getState() : State {
        return get(Static.STATE) as State
    }

    fun print() : Unit {
        println(getName().getContent())
        println(getAddress().getContent())
        println(getCity().getContent())
        println(getState().getContent())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
}