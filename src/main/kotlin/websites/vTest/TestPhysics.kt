package websites.vTest

import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.Atom
import websites.tests.VTestElectronics

object TestPhysics {
    @JvmStatic
    fun main(args: Array<String>) {
        VTestElectronics().test()
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