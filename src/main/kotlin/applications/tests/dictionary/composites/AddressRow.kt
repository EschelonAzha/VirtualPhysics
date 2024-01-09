package applications.tests.dictionary.composites

import applications.tests.dictionary.atoms.Address
import applications.tests.dictionary.atoms.City
import applications.tests.dictionary.atoms.Name
import applications.tests.dictionary.atoms.State
import symmetrical.cosmic.chemistry.monomer.IMonomer
import symmetrical.cosmic.chemistry.monomer.Monomer
import symmetrical.cosmic.physics.atomic.substance.ions.Compound

class AddressRow(name:String, address:String, city:String, state:String,  private val monomer: Monomer=Monomer()) : Compound(), IMonomer by monomer {
    public var name    : Name       = add(Name      (name))       as Name
    public var address : Address    = add(Address   (address))    as Address
    public var city    : City       = add(City      (city))       as City
    public var state   : State      = add(State     (state))      as State

    constructor(name:String, address:String, city:String, state:String) : this(name, address, city, state, Monomer()) {
        monomer.setSelf(this)
    }

    fun print() : Unit {
        println(name.getContent())
        println(address.getContent())
        println(city.getContent())
        println(state.getContent())
    }
}