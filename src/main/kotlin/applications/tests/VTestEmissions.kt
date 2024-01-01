package applications.tests

import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.Atom
import applications.tests.dictionary.City

class VTestEmissions {
    val ATOM1:String = "Atom1"
    val CITY :String = "New York City"


    constructor() {

    }

    fun test() : Boolean {
        if (!testEmissions()) {
            println("VTestElectronics::testDiodes FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }

    private fun testEmissions() : Boolean {
        val atom : Atom = Atom(ATOM1)
        val city : Atom = City(CITY)

        return true
    }

}