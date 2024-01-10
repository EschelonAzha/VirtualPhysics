package applications.tests.radiation

import symmetrical.cosmic.physics.atomic.atoms.Atom
import applications.tests.dictionary.atoms.Resistor
import applications.tests.dictionary.composites.AddressRow
import symmetrical.cosmic.absorber.Absorber

class VTestRadiation {
    val ATOM1:String = "!!!!!!!!!!!!!!!"
    val CITY :String = "???????????????"


    constructor() {

    }

    fun test() : Boolean {

        if (!testAddressEmission()) {
            println("VTestEmissions::testAddressEmission FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        if (!testEmissions()) {
            println("VTestEmissions::testEmissions FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }

    private fun testAddressEmission() : Boolean {
        val address = AddressRow("Bob", "main st", "New York", "NY")
        val emission = address.emit()

        val (clone, _) = Absorber.materialize(emission)

        val restored = clone as AddressRow

        val clonedName = restored.getName().getContent()
        val originalName = address.getName().getContent()
        return clonedName == originalName

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