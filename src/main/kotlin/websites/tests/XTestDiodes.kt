package websites.tests

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.dom.Dom
import symmetrical.dom.properties.region.DomHeight

object XTestDiodes {
    @JvmStatic
    fun main(args: Array<String>) {
        testDiodes()
    }



    private fun testDiodes() : Unit {
        val atom1: Atom = Atom("Atom1")
        val atom2: Atom = Atom("Atom2")
        val atom3: Atom = Atom("Atom3")
        atom1.diode_(atom2).diode(atom3)
        val pair: TauAntiTauPair = atom3.setCurrentValue("newValue")
        val pair2: TauAntiTauPair = atom1.setCurrentValue("jumby")

        val atom1Val1 = atom1.getCurrentValue()
        val atom2Val1 = atom2.getCurrentValue()
        val atom3Val1 = atom3.getCurrentValue()


        return;
    }
}