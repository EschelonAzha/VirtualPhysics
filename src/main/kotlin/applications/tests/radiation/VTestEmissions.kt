package applications.tests.radiation

import symmetrical.cosmic.physics.atomic.atoms.Atom
import applications.tests.dictionary.atoms.Resistor
import symmetrical.cosmic.absorber.Absorber

class VTestEmissions {
    val ATOM1:String = "!!!!!!!!!!!!!!!"
    val CITY :String = "???????????????"


    constructor() {

    }

    fun test() : Boolean {
        if (!testEmissions()) {
            println("VTestEmissions::testEmissions FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }

    private fun testEmissions() : Boolean {
        val atom : Atom = Atom(ATOM1)
        val city : Atom = Resistor(CITY)
                                                // Particles don't need JSON or XML to serialize themselves
                                                // and don't need 3rd party parsers such as GSON, or Jackson

        val atomEmission = atom.emit()  // Simply emit the particle to a super condensed photon emission
        val (atomClone, atomRemainder) = Absorber.materialize(atomEmission) // reabsorb it and make an
                                                                                           // Identical clone

                                                // JSON loses class information and requires parsing and reconstruction
                                                // of the class hierarchy
        val cityEmission = city.emit()  // Photon emission and absorption is built in and reconstructs
        val (cityClone, cityRemainder) = Absorber.materialize(cityEmission) // identical clones
                                                                                           // with no extra steps
        if ((cityClone as Atom).getField().toString() != city.getField().toString())
            return false

        if ((atomClone as Atom).getField().toString() != atom.getField().toString())
            return false

        return true
    }

    fun breakpoint() : Unit {
        return
    }

}