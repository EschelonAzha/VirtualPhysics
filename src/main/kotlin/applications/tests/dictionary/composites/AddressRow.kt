package applications.tests.dictionary.composites

import applications.tests.dictionary.atoms.Address
import applications.tests.dictionary.atoms.City
import applications.tests.dictionary.atoms.Name
import applications.tests.dictionary.atoms.State
import symmetrical.chemistry.monomer.IMonomer
import symmetrical.chemistry.monomer.Monomer
import symmetrical.physics.atomic.substance.ions.Compound
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.Matter


class AddressRow(private val monomer         : Monomer = Monomer(),
                 private val matterAntiMatter: IMatter = Matter().with(AddressRow::class)
) : Compound(),
    IMonomer by monomer,
    IMatterAntiMatter by matterAntiMatter
{

    init {
        monomer.setSelf(this)
    }
    fun with(name:String, address:String, city:String, state:String) : AddressRow {
        add(Name().with(name))
        add(Address().with(address))
        add(City().with(city))
        add(State().with(state))
        return this
    }
    object Static {

        const val NAME      : Int = Compound.Static.LAST    +   1
        const val ADDRESS   : Int = NAME                    +   1
        const val CITY      : Int = ADDRESS                 +   1
        const val STATE     : Int = CITY                    +   1
        const val LAST      : Int = STATE                   +   1
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
        println(getName().toString())
        println(getAddress().toString())
        println(getCity().toString())
        println(getState().toString())
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