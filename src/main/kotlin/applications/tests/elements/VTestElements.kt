package applications.tests.elements

import applications.tests.dictionary.atoms.Capacitor
import applications.tests.dictionary.atoms.Resistor
import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.atoms.elements.Helium
import symmetrical.cosmic.physics.subatomic.balanced.pairs.TauAntiTauPair

class VTestElements {

    fun test() : Boolean {

        if (!testElements()) {
            println("VTestElectronics::testElements FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        if (!emitAbsorbElements()) {
            println("VTestElectronics::testEmitAbsorbElements FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }
    private fun testElements() : Boolean {

        val helium: Helium = Helium().protons(FieldNameProton().with("Helium"))

        val fieldName = helium.getProton(FieldNameProton::class)
        val value     = fieldName.getValueQuark().getWavelength().getContent()


        return true

    }

    private fun emitAbsorbElements() : Boolean {
        val helium: Helium = Helium().protons(FieldNameProton().with("Helium"))

        val emission = helium.emit()
        val (clone, _) = Absorber.materialize(emission)

        val heliumClone = clone as Helium

        val fieldName = heliumClone.getProton(FieldNameProton::class)
        val value     = fieldName.getValueQuark().getWavelength().getContent()

        return true
    }

}