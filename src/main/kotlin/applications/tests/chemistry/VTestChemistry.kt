package applications.tests.chemistry

import applications.tests.dictionary.atoms.City
import applications.tests.dictionary.atoms.Name
import applications.tests.dictionary.composites.AddressRow
import symmetrical.cosmic.chemistry.catalysts.Filter
import symmetrical.cosmic.chemistry.monomer.IMonomer
import symmetrical.cosmic.chemistry.polymer.Polymer

class VTestChemistry {
    private val polymer: Polymer = Polymer()
    constructor() {
        polymer.bind(AddressRow("name1", "address1", "city1", "state1"))
        polymer.bind(AddressRow("name2", "address1", "city1", "state1"))
        polymer.bind(AddressRow("name2", "address1", "city2", "state1"))
    }

    fun test() : Boolean {
        val result = Filter(polymer)
            .where(Name("name2"))
         //   .where(City("city2"))
            .activate() as Polymer


        return true
    }
}