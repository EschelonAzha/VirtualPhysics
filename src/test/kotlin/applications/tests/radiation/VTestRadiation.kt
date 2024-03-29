package applications.tests.radiation

import symmetrical.physics.atomic.atoms.Atom
import applications.tests.dictionary.atoms.Resistor
import applications.tests.dictionary.composites.AddressRow
import symmetrical.dictionary.absorber.Absorber

class VTestRadiation {
    val ATOM1:String = "!!!!!!!!!!!!!!!"
    val CITY :String = "???????????????"


    fun test() : Boolean {
        if (!testEmissions()) {
            println("VTestEmissions::testEmissions FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        if (!testAddressEmission()) {
            println("VTestEmissions::testAddressEmission FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        return true
    }

    private fun testAddressEmission() : Boolean {
        val address = AddressRow().with("Bob", "main st", "New York", "NY")
        val emission = address.emit()
        val (emitter, _) = Absorber.materialize(emission)
        val clone = emitter as AddressRow

        return address.getName().getContent().toString() == clone.getName().getContent().toString()

    }
    private fun testEmissions() : Boolean {
        val atom : Atom = Atom().with(ATOM1)
        val city : Atom = Resistor().with(CITY)
        atom.getSpace().setContent(city)
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

        val citySpace : Resistor = atomClone.getSpace().getContent() as Resistor
        return true
    }
}