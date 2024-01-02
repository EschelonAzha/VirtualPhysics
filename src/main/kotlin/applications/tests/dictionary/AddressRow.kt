package applications.tests.dictionary

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.substance.ions.Compound

class AddressRow : Compound {
    public val name    : Name
    public val address : Address
    public val city    : City
    public val state   : State
    constructor() {
        name    = add(Name("name")) as Name
        address = add(Address("address")) as Address
        city    = add(City("city")) as City
        state   = add(State("state")) as State
    }

    fun print() : Unit {
        println(name.getContent())
        println(address.getContent())
        println(city.getContent())
        println(state.getContent())
    }
}