package applications.tests.elements

import applications.tests.dictionary.atoms.Capacitor
import applications.tests.dictionary.atoms.Resistor
import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.dictionary.protons.AccessLevelProton
import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.atoms.elements.Helium
import symmetrical.cosmic.physics.atomic.atoms.elements.Lithium
import symmetrical.cosmic.physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

class VTestElements {

    fun test() : Boolean {


        if (!testElements()) {
            println("VTestElectronics::testElements FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }


    private fun testElements() : Boolean {
        val fieldName   : Proton    = FieldNameProton().with("Lithium")
        val accessLevel : Proton    = AccessLevelProton().with(AccessLevelProton.Static.READ_ONLY)
        val lithium     : Lithium   = Lithium().protons(fieldName, accessLevel)

        val emission = lithium.emit()
        val (clone, _) = Absorber.materialize(emission)

        val lithiumClone = clone as Lithium

        val fieldNameProton     :Proton     = lithiumClone.getProton(FieldNameProton::class)
        val accessLevelProton   :Proton     = lithiumClone.getProton(AccessLevelProton::class)
        val fieldNameClone            = fieldNameProton.getValueQuark().getWavelength().getContent()
        val accessLevelClone          = accessLevelProton.getValueQuark().getWavelength().getContent()

        if (fieldNameClone != "Lithium")
            return false
        if (accessLevelClone != AccessLevelProton.Static.READ_ONLY)
            return false

        return true
    }

}