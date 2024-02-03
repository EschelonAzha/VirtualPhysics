package applications.tests.chemistry

import applications.tests.dictionary.atoms.City
import applications.tests.dictionary.atoms.Name
import applications.tests.dictionary.composites.AddressRow
import symmetrical.chemistry.catalysts.Filter
import symmetrical.chemistry.polymer.Polymer

class VTestChemistry {
    private val polymer: Polymer = Polymer()
    init {
        polymer.bind(AddressRow().with("name1", "address1", "city1", "state1"))
        polymer.bind(AddressRow().with("name2", "address1", "city1", "state1"))
        polymer.bind(AddressRow().with("name2", "address1", "city2", "state1"))
    }

    fun test() : Boolean {
        if (!testCatalyst()) {
            println("VTestChemistry::testCatalyst FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        return true
    }
    private fun testCatalyst() : Boolean {
        val result = Filter().with(polymer)
            .where(Name().with("name2"))
            .where(City().with("city2"))
            .activate() as Polymer

        return result.size() == 1
    }
}