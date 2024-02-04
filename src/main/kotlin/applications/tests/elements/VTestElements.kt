package applications.tests.elements

import applications.tests.dictionary.atoms.Address
import applications.tests.dictionary.atoms.Capacitor
import applications.tests.dictionary.atoms.Resistor
import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.dictionary.protons.AccessLevelProton
import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.atoms.elements.Helium
import symmetrical.physics.atomic.atoms.elements.Lithium
import symmetrical.physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

class VTestElements {

    fun test() : Boolean {
        if (!testElements()) {
            println("VTestElectronics::testElements FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }
/*
            Elements act as a kind of run-time interface.   It ensures that the Element has the
            correct number of protons.   Hydrogen = 1, Helium = 2, Lithium = 3 ....

            The first proton always has the Value and is the minimum Atomic Number for an Atom
            The extra protons carry meta-data.   Effectively making all Atoms, self describing

            part of core Virtual Physics there will be the common attributes, Value, FieldName,
            AccessLevel, AliasName, (maybe Font, BackGroundColor....).  Application specific
            properties (Protons) can be added as part of the Application specific Dictionary
            as well.  (Examples coming soon).

            Not only are elements incredibly useful, they can all be emitted and absorbed so
            now you have the power to transmit self describing atoms that can be easily be
            absorbed on the receiving side without JSON or XML.  And you don't have to use
            anything to parse it.
 */

    private fun testElements() : Boolean {
        val lithium : Lithium = Address().with("Elements!") // Address has 3 Protons
                                                                  // Value, FieldName, AccessLevel


        val emission = lithium.emit()
        val (clone, _) = Absorber.materialize(emission)

        val lithiumClone = clone as Lithium

        val fieldNameClone      : String      = lithiumClone.getFieldName().toString()
        val accessLevelClone    : Int         = lithiumClone.getAccessLevel().toInt()
        val valueClone          : String      = lithiumClone.getValue().toString()

        if (valueClone != "Elements!")
            return false
        if (fieldNameClone != "Address")
            return false
        if (accessLevelClone != AccessLevelProton.Static.READ_ONLY)
            return false

        return true
    }

}