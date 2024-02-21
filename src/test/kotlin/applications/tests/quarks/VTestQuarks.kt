package applications.tests.quarks

import applications.tests.dictionary.atoms.BookTitle
import applications.tests.dictionary.atoms.Capacitor
import applications.tests.dictionary.atoms.Resistor
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.pairs.TauAntiTauPair

class VTestQuarks {
    val ATOM1:String = "Atom1"


    fun test() : Boolean {

        if (!testFormat()) {
            println("VTestQuarks::testFormat FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        if (!testConstraints()) {
            println("VTestQuarks::testConstraints FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }
    private fun testFormat() : Boolean {
        val atom:Atom = BookTitle().with("Wizard Of Oz")

        val quoted = atom.format()

        return true
    }
    private fun testConstraints() : Boolean {


        return true
    }
}