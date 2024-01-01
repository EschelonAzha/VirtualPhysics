package websites.tests

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.Atom

class VTestElectronics {
    val ATOM1:String = "Atom1"
    val ATOM2:String = "Atom2"
    val ATOM3:String = "Atom3"

    val ATOM1NEW:String = "Atom1NEW"
    val ATOM3NEW:String = "Atom3NEW"


    constructor() {

    }

    fun test() : Boolean {
        if (!testDiodes())
            println("VTestElectronics::testDiodes FAILED!!!!!!!!!!!!!!!!!!!!")
            return false

        return true
    }
    private fun testDiodes() : Boolean {
        val atom1: Atom = Atom(ATOM1)
        val atom2: Atom = Atom(ATOM2)
        val atom3: Atom = Atom(ATOM3)

        atom1.diode_(atom2).diode(atom3)

        val pair1 : TauAntiTauPair = atom3.setCurrentValue(ATOM3NEW)
        val pair2 : TauAntiTauPair = atom1.setCurrentValue(ATOM1NEW)

        val atom1Val1 = Atom.field(atom1).toString()
        val atom2Val1 = Atom.field(atom2).toString()
        val atom3Val1 = Atom.field(atom3).toString()

        if (atom1Val1!=ATOM1NEW)
            return false
        if (atom2Val1!=ATOM3NEW)
            return false
        if (atom3Val1!=ATOM3NEW)
            return false

        val lepton1     : String    = TauAntiTauPair.field(pair1).toString()
        val antiLepton1 : String    = TauAntiTauPair._field(pair1).toString()

        val lepton2     : String    = TauAntiTauPair.field(pair2).toString()
        val antiLepton2 : String    = TauAntiTauPair._field(pair2).toString()

        if (lepton1 != ATOM3NEW){
            return false
        }
        if (lepton2 != ATOM1NEW) {
            return false
        }
        if (antiLepton1 != ATOM3){
            return false
        }
        if (antiLepton2 != ATOM3NEW) {
            return false
        }
        return true
    }
}